package com.gtm.ds.inttest.ifelse;

public class AvoidIfElse {

	public static void main(String[] args) {

		SomeCondition condition = SomeCondition.CONDITION_ONE;

		MyClass myClass = new MyClass();
		myClass.decide(condition);
	}

}
