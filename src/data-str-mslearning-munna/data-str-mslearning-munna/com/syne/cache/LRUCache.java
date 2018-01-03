package com.syne.cache;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
	private int capacity; // Maximum number of items in the cache.

	public LRUCache(int capacity) {
		super(capacity + 1, 1.0f, true);
		// Pass 'true' for accessOrder.
		this.capacity = capacity;
	}

	/*protected boolean removeEldestEntry(Entry entry) {
		return (size() > this.capacity);
	}*/
	public static void main(String[] args) {
		//LinkedHashMap lkHm = new LinkedHashMap<Object,E>(fCacheSize, .75F, true);
		LRUCache lru = new LRUCache<String, String>(2);
		lru.put(1, "one");
		lru.put(2, "two");
		lru.put(3, "two");
		lru.put(4, "three");
		System.out.println(lru.capacity+"[]"+lru.size()+"[]"+lru);
		
		
		
		//System.out.println(lru.removeEldestEntry(lru.entrySet()));
	}
}


