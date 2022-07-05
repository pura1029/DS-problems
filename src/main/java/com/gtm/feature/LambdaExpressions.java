package com.gtm.feature;

public class LambdaExpressions implements FunctionalInterface{

	@Override
	public void add(Object obj) {
		FunctionalInterface.list.add(obj);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FunctionalInterface f1 = (Object obj) -> {
			FunctionalInterface.list.add(obj);
		};
		LambdaExpressions le = new LambdaExpressions();
		le.add("Ram");
		le.add("Ramu");
		
		String s1 = f1.convert(FunctionalInterface.list);
		FunctionalInterface.show(s1);
		
		Runnable r1 = () -> {
			System.out.println("run method");
		};
		
		Thread t1 = new Thread(r1);
		t1.start();
	}



}
