package munna.ds;

import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

public class CConHP<K, V> {

	final static float defalutLoadFactor = 0.75f;
	final static int defCapacity = 16;
	final static int size = 0;
	static final int DEFAULT_CONCURRENCY_LEVEL = 16;
	static final int MAX_SEGMENTS = 1 << 16;
	final int segmentShift;
	final int segmentMask;
	final Segment<K, V>[] segments;

	CConHP() {
		// Find power-of-two sizes best matching arguments
		int sshift = 0;
		int ssize = 1;
		while (ssize < DEFAULT_CONCURRENCY_LEVEL) {
			++sshift;
			ssize <<= 1;
		}
		System.out.println("[shift]"+sshift);
		System.out.println("[ssize]"+ssize);
		segmentShift = 32 - sshift;
		segmentMask = ssize - 1;
		System.out.println("[segmentShift]"+segmentShift);
		System.out.println("[segmentShift]"+segmentShift);
		this.segments = Segment.newArray(ssize);
		System.out.println("[segments.length]"+segments.length);
		// if (initialCapacity > MAXIMUM_CAPACITY)
		// initialCapacity = MAXIMUM_CAPACITY;
		int c = defCapacity / ssize;
		if (c * ssize < defCapacity)
			++c;
		int cap = 1;
		while (cap < c)
			cap <<= 1;
			
		System.out.println("[defalutLoadFactor]"+ defalutLoadFactor +"[ cap ]"+cap);
		for (int i = 0; i < this.segments.length; ++i)
			this.segments[i] = new Segment<K, V>(cap, defalutLoadFactor);
	}

	final Segment<K, V> segmentFor(int hash) {
		System.out.println(hash);
		System.out.println(segmentShift);
		System.out.println(segmentMask);
		System.out.println((hash >>> segmentShift) & segmentMask);
		return segments[(hash >>> segmentShift) & segmentMask];
	}

	public static void main(String[] args) {
		CConHP conHp = new CConHP();
		conHp.segmentFor(2000);

	}

	static final class HashEntry<K, V> {
		final K key;
		final int hash;
		volatile V value;
		final HashEntry<K, V> next;

		HashEntry(K key, int hash, HashEntry<K, V> next, V value) {
			this.key = key;
			this.hash = hash;
			this.next = next;
			this.value = value;
		}

		@SuppressWarnings("unchecked")
		static final <K, V> HashEntry<K, V>[] newArray(int i) {
			System.out.println("[HashEntry.length]"+i);
			return new HashEntry[i];
		}
	}

	static final class Segment<K, V> extends ReentrantLock implements
			Serializable {
		/*
		 * Segments maintain a table of entry lists that are ALWAYS kept in a
		 * consistent state, so can be read without locking. Next fields of
		 * nodes are immutable (final). All list additions are performed at the
		 * front of each bin. This makes it easy to check changes, and also fast
		 * to traverse. When nodes would otherwise be changed, new nodes are
		 * created to replace them. This works well for hash tables since the
		 * bin lists tend to be short. (The average length is less than two for
		 * the default load factor threshold.)
		 * 
		 * Read operations can thus proceed without locking, but rely on
		 * selected uses of volatiles to ensure that completed write operations
		 * performed by other threads are noticed. For most purposes, the
		 * "count" field, tracking the number of elements, serves as that
		 * volatile variable ensuring visibility. This is convenient because
		 * this field needs to be read in many read operations anyway:
		 * 
		 * - All (unsynchronized) read operations must first read the "count"
		 * field, and should not look at table entries if it is 0.
		 * 
		 * - All (synchronized) write operations should write to the "count"
		 * field after structurally changing any bin. The operations must not
		 * take any action that could even momentarily cause a concurrent read
		 * operation to see inconsistent data. This is made easier by the nature
		 * of the read operations in Map. For example, no operation can reveal
		 * that the table has grown but the threshold has not yet been updated,
		 * so there are no atomicity requirements for this with respect to
		 * reads.
		 * 
		 * As a guide, all critical volatile reads and writes to the count field
		 * are marked in code comments.
		 */

		private static final long serialVersionUID = 2249069246763182397L;

		/**
		 * The number of elements in this segment's region.
		 */
		transient volatile int count;

		/**
		 * Number of updates that alter the size of the table. This is used
		 * during bulk-read methods to make sure they see a consistent snapshot:
		 * If modCounts change during a traversal of segments computing size or
		 * checking containsValue, then we might have an inconsistent view of
		 * state so (usually) must retry.
		 */
		transient int modCount;

		/**
		 * The table is rehashed when its size exceeds this threshold. (The
		 * value of this field is always <tt>(int)(capacity *
		 * loadFactor)</tt>.)
		 */
		transient int threshold;

		/**
		 * The per-segment table.
		 */
		transient volatile HashEntry<K, V>[] table;

		/**
		 * The load factor for the hash table. Even though this value is same
		 * for all segments, it is replicated to avoid needing links to outer
		 * object.
		 * 
		 * @serial
		 */
		final float loadFactor;

		Segment(int initialCapacity, float lf) {
			loadFactor = lf;
			setTable(HashEntry.<K, V> newArray(initialCapacity));
		}

		@SuppressWarnings("unchecked")
		static final <K, V> Segment<K, V>[] newArray(int i) {
			return new Segment[i];
		}

		/**
		 * Sets table to new HashEntry array. Call only while holding lock or in
		 * constructor.
		 */
		void setTable(HashEntry<K, V>[] newTable) {
			threshold = (int) (newTable.length * loadFactor);
			System.out.println("[threshold of HashEntry ]"+threshold);
			table = newTable;
		}

		/**
		 * Returns properly casted first entry of bin for given hash.
		 */
		HashEntry<K, V> getFirst(int hash) {
			HashEntry<K, V>[] tab = table;
			return tab[hash & (tab.length - 1)];
		}

		/**
		 * Reads value field of an entry under lock. Called if value field ever
		 * appears to be null. This is possible only if a compiler happens to
		 * reorder a HashEntry initialization with its table assignment, which
		 * is legal under memory model but is not known to ever occur.
		 */
		V readValueUnderLock(HashEntry<K, V> e) {
			lock();
			try {
				return e.value;
			} finally {
				unlock();
			}
		}

		/* Specialized implementations of map methods */

		V get(Object key, int hash) {
			if (count != 0) { // read-volatile
				HashEntry<K, V> e = getFirst(hash);
				while (e != null) {
					if (e.hash == hash && key.equals(e.key)) {
						V v = e.value;
						if (v != null)
							return v;
						return readValueUnderLock(e); // recheck
					}
					e = e.next;
				}
			}
			return null;
		}

		boolean containsKey(Object key, int hash) {
			if (count != 0) { // read-volatile
				HashEntry<K, V> e = getFirst(hash);
				while (e != null) {
					if (e.hash == hash && key.equals(e.key))
						return true;
					e = e.next;
				}
			}
			return false;
		}

		boolean containsValue(Object value) {
			if (count != 0) { // read-volatile
				HashEntry<K, V>[] tab = table;
				int len = tab.length;
				for (int i = 0; i < len; i++) {
					for (HashEntry<K, V> e = tab[i]; e != null; e = e.next) {
						V v = e.value;
						if (v == null) // recheck
							v = readValueUnderLock(e);
						if (value.equals(v))
							return true;
					}
				}
			}
			return false;
		}

		boolean replace(K key, int hash, V oldValue, V newValue) {
			lock();
			try {
				HashEntry<K, V> e = getFirst(hash);
				while (e != null && (e.hash != hash || !key.equals(e.key)))
					e = e.next;

				boolean replaced = false;
				if (e != null && oldValue.equals(e.value)) {
					replaced = true;
					e.value = newValue;
				}
				return replaced;
			} finally {
				unlock();
			}
		}

		V replace(K key, int hash, V newValue) {
			lock();
			try {
				HashEntry<K, V> e = getFirst(hash);
				while (e != null && (e.hash != hash || !key.equals(e.key)))
					e = e.next;

				V oldValue = null;
				if (e != null) {
					oldValue = e.value;
					e.value = newValue;
				}
				return oldValue;
			} finally {
				unlock();
			}
		}

		V put(K key, int hash, V value, boolean onlyIfAbsent) {
			lock();
			try {
				int c = count;
				if (c++ > threshold) // ensure capacity
					rehash();
				HashEntry<K, V>[] tab = table;
				int index = hash & (tab.length - 1);
				HashEntry<K, V> first = tab[index];
				HashEntry<K, V> e = first;
				while (e != null && (e.hash != hash || !key.equals(e.key)))
					e = e.next;

				V oldValue;
				if (e != null) {
					oldValue = e.value;
					if (!onlyIfAbsent)
						e.value = value;
				} else {
					oldValue = null;
					++modCount;
					tab[index] = new HashEntry<K, V>(key, hash, first, value);
					count = c; // write-volatile
				}
				return oldValue;
			} finally {
				unlock();
			}
		}

		void rehash() {
			HashEntry<K, V>[] oldTable = table;
			int oldCapacity = oldTable.length;
			HashEntry<K, V>[] newTable = HashEntry.newArray(oldCapacity << 1);
			threshold = (int) (newTable.length * loadFactor);
			int sizeMask = newTable.length - 1;
			for (int i = 0; i < oldCapacity; i++) {
				// We need to guarantee that any existing reads of old Map can
				// proceed. So we cannot yet null out each bin.
				HashEntry<K, V> e = oldTable[i];

				if (e != null) {
					HashEntry<K, V> next = e.next;
					int idx = e.hash & sizeMask;

					// Single node on list
					if (next == null)
						newTable[idx] = e;

					else {
						// Reuse trailing consecutive sequence at same slot
						HashEntry<K, V> lastRun = e;
						int lastIdx = idx;
						for (HashEntry<K, V> last = next; last != null; last = last.next) {
							int k = last.hash & sizeMask;
							if (k != lastIdx) {
								lastIdx = k;
								lastRun = last;
							}
						}
						newTable[lastIdx] = lastRun;

						// Clone all remaining nodes
						for (HashEntry<K, V> p = e; p != lastRun; p = p.next) {
							int k = p.hash & sizeMask;
							HashEntry<K, V> n = newTable[k];
							newTable[k] = new HashEntry<K, V>(p.key, p.hash, n,
									p.value);
						}
					}
				}
			}
			table = newTable;
		}

		/**
		 * Remove; match on key only if value null, else match both.
		 */
		V remove(Object key, int hash, Object value) {
			lock();
			try {
				int c = count - 1;
				HashEntry<K, V>[] tab = table;
				int index = hash & (tab.length - 1);
				HashEntry<K, V> first = tab[index];
				HashEntry<K, V> e = first;
				while (e != null && (e.hash != hash || !key.equals(e.key)))
					e = e.next;

				V oldValue = null;
				if (e != null) {
					V v = e.value;
					if (value == null || value.equals(v)) {
						oldValue = v;
						// All entries following removed node can stay
						// in list, but all preceding ones need to be
						// cloned.
						++modCount;
						HashEntry<K, V> newFirst = e.next;
						for (HashEntry<K, V> p = first; p != e; p = p.next)
							newFirst = new HashEntry<K, V>(p.key, p.hash,
									newFirst, p.value);
						tab[index] = newFirst;
						count = c; // write-volatile
					}
				}
				return oldValue;
			} finally {
				unlock();
			}
		}

		void clear() {
			if (count != 0) {
				lock();
				try {
					HashEntry<K, V>[] tab = table;
					for (int i = 0; i < tab.length; i++)
						tab[i] = null;
					++modCount;
					count = 0; // write-volatile
				} finally {
					unlock();
				}
			}
		}

	}

}
