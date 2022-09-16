package com.gtm.ds.cache.dll.impl;

import com.gtm.ds.cache.dll.Cache;
import com.gtm.ds.cache.dll.EvictionPolicy;
import com.gtm.ds.cache.dll.Storage;
import com.gtm.ds.cache.dll.impl.LRUDdl.DLinkedNode;

public class LRUCache<K, V> implements Cache<K, V> {

	private final Storage<K, V> storage;
	private final EvictionPolicy<K, V> evictionPolicy;
	private int count;
	private final int capacity;

	public LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;
		this.storage = new LRUStorage<>();
		this.evictionPolicy = new LRUEvictionPolicy<>();
	}

	@Override
	public V get(K key) {
		if (!storage.containsKey(key)) {
			return null; // should raise exception here.
		}

		this.evictionPolicy.addToHead(storage.getNode(key));
		return storage.get(key);
	}

	@Override
	public void put(K key, V value) {
		DLinkedNode<K, V> node = storage.getNode(key);

		if (node == null) {

			this.storage.put(key, value);
			this.evictionPolicy.add(this.storage.getNode(key));
			++count;
			if (count > capacity) {
				// pop the tail
				DLinkedNode<K, V> tail = this.evictionPolicy.evict();
				this.storage.remove(tail.key);
				--count;
			}
		} else {
			// update the value.
			node.value = value;
			this.evictionPolicy.addToHead(node);
		}
	}

	@Override
	public void display() {
		this.storage.display();
	}
}
