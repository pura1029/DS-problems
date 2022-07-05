package com.gtm.collections.inte;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		Map<Object, Object> map = new LinkedHashMap<>();
		Emp e1 = new Emp();
		e1.setId(1);
		e1.setName("Ram");
		System.out.println(e1.hashCode());
		Emp e2 = new Emp();
		e2.setId(2);
		e2.setName("Ramu");
		System.out.println(e2.hashCode());
		Emp e3 = new Emp();
		e3.setId(11);
		e3.setName("Ram");
		System.out.println(e3.hashCode());

		map.put(e1, "emp1");
		map.put(e2, "emp2");
		map.put(e3, "emp3");
		map.put(1, "one");

		System.out.println(map);


	}	
}
