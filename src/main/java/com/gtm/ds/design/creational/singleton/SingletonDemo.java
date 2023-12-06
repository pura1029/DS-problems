/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.design.creational.singleton;

/**
 * Insert your comment for {@link SingletonDemo}.
 *
 * @author kumargautam
 */
public class SingletonDemo {

    public static void main(String[] args) {
        System.out.println("If you see the same value, then singleton was reused (yay!)" + "\n" +
                "If you see different values, then 2 singletons were created (booo!!)" + "\n\n" +
                "RESULT:" + "\n");
        Thread threadFoo = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println(singleton.hashCode());
        });
        Thread threadBar = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            System.out.println(singleton.hashCode());
        });
        threadFoo.start();
        threadBar.start();
    }
}
