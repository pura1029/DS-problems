package com.gtm.ds.inttest.thread_test;
// Java code to illustrate Reentrant Locks

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

//https://www.geeksforgeeks.org/reentrant-lock-java/
class Worker implements Runnable {
    String name;
    ReentrantLock lock;
    SimpleDateFormat ft;

    public Worker(String name) {
        this.name = name;
        lock = new ReentrantLock();
        ft = new SimpleDateFormat("hh:mm:ss");
    }

    public void run() {
        boolean done = false;
        while (!done) {
            //Getting Outer Lock
            boolean ans = lock.tryLock();

            // Returns True if lock is free
            if (ans) {
                try {
                    Date d = new Date();
                    System.out.println("task name - " + name
                            + " outer lock acquired at "
                            + ft.format(d)
                            + " Doing outer work");
                    Thread.sleep(1500);

                    // Getting Inner Lock
                    lock.lock();
                    try {
                        d = new Date();
                        System.out.println("task name - " + name
                                + " inner lock acquired at "
                                + ft.format(d)
                                + " Doing inner work");
                        System.out.println("Lock Hold Count - " + lock.getHoldCount());
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        //Inner lock release
                        System.out.println("task name - " + name +
                                " releasing inner lock");

                        lock.unlock();
                    }
                    System.out.println("Lock Hold Count - " + lock.getHoldCount());
                    System.out.println("task name - " + name + " work done");

                    done = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //Outer lock release
                    System.out.println("task name - " + name +
                            " releasing outer lock");

                    lock.unlock();
                    System.out.println("Lock Hold Count - " +
                            lock.getHoldCount());
                }
            } else {
                System.out.println("task name - " + name +
                        " waiting for lock");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ReentrantLockTest {
    static final int MAX_T = 2;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(MAX_T);
        Runnable w1 = new Worker("Job1");
        Runnable w2 = new Worker("Job2");
        Runnable w3 = new Worker("Job3");
        Runnable w4 = new Worker("Job4");
        pool.execute(w1);
        pool.execute(w2);
        pool.execute(w3);
        pool.execute(w4);
        pool.shutdown();
    }
}
