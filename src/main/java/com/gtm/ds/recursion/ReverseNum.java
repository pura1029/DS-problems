package com.gtm.ds.recursion;

public class ReverseNum {

    static int reverser(int n) {
        //no of digit
        int digit = (int) (Math.log10(n) + 1);

        return helper(n, digit);
    }

    private static int helper(int n, int digit) {
        if (n % 10 == n) {
            return n;
        }
        int rem = n % 10;
        return rem * (int) Math.pow(10, (double) digit - 1) + helper(n / 10, digit - 1);
    }

    public static void main(String[] args) {
        System.out.println(reverser(123));
    }

}
