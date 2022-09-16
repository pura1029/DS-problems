package com.gtm.ds.cache.dll.impl;

import com.gtm.ds.cache.dll.EvictionPolicy;
import com.gtm.ds.cache.dll.impl.LRUDdl.DLinkedNode;

public class LRUEvictionPolicy<K, V> implements EvictionPolicy<K, V> {

	private final LRUDdl<K, V> ddl;

	public LRUEvictionPolicy() {
		this.ddl = new LRUDdl<>();
	}

	@Override
	public void add(DLinkedNode<K, V> node) {
		ddl.addNode(node);
	}

	@Override
	public DLinkedNode<K, V> evict() {
		return ddl.popTail();
	}

	@Override
	public void addToHead(DLinkedNode<K, V> node) {
		this.ddl.moveToHead(node);
	}

}
