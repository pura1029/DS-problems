package com.gtm.collections;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("GAURAV");
		list.add("GAUTAM");
		Iterator<String> itl = list.iterator();
		list.add("GAUTAM");
		while(itl.hasNext()){
			System.out.println(itl.next());
		}
		System.out.println(list);
	}

}
