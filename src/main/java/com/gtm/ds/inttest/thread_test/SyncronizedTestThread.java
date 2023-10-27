/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.inttest.thread_test;

/**
 * Insert your comment for {@link SyncronizedTestThread}.
 *
 * @author kumargautam
 */
public class SyncronizedTestThread {

    private int bal = 0;

    public void updateBal(int amount) {

        synchronized (this) {
            /*try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
            bal += amount;
        }
    }

    public synchronized void updateBal1(int amount) {
        bal += amount;
    }

    public static void main(String[] args) {
        SyncronizedTestThread testThread = new SyncronizedTestThread();

        Thread thread = new Thread(() -> {
            testThread.updateBal(1000);
        });

        Thread thread1 = new Thread(() -> {
            testThread.updateBal1(1000);
        });

        thread.start();
        /*try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        // if join called the bal = 2000 otherwise main thread print bal=1000
        testThread.bal = testThread.bal + 1000;
        System.out.println(testThread.bal);

        thread1.start();
        /*try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        // if join called the bal = 3000 otherwise main thread print bal=2000
        System.out.println(testThread.bal);
    }
}
