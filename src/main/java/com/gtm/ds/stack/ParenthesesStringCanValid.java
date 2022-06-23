package com.gtm.ds.stack;

public class ParenthesesStringCanValid {

	public boolean canBeValid(String s, String locked) {
		if (s.length() % 2 == 1) {
			return false;
		}
		int total = 0;
		int open = 0;
		int closed = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (locked.charAt(i) == '0')
				total += 1;
			else if (s.charAt(i) == '(')
				open += 1;
			else if (s.charAt(i) == ')')
				closed += 1;
			if (total - open + closed < 0)
				return false;
		}
		total = open = closed = 0;
		for (int i = 0; i < s.length(); i++) {
			if (locked.charAt(i) == '0')
				total += 1;
			else if (s.charAt(i) == '(')
				open += 1;
			else if (s.charAt(i) == ')')
				closed += 1;
			if (total + open - closed < 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "))()))";
		String locked = "010100";
		System.out.println(new ParenthesesStringCanValid().canBeValid(s, locked));
	}

}
