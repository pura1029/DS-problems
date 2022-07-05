package com.gtm.interview.cust.collection;

public class MyEntry<K, V> {

	private final K key;
	private V value;
	public MyEntry(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	@Override
	public String toString() {
		return "MyEntry [key=" + key + ", value=" + value + "]";
	}
	
	

}
