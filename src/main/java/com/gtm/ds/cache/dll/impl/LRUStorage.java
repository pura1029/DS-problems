package com.gtm.ds.cache.dll.impl;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import com.gtm.ds.cache.dll.Storage;
import com.gtm.ds.cache.dll.impl.LRUDdl.DLinkedNode;

public class LRUStorage<K, V> implements Storage<K, V> {

	private final Map<K, DLinkedNode<K, V>> cache;

	public LRUStorage() {
		this.cache = new ConcurrentHashMap<>();
	}

	@Override
	public V get(K key) {
		if (this.containsKey(key)) {
			return cache.get(key).value;
		}
		return null;
	}

	@Override
	public void put(K key, V value) {
		DLinkedNode<K, V> node = new DLinkedNode<>(key, value);
		this.cache.put(key, node);
	}

	@Override
	public boolean containsKey(K key) {
		return cache.containsKey(key);
	}

	@Override
	public DLinkedNode<K, V> getNode(K key) {
		return cache.get(key);
	}

	@Override
	public boolean remove(K key) {
		if (this.containsKey(key)) {
			this.cache.remove(key);
			return true;
		}
		return false;
	}

	@Override
	public void display() {
		Iterator<Entry<K, DLinkedNode<K, V>>> itr = cache.entrySet().iterator();
		while (itr.hasNext()) {
			Entry<K, DLinkedNode<K, V>> entry = itr.next();
			System.out.println(entry.getKey() + "=" + entry.getValue().value);
		}
	}
}
