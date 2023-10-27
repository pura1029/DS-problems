package com.gtm.thread.producer.consumer;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumerSolution {

    static Vector<Integer> sharedQueue = new Vector<Integer>();
    static int size = 4;
    private static final Logger logger = Logger.getLogger(ProducerConsumerSolution.class.getName());

    public static void main(String[] args) {
        logger.log(Level.INFO, "start main() method");
        Thread produceThread = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consumerThread = new Thread(new Consumer(sharedQueue, size), "Cosumer");
        produceThread.start();
        consumerThread.start();
        try {
            produceThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.log(Level.INFO, "end main() method");
    }

}

class Producer implements Runnable {

    private final Vector<Integer> sharedQueue;
    private final int size;


    public Producer(Vector<Integer> sharedQueue, int size) {
        super();
        this.sharedQueue = sharedQueue;
        this.size = size;
    }


    @Override
    public void run() {
        int pCount = 0;
        int i = 0;
        //for(i = 0; i < 7; i++){
        while (true) {
            System.out.println("Produced: " + i);
            //produce(i);
            produce(i++);
            if (pCount == 100)
                break;
            pCount++;
        }
    }

    private void produce(int i) {

        while (size == sharedQueue.size()) {
            synchronized (sharedQueue) {
                System.out.println("Queue is full " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());
                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    System.err.println("error message :" + e.getMessage());
                }
            }
        }

        synchronized (sharedQueue) {
            sharedQueue.add(i);
            sharedQueue.notifyAll();
        }
    }
}

class Consumer implements Runnable {


    private final Vector<Integer> sharedQueue;
    private final int size;


    public Consumer(Vector<Integer> sharedQueue, int size) {
        super();
        this.sharedQueue = sharedQueue;
        this.size = size;
    }

    @Override
    public void run() {
        int cCount = 0;
        while (true) {
            //for(int i = 0; i < 7; i++){
            System.out.println("Consumed: " + consume());
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (cCount == 100)
                break;
            cCount++;
        }
    }

    private int consume() {
        while (sharedQueue.isEmpty() || size == 0) {
            synchronized (sharedQueue) {
                System.out.println("Queue is empty " + Thread.currentThread().getName()
                        + " is waiting , size: " + sharedQueue.size());

                try {
                    sharedQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (sharedQueue) {
            sharedQueue.notifyAll();
            return sharedQueue.remove(0);
        }
    }
}