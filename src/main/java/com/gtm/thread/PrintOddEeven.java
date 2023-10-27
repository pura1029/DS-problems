package com.gtm.thread;

import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEeven {

    int upTo = 10;

    ReentrantLock lock = new ReentrantLock();
    int counter = 1;
    boolean isOdd = false;

    public void even() {
        while (counter < upTo) {
            try {
                lock.lock();
                if (counter % 2 == 0) {
                    System.out.println("Even : " + counter++);
                }
                isOdd = false;
            } catch (Exception e) {
                System.err.println(e);
            } finally {
                lock.unlock();
            }

        }

    }

    public void odd() {
        while (counter < upTo) {
            try {
                lock.lock();
                if (counter % 2 != 0) {
                    System.out.println("Odd : " + counter++);
                }
                isOdd = true;
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String[] args) {
        PrintOddEeven printOddEeven = new PrintOddEeven();
        Thread t1 = new Thread(() -> {
            printOddEeven.even();
        });
        Thread t2 = new Thread(() -> {
            printOddEeven.odd();
        });

        t1.start();
        t2.start();

    }

}
