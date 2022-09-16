package com.gtm.ds.cache.dll.impl;

public class LRUDdl<R, S> {

	private final DLinkedNode<R, S> head;
	private final DLinkedNode<R, S> tail;

	public LRUDdl() {
		this.head = new DLinkedNode<>();
		this.tail = new DLinkedNode<>();
		this.tail.pre = this.head;
		this.head.post = this.tail;
	}

	public static class DLinkedNode<K, V> {
		K key;
		V value;
		DLinkedNode<K, V> pre;
		DLinkedNode<K, V> post;

		DLinkedNode() {
			this.pre = null;
			this.post = null;
		}

		DLinkedNode(K key, V value) {
			this();
			this.key = key;
			this.value = value;
		}
	}

	/**
	 * Always add the new node right after head;
	 */
	public void addNode(R key, S value) {
		DLinkedNode<R, S> node = new DLinkedNode<>(key, value);

		this.addNode(node);
	}

	/**
	 * Always add the new node right after head;
	 */
	public void addNode(DLinkedNode<R, S> node) {
		node.pre = head;
		node.post = head.post;

		head.post.pre = node;
		head.post = node;
	}

	/**
	 * Remove an existing node from the linked list.
	 */
	public void removeNode(DLinkedNode<R, S> node) {
		DLinkedNode<R, S> pre = node.pre;
		DLinkedNode<R, S> post = node.post;

		pre.post = post;
		post.pre = pre;
	}

	/**
	 * Move certain node in between to the head.
	 */
	public void moveToHead(DLinkedNode<R, S> node) {
		this.removeNode(node);
		this.addNode(node);
	}

	// pop the current tail.
	public DLinkedNode<R, S> popTail() {
		DLinkedNode<R, S> res = tail.pre;
		this.removeNode(res);
		return res;
	}
}
