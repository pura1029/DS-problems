package com.gtm.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OddEvenRunnable implements Runnable {

    public int PRINT_NUMBERS_UPTO = 10;
    static int number = 1;// static variable value sharable for objects of class.
    static Object lock = new Object();

    int remainder;

    OddEvenRunnable(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO) {
            synchronized (lock) {
                while (number % 2 != remainder) { // wait for numbers other than remainder
                    try {
                        System.out.println(Thread.currentThread().getName() + " waiting");
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                System.out.println(Thread.currentThread().getName() + " notify");
                lock.notifyAll();
            }
        }

    }

    public static void main(String[] args) {
        OddEvenRunnable oddRunnable = new OddEvenRunnable(1);
        OddEvenRunnable evenRunnable = new OddEvenRunnable(0);

        Thread t1 = new Thread(oddRunnable, "Odd");
        Thread t2 = new Thread(evenRunnable, "Even");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        ExecutorService executorService2 = Executors.newCachedThreadPool();

        executorService.shutdown();
        executorService2.shutdown();

        ExecutorService executorService1 =
                new ThreadPoolExecutor(1, 1, 100L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>());
        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
                System.out.println(Thread.currentThread().getName());
            };
            executorService1.submit(runnable);
        }
        executorService1.shutdown();
    }

}
