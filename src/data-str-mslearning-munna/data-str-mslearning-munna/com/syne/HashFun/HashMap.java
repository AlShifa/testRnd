package com.syne.HashFun;

public class HashMap {
	private final static int TABLE_SIZE = 128;
	HashEntry[] table;

	HashMap() {
		table = new HashEntry[128];// TABLE_SIZE
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	public int get(int key) {
		System.out.println("*********call key**********");
		int hash = (key % TABLE_SIZE);
		System.out.println(table[hash]);
		System.out.println(key);
		System.out.println(table[hash].getKey());
		while (table[hash] != null && table[hash].getKey() != key)
			hash = (hash + 1) % TABLE_SIZE;
		System.out.println(table[hash]);
		System.out.println(table[hash].getValue());
		if (table[hash] == null)
			return -1;
		else
			return table[hash].getValue();
	}

	public void put(int key, int value) {
		int hash = (key % TABLE_SIZE); // 250%128
		System.out.println("hash value key % TABLE_SIZE : " + hash);
		if (table[hash] != null) {
			System.out.println(table[hash]);
			System.out.println(table[hash].getKey());
		}
		System.out.println(hash);
		System.out.println(key);
		while (table[hash] != null && table[hash].getKey() != key) {
			System.out.println("inside while ");
			hash = (hash + 1) % TABLE_SIZE;

		}
		System.out.println(hash);
		table[hash] = new HashEntry(key, value);
	}

	public static void main(String arg[]) {
		HashMap hmap = new HashMap();
		hmap.put(250, 10);
		hmap.put(255, 11);
		// System.out.println(hmap.get(250));
		// System.out.println(hmap.get(255));

	}
}
