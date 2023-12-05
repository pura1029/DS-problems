/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.inttest;

/**
 * Insert your comment for {@link BinaryDecimalConverter}.
 *
 * @author kumargautam
 */
public class BinaryDecimalConverter {

    public long convertDecimalToBinary(long n) {

        long binaryNumber = 0;
        int remainder, i = 1, step = 1;
        while (n > 0) {
            remainder = (int) (n % 2);
            System.out.println("Step " + step++ + ": " + n + "/2");

            System.out.println("Quotient = " + n / 2 + ", Remainder = " + remainder);
            n /= 2;

            binaryNumber += remainder * i;
            i *= 10;
        }

        return binaryNumber;
    }


    public long convertBinaryToDecimal(long binary) {
        long sum = 0;
        int base = 1;
        while (binary > 0) {
            long remainder = binary % 10;
            sum = sum + (remainder * base);
            base *= 2;
            binary = binary / 10;
        }
        return sum;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        BinaryDecimalConverter converter = new BinaryDecimalConverter();
        long decimal = 8;
        long binary = converter.convertDecimalToBinary(decimal);
        System.out.println("Decimal value of " + decimal + ", binary is :" + binary);
        System.out.println("Binary No of " + binary + ", decimal is :" + converter.convertBinaryToDecimal(binary));
    }
}
