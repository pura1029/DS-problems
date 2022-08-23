package com.gtm.ds.inttest.ifelse;

public enum SomeCondition {
	CONDITION_ONE {
		
		@Override
		public void someMethod(MyClass myClass) {
			System.out.println("CONDITION_ONE :" + myClass.name);
		}
	},

	CONDITION_TWO {

		@Override
		public void someMethod(MyClass myClass) {
			System.out.println("CONDITION_TWO :" + myClass.name);
		}

	};

	public abstract void someMethod(MyClass myClass);

}