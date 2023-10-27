package com.gtm.thread;

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

    }

}
