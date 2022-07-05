package com.gtm.string;

public class ReverseString {

	public static String reverse(String str){ //"ramur"
		char ch[] = str.toCharArray();
		int i=0,n = ch.length-1;
		while(n > i){
			char temp = ch[i];
			ch[i] = ch[n];
			ch[n] = temp;
			i++;
			n = n-i;
		}
		return new String(ch);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse("ramus"));
	}

}
