package com.gtm.ds.inttest;

public class BigNumber {

	Digit head;
	Digit tail;

	static class Digit {
		int no;
		Digit next;

		Digit(int no) {
			this.no = no;
			this.next = null;
		}
	}

	void append(int no) {
		Digit node = new Digit(no);
		if (head == null) {
			head = node;
			tail = node;
			return;
		}

		tail.next = node;
		tail = node;
	}

	public BigNumbeItr iterator() {
		return new BigNumbeItr();
	}

	public static BigNumber add(BigNumber no1, BigNumber no2) {
		BigNumber res = new BigNumber();
		StringBuilder builder1 = new StringBuilder();
		StringBuilder builder2 = new StringBuilder();
		BigNumbeItr numbeItr1 = no1.iterator();
		BigNumbeItr numbeItr2 = no2.iterator();
		while (!numbeItr1.end()) {
			builder1.append(numbeItr1.next());
		}

		while (!numbeItr2.end()) {
			builder2.append(numbeItr2.next());
		}

		if (builder1.length() > builder2.length()) {
			StringBuilder t = builder1;
			builder1 = builder2;
			builder2 = t;
		}

		int n1 = builder1.length();
		int n2 = builder2.length();

		builder1.reverse();
		builder2.reverse();

		StringBuilder resultBuilder = new StringBuilder();
		int carry = 0;
		for (int i = 0; i < n1; i++) {
			int sum = ((int) (builder1.charAt(i) - '0') + (int) (builder2.charAt(i) - '0') + carry);

			resultBuilder.append((char) (sum % 10 + '0'));

			// Calculate carry for next step
			carry = sum / 10;
		}

		for (int i = n1; i < n2; i++) {
			int sum = ((int) (builder2.charAt(i) - '0') + carry);
			resultBuilder.append((char) (sum % 10 + '0'));
			carry = sum / 10;
		}

		// Add remaining carry
		if (carry > 0) {
			resultBuilder.append((char) (carry + '0'));
		}

		resultBuilder.reverse();

		for (int i = 0; i < resultBuilder.length(); i++) {
			int r = resultBuilder.charAt(i) - '0';
			res.append(r);
		}

		return res;
	}

	public static int sum(int x, int y) {
		while (y != 0) {

			int carry = x & y;

			x = x ^ y;

			y = carry << 1;
		}

		return x;
	}

	private class BigNumbeItr {

		Digit lastReturned;

		BigNumbeItr() {
			lastReturned = head;
		}

		public int next() {
			int no = lastReturned.no;
			lastReturned = lastReturned.next;
			return no;
		}

		public boolean end() {
			return (lastReturned == null);
		}
	}

	public static void main(String[] args) {
		BigNumber no1 = new BigNumber();
		no1.append(9);
		no1.append(8);
		BigNumber no2 = new BigNumber();
		no2.append(1);
		no2.append(2);
		BigNumber res = add(no1, no2);
		BigNumbeItr numbeItr = res.iterator();
		while (!numbeItr.end()) {
			System.out.print(numbeItr.next());
		}
	}

}
