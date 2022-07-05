package com.gtm.thread.pc;

public class OddEvenPrintMain {

	boolean odd;
	int count = 1;
	int MAX = 10;

	public void printOdd() {
		synchronized (this) {
			while (count < MAX) {
				//System.out.println("Checking odd loop");

				while (!this.odd) {
					try {
						//System.out.println(Thread.currentThread().getName()+" waiting : " + count);
						wait();
						//System.out.println("Notified "+Thread.currentThread().getName()+" : " + count);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				//System.out.println(Thread.currentThread().getName()+" Thread :" + count);
				System.out.println(count);
				count++;
				this.odd = false;
				notify();
			}
		}
	}

	public void printEven() {

		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}*/
		synchronized (this) {
			while (count < MAX) {
				//System.out.println("Checking even loop");

				while (this.odd) {
					try {
						//System.out.println(Thread.currentThread().getName()+" waiting: " + count);
						wait();
						//System.out.println("Notified "+Thread.currentThread().getName()+" : " + count);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				//System.out.println(Thread.currentThread().getName()+" thread : " + count);
				System.out.println(count);
				count++;
				this.odd = true;
				notify();

			}
		}
	}

	public static void main(String[] args) {
		OddEvenPrintMain oep = new OddEvenPrintMain();
		oep.odd = true;
		Thread t1 = new Thread(()->{
			oep.printEven();
		},"EVEN");

		Thread t2 = new Thread(()->{
			oep.printOdd();
		},"ODD");

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+ " thread over");

	}
}
