package com.gtm.interview.cust.collection;

import java.io.Serializable;
import java.util.Arrays;

public class MyList<E> implements Serializable, Cloneable {

	/**
	 * serialVersionUID is used to check the class version
	 */
	private static final long serialVersionUID = -4188631600799694268L;
	private int size = 0;
	private static final int DEFAULT_CAPACITY = 10;
	private Object elements[];

	public MyList() {
		super();
		elements = new Object[DEFAULT_CAPACITY];
	}

	public void add(E e) {
		if (size + 1 == elements.length) {
			ensureCapa();
		}
		elements[size++] = e;
	}

	private void ensureCapa() {
		int newSize = elements.length * 2;
		elements = Arrays.copyOf(elements, newSize);
	}

	@SuppressWarnings("unchecked")
	public E get(int i) {
		if (i>= size || i <0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
		}
		return (E) elements[i];
	}

	@SuppressWarnings("unchecked")
	public E remove(int i) {
		if (i>= size || i <0) {
			throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
		}
		E temp = (E) elements[i];
		elements[i] = null;
		size--;
		condenseArray(i);
		return temp;
	}

	private void condenseArray(int start) {
		for (int i = start; i <= size; i++ ) {
			elements[i] = elements[i + 1];

		}
	}
	
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return (size == 0);
	}
	
	@Override
	public String toString() {
		return "MyList"+ Arrays.toString(elements);
	}

	public static void main(String[] args) {
		MyList<Integer> list = new MyList<>();
		System.out.println("is list empty "+list.isEmpty());
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(13);
		list.add(14);
		list.add(15);
		list.add(16);
		list.add(17);
		list.add(18);
		list.add(19);
		System.out.println(list);
		System.out.println("list size "+list.size());
		list.remove(0);
		System.out.println(list);
		System.out.println("list size "+list.size());
	}
	
	public  void main(int[] args) {
		
	}

	
}
