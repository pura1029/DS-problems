package com.gtm.ds.cache.dll;

import com.gtm.ds.cache.dll.impl.LRUDdl.DLinkedNode;

public interface Storage<K, V> {

	V get(K key);

	boolean remove(K key);

	void put(K key, V value);

	boolean containsKey(K key);

	DLinkedNode<K, V> getNode(K key);

	void display();
}
