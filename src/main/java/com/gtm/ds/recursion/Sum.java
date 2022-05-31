package com.gtm.ds.recursion;

public class Sum {

    static int compute(int n) {
        if (n == 0) {
            return 0;
        }

        return (n % 10) + compute((n / 10));
    }

    public static void main(String[] args) {
        System.out.println(compute(123));
    }

}
