package com.gtm.exception;
@SuppressWarnings({"unused","finally"})
public class TryCatchDemo {

	String retVal;
	
	public String dispReturnVal(){
		try {
			retVal="try";
			int a=10/0;
			return retVal;
		} catch (Exception e) {
			e.printStackTrace();
			retVal="catch";
			return retVal;
		}
		finally {
			retVal="finally";
			return retVal;
		}
	}
	public static void main(String[] args) {
		System.out.println(new TryCatchDemo().dispReturnVal());
	}
}
