package com.gtm.interview.cust.collection;

import java.util.ArrayList;
import java.util.ListIterator;

public class MyHashMapDemo {

	public static void main(String[] args) {
		MyMap<String, Object> map = new MyHashMap<>();
		map.put("a", 3);
		map.put("b", 4);
		System.out.println(map);
		map.remove("a");
		System.out.println(map);

		//iterator test
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		ListIterator<Integer> iterator = list.listIterator(list.size());
		//list.add(5);//throw java.util.ConcurrentModificationException
		System.out.println("before :"+list);
		while (iterator.hasPrevious()) {
			Integer integer = (Integer) iterator.previous();
			if (integer == 1) {
				iterator.remove();
				//list.add(5);////throw java.util.ConcurrentModificationException
				iterator.set(5);//java.lang.IllegalStateException
			}
			System.out.println(integer);
		}
		list.add(6);
		System.out.println("after :"+list);
	}
}

