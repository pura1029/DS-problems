/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.inttest;

/**
 * Insert your comment for {@link NumberDigitTest}.
 *
 * @author kumargautam
 */
//https://www.geeksforgeeks.org/find-first-last-digits-number/
public class NumberDigitTest {

    public static int firstDigit1(int n) {
        // Remove last digit from number
        // till only one digit is left
        while (n >= 10)
            n /= 10;

        // return the first digit
        return n;
    }

    // Find the last digit
    public static int lastDigit1(int n) {
        // return the last digit
        return (n % 10);
    }

    // Find the first digit
    static int firstDigit(int n) {
        // Find total number of digits - 1
        int digits = (int) (Math.log10(n));

        // Find first digit
        n = (int) (n / (int) (Math.pow(10, digits)));

        // Return first digit
        return n;
    }

    // Find the last digit
    static int lastDigit(int n) {
        // return the last digit
        return (n % 10);
    }

    // Driver program
    public static void main(String args[]) {
        int n = 98562;
        System.out.println(firstDigit(n) +
                " " + lastDigit(n));
    }
}
