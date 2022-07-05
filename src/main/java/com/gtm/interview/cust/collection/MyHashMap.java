package com.gtm.interview.cust.collection;

import java.io.Serializable;
import java.util.Arrays;

public class MyHashMap<K, V> implements MyMap<K, V>, Serializable,Cloneable {

	/**
	 * my hash map class
	 */
	private static final long serialVersionUID = 1L;
	private int size;
	private int DEFAULT_CAPACITY = 16;
	private MyEntry<K, V>[] values = new MyEntry[DEFAULT_CAPACITY];

	@Override
	public V put(K key, V value) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				V oldVal;
				if ((oldVal = (V) values[i].getKey()).equals(key)) {
					values[i].setValue(value);
					return oldVal;
				}
			}
		}

		ensureCapa();
		values[size++] = new MyEntry<K, V>(key, value);
		return null;

	}

	private void ensureCapa() {
		if (size() + 1 == values.length) {
			int newSize = values.length * 2;
			values = Arrays.copyOf(values, newSize);
		}
	}

	@Override
	public V get(K key) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				if (values[i].getKey().equals(key)) {
					return values[i].getValue();
				}
			}
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void remove(K key) {
		for (int i = 0; i < values.length; i++) {
			if (values[i] != null) {
				if (values[i].getKey().equals(key)) {
					values[i] = null;
					size--;
					condenseArray(i);
				}
			}
		}

	}
	private void condenseArray(int start) {
		for (int i = start; i <= size; i++) {
			values[i] = values[i + 1];

		}
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "MyHashMap"+Arrays.toString(values);
	}



}
