package com.gtm.exception;

public class MainException {

	/**
	 * @param args
	 */
	public static void main(String[] args){
		String name=null;
		try {
			if (name==null) {
			 throw new NullExceptionClass("name is not empty");
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

	}

}
