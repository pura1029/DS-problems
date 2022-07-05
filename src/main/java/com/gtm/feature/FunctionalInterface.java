package com.gtm.feature;

import java.util.ArrayList;
import java.util.List;

public interface FunctionalInterface {
	
	static final List<Object> list = new ArrayList<>();

	static void show(String msg){

		System.out.println("Message :"+msg);
	}

	default String convert(Object msg){
		return msg.toString();
	}
	
	void add(Object obj);

	public static void main(String[] args) {
		FunctionalInterface.show("Hi java8");
	}
}
