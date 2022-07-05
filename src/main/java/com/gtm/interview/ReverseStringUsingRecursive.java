package com.gtm.interview;

public class ReverseStringUsingRecursive {

	public String getReverse(String word){
		if (word.length() == 1) {
			return word;
		}
		//return ((word.charAt(word.length()-1))+getReverse(word.substring(0, word.length()-1)));
		return (getReverse(word.substring(1)) + word.charAt(0));
	}
	public static void main(String[] args) {

		ReverseStringUsingRecursive recursive = new ReverseStringUsingRecursive();
		String reverse = recursive.getReverse("nitin");
		System.out.println("Reverse:"+reverse);
	}

}
