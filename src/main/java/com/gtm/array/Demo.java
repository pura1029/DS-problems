package com.gtm.array;

public class Demo {

	static int hash = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = "FBb";
		System.out.println(hashCode(s1.toCharArray()));
		String s2 = "Eac";
		System.out.println(hashCode(s2.toCharArray()));
		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		System.out.println((int)'B');
		//2240
	}

	public static int hashCode(char[] value) {
		int h = 0;
		if (h == 0 && value.length > 0) {
			char val[] = value;

			for (int i = 0; i < value.length; i++) {
				h = 31 * h + val[i];
			}
			hash = h;
		}
		return h;
	}

}
