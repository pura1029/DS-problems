package com.gtm.interview.cust.collection;

public interface MyMap<K, V> {

	public V put(K key, V value);
	public V get(K key);
	public int size();
	public void remove(K key);

}
