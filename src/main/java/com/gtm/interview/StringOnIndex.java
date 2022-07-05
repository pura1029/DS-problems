package com.gtm.interview;

public class StringOnIndex {

	public char findStr(String str,int index) throws Exception{
		char indCh = 0;
		int ch = 0;
		int sum = 0;
		if (index >= 0  && index <= str.length()) {
			for (int i = 0; i < str.length();i++) {
				sum = 2*i + 1;
				ch = (int)str.charAt(sum)-(int)'0';
				index = index - ch;
				if (index == 1 || index == 0){
					indCh = str.charAt(sum-1);
					break;
				}
			}
			return indCh;
		}else 
			throw new ArrayIndexOutOfBoundsException("index value <= "+str.length());
	}

	public static void main(String[] args) {
		StringOnIndex ss = new StringOnIndex();
		try {
			System.out.println("char on given index :"+ss.findStr("A1B2B1A3",8));//AABBBBAAA
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}

	}
}
