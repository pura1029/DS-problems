/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.stream.fun;

/**
 * Insert your comment for {@link Add}.
 *
 * @author kumargautam
 */
@FunctionalInterface
public interface Add {

    int apply(int a, int b);

    //int sub(int a, int b);//Compile time error : Multiple override method found
}

class AddTest {
    public static void main(String[] args) {
        Add add = (a, b) -> a + b;
        System.out.println(add.apply(2, 3));
    }
}
