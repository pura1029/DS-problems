package com.gtm.array;

public class AddArray {


	// Wrapper Function
	public static int calSum(int a[], int b[], int n, int m){
		if(n >= m)
			return calSumUtil(a, b, n, m);
		else
			return calSumUtil(b, a, m, n);
	}

	// Wrapper Function
	public static int calSum1(int a[], int b[], int n, int m){
		if(n >= m)
			return calSumUtil1(a, b, n, m);
		else
			return calSumUtil1(b, a, m, n);
	}

	// Return sum of two number represented by the arrays.
	// Size of a[] is greater than b[]. It is made sure
	// be the wrapper function
	private static int calSumUtil(int a[], int b[], int n, int m){
		// array to store sum.
		int sum[] = new int[n];
		int i = n-1, j = m-1, k = n-1;
		int c = 0, s = 0;
		while (j >= 0) {
			s = a[i] + b[j] + c;
			sum[k] = s % 10;
			c = s/10;
			j--;
			i--;
			k--;
		}
		// If second array size is less the first array size.
		while (i >= 0) {
			s = a[i] + c;
			sum[k] = (s % 10);
			c = s / 10;

			i--;
			k--;
		}
		int ans = 0;

		// If there is carry on adding 0 index elements.
		// append 1 to total sum.
		if (c > 0)
			ans = 10;

		// Converting array into number.
		for (i = 0; i <= n - 1; i++) {
			ans += sum[i];
			ans *= 10;
		}
		return ans / 10;
	}

	private static int calSumUtil1(int a[], int b[], int n, int m){
		int i = 0, j = 0;
		int an = 0, bn = 0;
		while (i < n) {
			an = an * 10 + a[i];
			if(j < m){
				bn = bn * 10 + b[i];
				j++;
			}
			i++;
		}
		return (an + bn);
	}

	public static void main(String[] args) {
		int a[] = {9, 3, 9};
		int b[] = {6, 1};
		System.out.println("calSum "+calSum(a, b, a.length, b.length));
		System.out.println("calSum1 "+calSum1(a, b, a.length, b.length));
	}
}
