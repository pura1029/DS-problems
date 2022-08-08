package com.gtm.ds.cache;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache<K, V> {

	// store keys of cache
	private Deque<K> doublyQueue;

	// store references of key in cache
	private Map<K, V> cache;

	// maximum capacity of cache
	private final int capacity;

	LRUCache(int capacity) {
		this.doublyQueue = new LinkedList<>();
		this.cache = new HashMap<>();
		this.capacity = capacity;
	}

	// This function returns false if key is not
	// present in cache. Else it moves the key to
	// front by first removing it and then adding
	// it, and returns true.
	public V get(K key) {
		if (!cache.containsKey(key)) {
			return null;
		}
		doublyQueue.remove(key);
		doublyQueue.addFirst(key);
		return cache.get(key);
	}

	public boolean containsKey(K key) {
		return (this.get(key) != null);
	}

	private void put(K key, V value) {

		if (doublyQueue.size() == capacity) {
			K lastKey = doublyQueue.removeLast();
			cache.remove(lastKey);
		}
		doublyQueue.addFirst(key);
		cache.put(key, value);
	}

	/* Refers key x with in the LRU cache */
	public void refer(K key, V value) {
		if (!this.containsKey(key)) {
			put(key, value);
		}
	}

	// displays contents of cache in Reverse Order
	public void display() {
		Iterator<K> itr = doublyQueue.iterator();
		while (itr.hasNext()) {
			K k = itr.next();
			System.out.println(k + "=" + cache.get(k));
		}
	}

	public static void main(String[] args) {
		LRUCache<Integer, String> ca = new LRUCache<>(4);
		ca.refer(1, "one");
		ca.refer(2, "two");
		ca.refer(3, "Three");
		System.out.println(ca.get(2));
		ca.refer(1, "one");
		ca.refer(4, "Four");
		ca.refer(5, "Five");
		ca.display();
	}

}
