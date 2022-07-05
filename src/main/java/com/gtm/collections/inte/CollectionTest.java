package com.gtm.collections.inte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class CollectionTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Emp e1 = new Emp();
		e1.setId(1);
		e1.setName("Ram");
		System.out.println(e1.hashCode());
		Emp e2 = new Emp();
		e2.setId(2);
		e2.setName("Ramu");
		System.out.println(e2.hashCode());

		Stu s1 = new Stu();
		s1.setId(1);
		s1.setName("Ram");
		System.out.println(s1.hashCode());
		Stu s2 = new Stu();
		s2.setId(2);
		s2.setName("Ramu");
		System.out.println(s2.hashCode());

		TreeSet treeSet = new TreeSet<>();
		//treeSet.add(null);
		//treeSet.add(null);
		//treeSet.add(e1); can't add because compareTO(.) method is not override
		//treeSet.add(e2);

		treeSet.add(s1); // able to add because compareTO(.) method is override
		treeSet.add(s2);

		TreeSet treeSet1 = new TreeSet<>(new ComparatorById());
		//treeSet.add(null);
		//treeSet.add(null);
		treeSet1.add(e1);
		treeSet1.add(e2);
		treeSet1.add(s1);
		treeSet1.add(s2);


		HashSet hashSet = new HashSet<>();
		hashSet.add(null);
		hashSet.add(null);
		hashSet.add(e1);
		hashSet.add(e2);
		hashSet.add(s1);
		hashSet.add(s2);

		TreeMap treeMap = new TreeMap<>();
		//treeMap.put(null, null);
		//treeMap.put(null, null);
		//treeMap.put(e1, null);// can't add because compareTO(.) method is not override
		//treeMap.put(e2, null);//can't add because compareTO(.) method is not override
		treeMap.put(s1, null);
		treeMap.put(s2, null);

		TreeMap treeMap2 = new TreeMap<>(new ComparatorById());
		treeMap2.put(e1, null);
		treeMap2.put(e2, null);
		treeMap2.put(s1, null);
		treeMap2.put(s2, null);
		
		System.out.println("Iterator over for each");
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		for (Integer integer : list) {
			//list.add(0); // java.util.ConcurrentModificationException
			System.out.println(integer);
		}
		
		Iterator<Integer> it = list.iterator();
		//list.add(0);
		while (it.hasNext()) {
			Integer integer = (Integer) it.next();
			if (integer == 1) {
				it.remove();
			}
			//list.add(0); // java.util.ConcurrentModificationException
			System.out.println(integer);
		}
		list.add(0);
		System.out.println(list);
		System.out.println("done");
		
		HashMap<String, Object> map1 = new HashMap<>();
		map1.put("one", 1);
		map1.put("two", 2);
		System.out.println("map1 "+map1);
		HashMap<String, Object> map2 = new HashMap<>();
		map2.putAll(map1);
		map2.put("one", 11);
		
		System.out.println("map1 "+map1);
		System.out.println("map2 "+map2);
		ArrayList<String> al = new ArrayList<>();
		al.add(null);
		String a = "aa";
		al.add("aa");
		if(al.contains(a))
			System.out.println("al contains");
		else
			System.out.println("al not contains");
	}


}
