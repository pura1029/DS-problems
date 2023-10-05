/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.recursion;

/**
 * Insert your comment for {@link RecursionTest}.
 *
 * @author kumargautam
 */
public class RecursionTest {

    public int test(int n) {
        if (n <= 1) {
            return 1;
        }
        return test(n - 1) + test(n - 2);
    }

    public static void main(String[] args) {
        RecursionTest test = new RecursionTest();
        System.out.println(test.test(6));
    }
}
