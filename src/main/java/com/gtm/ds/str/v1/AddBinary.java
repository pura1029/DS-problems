/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.str.v1;

/**
 * https://leetcode.com/problems/add-binary/.
 * https://www.youtube.com/watch?v=A4DYf6_M2tI
 *
 * @author kumargautam
 */
public class AddBinary {

    public static String addBinary(String a, String b) {
        /**
         * a=1010
         * b=1111
         *
         */
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int total = carry;
            if (i >= 0) {
                total += Integer.parseInt(String.valueOf(a.charAt(i--)));
            }
            if (j >= 0) {
                total += Integer.parseInt(String.valueOf(b.charAt(j--)));
            }
            stringBuilder.append(total % 2);
            carry = total / 2;
        }
        return stringBuilder.reverse().toString();
    }

    public static String addBinaryUsingByte(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }
            stringBuilder.append(carry % 2);
            carry = carry / 2;
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
        System.out.println(addBinaryUsingByte(a, b));
    }
}
