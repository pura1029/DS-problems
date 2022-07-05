package com.gtm.collections.inte;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

	static int hash(int h) {  
		h ^= (h >>> 20) ^ (h >>> 12);  
		return h ^ (h >>> 7) ^ (h >>> 4);

	}

	public static void main(String[] args) {
		Map<Object, Object> map = new HashMap<>();
		Emp e1 = new Emp();
		e1.setId(1);
		e1.setName("Ram");
		System.err.println(e1.hashCode());
		Emp e2 = new Emp();
		e2.setId(2);
		e2.setName("Ramu");
		System.err.println(e2.hashCode());
		Emp e3 = new Emp();
		e3.setId(1);
		e3.setName("Ram");
		System.err.println(e3.hashCode());

		map.put(e1, "emp1");
		map.put(e2, "emp2");
		map.put(e3, "emp3");
		map.put(1, "one");

		System.out.println(map);
		
		int h = hash(32);
		
		System.err.println(h);
		System.out.println("sds "+map.get(44));

	}		



}
