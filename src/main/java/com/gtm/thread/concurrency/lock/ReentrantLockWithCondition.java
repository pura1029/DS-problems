package com.gtm.thread.concurrency.lock;
import java.util.*;
//https://www.baeldung.com/java-concurrent-locks

public class ReentrantLockWithCondition {
  Stack < String > stack = new Stack < > ();
  int CAPACITY = 5;
  ReentrantLock lock = new ReentrantLock();
  Condition stackEmptyCondition = lock.newCondition();
  Condition stackFullCondition = lock.newCondition();
  public void pushToStack(String item) {
    try {
      lock.lock();
      while (stack.size() == CAPACITY) {
        stackFullCondition.await();
      }
      stack.push(item);
      stackEmptyCondition.signalAll();
    } finally {
      lock.unlock();
    }
  }
  public String popFromStack() {
    try {
      lock.lock();
      while (stack.size() == 0) {
        stackEmptyCondition.await();
      }
      return stack.pop();
    } finally {
      stackFullCondition.signalAll();
      lock.unlock();
    }
  }
}
