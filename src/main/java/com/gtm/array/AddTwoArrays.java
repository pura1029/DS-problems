package com.gtm.array;

public class AddTwoArrays {

	// Wrapper Function
	public static int calSum(int a[], int b[], int n, int m){
		if(n >= m)
			return calSumUtil(a, b, n, m);
		else
			return calSumUtil(b, a, m, n);
	}

	// Return sum of two number represented by the arrays.
	// Size of a[] is greater than b[]. It is made sure
	// be the wrapper function
	private static int calSumUtil(int a[], int b[], int n, int m){
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
		System.out.println("calSum1 "+calSum(a, b, a.length, b.length));
	}
}
