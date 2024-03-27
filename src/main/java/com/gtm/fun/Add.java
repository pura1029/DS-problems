/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.fun;

/**
 * Insert your comment for {@link Add}.
 *
 * @author kumargautam
 */
public interface Add {

    int apply(int a, int b);
}

class AddTest {
    public static void main(String[] args) {
        Add add = (a, b) -> a + b;
        System.out.println(add.apply(2, 3));
    }
}
