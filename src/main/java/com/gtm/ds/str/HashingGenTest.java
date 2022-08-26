package com.gtm.ds.str;

import java.io.Serializable;

public class HashingGenTest implements Comparable<HashingGenTest>, Serializable {

	private static final long serialVersionUID = 1L;
	String key = "name";
	String value = "avs";

	public static int hashStringIgnoreCase(final String str) {
		int hash = 0;
		if (str != null && !str.isEmpty()) {
			for (int i = 0; i < str.length(); i++) {
				hash = hash * 31 + Character.toUpperCase(str.charAt(i));
			}
		}
		return hash;
	}

	@Override
	public int hashCode() {
		int hash = 1;
		hash = 31 * hash + hashStringIgnoreCase(key);
		hash = 31 * hash + hashStringIgnoreCase(value);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		return obj == this || obj instanceof HashingGenTest && compareTo((HashingGenTest) obj) == 0;
	}

	public int compareTo(HashingGenTest oth) {
		int result = this.key.compareToIgnoreCase(oth.key);
		if (result == 0) {
			result = this.value.compareToIgnoreCase(oth.value);
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "ab";
		System.out.println(hashStringIgnoreCase(str));
		HashingGenTest genTest = new HashingGenTest();
		System.out.println(genTest.hashCode());
	}

}
