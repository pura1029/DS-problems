package com.gtm.ds.inttest;

import java.util.Arrays;
import java.util.Comparator;

public class ExceptionTest {

	private static String str = "1";

	public void test() {
		test1();
	}

	public void test1() {
		try {
			test2();
			str += 8;
		} catch (Exception e) {
			str += 6;
		}
		str += 7;
	}

	public void test2() throws Exception {
		try {
			str += 3;
			throw new Exception();
		} catch (Exception e) {
			str += 5;
			throw e;
		} finally {
			str += 4;
		}
		//str += 2;
	}

	public static void main(String[] args) {
		ExceptionTest exceptionTest=new ExceptionTest();
		exceptionTest.test();
		System.out.println(str);
		
		Integer[] arr = {2,4,3,1};
		
		Comparator<Integer> comparator=(n1,n2)->n2.compareTo(n1);
		Arrays.sort(arr,comparator);
		
		System.out.println(Arrays.toString(arr));
		
	}

}
