package com.gtm.interview;

public class ShiftString {

	public String shiftStr(String str){
		String newStr = new String();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (Character.toLowerCase(ch) == 'a') 
				newStr = ch + newStr;
			else if(Character.toLowerCase(ch) == 'b')
				newStr = newStr + ch;
		}
		return newStr;
	}

	public static void main(String[] args) {
		ShiftString ss = new ShiftString();
		System.out.println("new Str :"+ss.shiftStr("ABABBAABBBAAA"));

	}

}
