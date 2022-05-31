package com.gtm.ds.recursion;

public class Factorial {

    static int compute(int n) {
        if (n <= 1) {
            return 1;
        }

        return n * compute(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(compute(5));

    }

}
