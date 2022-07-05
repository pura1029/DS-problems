package com.gtm.deadlock;

/**
 * if AThreah completed the execution of AClass and try to execute the BClass
 * and BThreah completed the execution of BClass and try to execute the AClass,but
 * Here AThread is blocked the AClass and BTherad is blocked BClass. so here, 
 * both of them is waiting for each other to release the lock, so that there is
 * raised deadlock
 * @author kumarga
 *
 */
public class DeadLockTest {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AThread aThread = new AThread();
		BThread bThread = new BThread();
		aThread.start();
		bThread.start();

		try {
			aThread.join();
			bThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class AThread extends Thread{
	@Override
	public void run() {
		lockA();
	}
	public void lockA() {
		synchronized (AClass.class) {
			System.out.println("AClass Lock-->AThread");

			synchronized (BClass.class) {
				System.out.println("BClass Lock-->AThread");
			}
		}


	}
}

class BThread extends Thread{
	@Override
	public void run() {
		lockB();
	}
	public void lockB() {
		synchronized (BClass.class) {
			System.out.println("BClass Lock-->BThread");

			synchronized (AClass.class) {
				System.out.println("AClass Lock-->BThread");
			}
		}


	}
}

class AClass 
{
	public AClass() {
		System.out.println("AClass");
	}
}

class BClass 
{
	public BClass() {
		System.out.println("BClass");
	}
}