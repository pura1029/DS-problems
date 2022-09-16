package com.gtm.ds.cache.dll;

import com.gtm.ds.cache.dll.impl.LRUDdl.DLinkedNode;

public interface EvictionPolicy<K, V> {

	void add(DLinkedNode<K, V> node);
	
	void addToHead(DLinkedNode<K, V> node);

	DLinkedNode<K, V> evict();
}
