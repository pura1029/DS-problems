package com.gtm.ds.recursion;

public class Fibonacci {

    static int compute(int n) {
        if (n < 2) {
            return 1;
        }

        return compute(n - 1) + compute(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(compute(3));
    }

}
