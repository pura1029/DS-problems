package com.gtm.pattern;

public class MySingleton implements Cloneable{

	private static MySingleton mySingleton;
	private MySingleton(){
		System.out.println("DC");
	}
	static{
		mySingleton = new MySingleton();
	}

	public static MySingleton getInstance() {
		return mySingleton;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException  {
		throw new CloneNotSupportedException();
	}
	public static void main(String[] args) throws CloneNotSupportedException {

		MySingleton mySingleton = MySingleton.getInstance();
		System.out.println(mySingleton);
		MySingleton mySingleton2 = MySingleton.getInstance();
		MySingleton mySingleton3 = (MySingleton)mySingleton2.clone();//can't clone
		System.out.println(mySingleton2);
	}

}
