package com.gtm.feature;

import java.util.function.Predicate;

public class Java8PredicateExample {
	public static void main(String[] args)
	{ 
		Predicate<Integer> i =  p -> p > 100;
		boolean greaterCheckBoolean=greaterCheck(200,i); 
		System.out.println(greaterCheckBoolean);
	}

	public static boolean greaterCheck(int number,Predicate<Integer> predicate)
	{
		return predicate.test(number);
	}
}
