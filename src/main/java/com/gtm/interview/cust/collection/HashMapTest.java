package com.gtm.interview.cust.collection;

import java.util.Arrays;

public class HashMapTest<K,V> {

	private int size;
	private int DEFAULT_CAPACITY = 16;
	@SuppressWarnings("unchecked")
	private MyEntry<K, V>[] table = new MyEntry[DEFAULT_CAPACITY];

	public V put(K key, V value) {
		int hash = hash(key);
		int i = indexFor(hash, table.length);
		for (MyEntry<K,V> e = table[i]; e != null; e = e.next) {
			Object k;
			if (((k = e.key) == key || key.equals(k))) {
				V oldValue = e.value;
				e.value = value;
				return oldValue;
			}
		}
		ensureCapa();
		MyEntry<K,V> e = table[i];
		table[i] = new MyEntry<>(key, value, e);
		size++;
		return null;
	}

	public V get(Object key) {
		int hash = (key == null) ? 0 : hash(key);
		int i = indexFor(hash, table.length);
		for (MyEntry<K,V> e = table[i]; e != null; e = e.next) {
			Object k;
			if (((k = e.key) == key || key.equals(k))) {
				return e.value;
			}
		}
		return null;
	}

	public V remove(Object key) {
		int hash = (key == null) ? 0 : hash(key);
		int i = indexFor(hash, table.length);
		MyEntry<K,V> e = table[i];
		MyEntry<K,V> prev = e;
		while (e!=null) {
			MyEntry<K,V> next = e.getNext();
			Object k;
			if (((k = e.key) == key || key.equals(k))) {
				size--;
				if (prev == e)
					table[i] = next;
				else
					prev.next = next;
				return e.value;
			}
			prev = e;
			e = next;
		}
		return null;
	}

	@Override
	public String toString() {
		return "HashMapTest [table=" + Arrays.toString(table) + "]";
	}

	final int hash(Object k) {
		int h = 0;
		h ^= k.hashCode();
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	final int indexFor(int h, int length) {
		return h & (length-1);
	}

	private void ensureCapa() {
		if (size() + 1 == table.length) {
			int newSize = table.length * 2;
			table = Arrays.copyOf(table, newSize);
		}
	}

	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	public static void main(String[] args) {

		HashMapTest<String, String> map = new HashMapTest<>();
		map.put("a", "1");
		map.put("b", "2");
		map.put("c", "3");
		System.out.println(map.toString());
		System.out.println(map.get("b"));
		System.out.println(map.remove("b"));
		System.out.println(map.toString());
	}

	static class MyEntry<K, V> {

		private final K key;
		private V value;
		private MyEntry<K, V> next;
		public MyEntry(K key, V value,MyEntry<K, V> next) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
		}
		public V getValue() {
			return value;
		}
		public void setValue(V value) {
			this.value = value;
		}
		public K getKey() {
			return key;
		}

		public MyEntry<K, V> getNext() {
			return next;
		}
		public void setNext(MyEntry<K, V> next) {
			this.next = next;
		}
		@Override
		public String toString() {
			return "MyEntry [key=" + key + ", value=" + value + "]";
		}
	}

}
