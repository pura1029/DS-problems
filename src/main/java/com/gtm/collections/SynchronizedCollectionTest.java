package com.gtm.collections;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public class SynchronizedCollectionTest {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put(1, "Ram");
		map.put(2, "Ram1");
		map.put(3, "Ram2");
		map = Collections.synchronizedMap(map);
		Set set = map.keySet();
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			int key = (int) iterator.next();
			String val = (String) map.get(key);
			System.out.println(key + " = " + val);
		}
		System.out.println("ConcurrentHashMap ex");
		Map conMap = new ConcurrentHashMap();
		
		conMap.put(1, "Ram");
		conMap.put(2, "Ram1");
		conMap.put(3, "Ram2");
		Set set1 = conMap.keySet();
		Iterator iterator1 = set1.iterator();
		while (iterator1.hasNext()) {
			int key = (int) iterator1.next();
			String val = (String) conMap.get(key);
			System.out.println(key + " = " + val);
		}
		
		Set jset = new HashSet();
		jset.add(1);
		jset.add(1);
		jset.add(1);
		System.out.println("jset "+jset);
	}

}
