package com.gtm.ds.cache.test;

//https://leetcode.com/problems/lru-cache/solutions/45939/laziest-implementation-java-s-linkedhashmap-takes-care-of-everything/
public class LRUCache<K, V> {
    private int capacity, count;
    private DDLStorage<K, V> storage;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.storage = new DDLStorage<>();
    }

    public V get(K key) {
        DDLStorage.Node n = storage.getNode(key);
        if (null == n) {
            return null;
        }
        storage.update(n);
        return (V) n.value;
    }

    public void put(K key, V value) {
        DDLStorage.Node n = storage.getNode(key);
        if (null == n) {
            n = new DDLStorage.Node(key, value);
            storage.putNode(key, n);
            storage.add(n);
            ++count;
        } else {
            n.value = value;
            storage.update(n);
        }
        if (count > capacity) {
            DDLStorage.Node<K, V> toDel = storage.getTail();
            storage.remove(toDel);
            storage.removeNode(toDel.key);
            --count;
        }
    }

    public void display() {
        storage.display();
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);

        cache.put(1, "one");//1
        cache.put(2, "two");//2,1
        cache.put(3, "Three");//3,2,1
        System.out.println(cache.get(2));//2,3,1
        cache.put(1, "one");//1,2,3
        cache.put(4, "Four");//4,1,2
        cache.put(5, "Five");//5,4,1
        cache.display();
    }
}