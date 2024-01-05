/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.cache.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author kumargautam
 */
public class DDLStorage<K, V> {

    private Map<K, Node<K, V>> cache;
    private Node head, tail;

    public DDLStorage() {
        cache = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public Node<K, V> getNode(K key) {
        return cache.get(key);
    }

    public void putNode(K key, Node<K, V> node) {
        this.cache.put(key, node);
    }

    public boolean removeNode(K key) {
        if (cache.containsKey(key)) {
            this.cache.remove(key);
            return true;
        }
        return false;
    }

    public void update(Node<K, V> node) {
        remove(node);
        add(node);
    }

    public void add(Node<K, V> node) {//null->1->null add 2 : null->2->1->null
        Node after = head.next;
        head.next = node;
        node.prev = head;
        node.next = after;
        after.prev = node;
    }

    public void remove(Node<K, V> node) { // null->2->1->null remove 1 :
        Node before = node.prev, after = node.next;
        before.next = after;
        after.prev = before;
    }

    public DDLStorage.Node<K, V> getTail() {
        return tail.prev;
    }

    public void display() {
        Iterator<Map.Entry<K, Node<K, V>>> itr = cache.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<K, Node<K, V>> entry = itr.next();
            System.out.println(entry.getKey() + "=" + entry.getValue().value);
        }
    }

    public static class Node<K, V> {
        K key;
        V value;
        Node prev, next;

        Node(K k, V v) {
            this();
            this.key = k;
            this.value = v;
        }

        Node() {
            prev = null;
            next = null;
        }
    }
}
