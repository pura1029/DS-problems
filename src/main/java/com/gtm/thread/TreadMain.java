package com.gtm.thread;

public class TreadMain {

	public static void main(String[] args) {
		Bank bank1 = new Bank();
		Person1Consumer consumer = new Person1Consumer(bank1);
		Person2Producer producer = new Person2Producer(bank1);
		consumer.start();
		//consumer.run();
		producer.start();
		
		/*Person1Consumer consumer1 = new Person1Consumer(bank1);
		Person2Producer producer1 = new Person2Producer(bank1);
		consumer1.start();
		producer1.start();*/

		try {
			consumer.join();
			producer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Bank{

	int totalAmount = 500;
	private boolean available = false;
	public synchronized void deposit(int amount){

		//synchronized (this) {       //Here,used either static block or static method
		while(available){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		totalAmount += amount;
		dispAmount();
		available = true;
		//notifyAll();
		//OR
		//notify();
		//OR
		this.notify();
	}

	public synchronized int withDraw(int amount) {

		//synchronized (this) {  ////Here,used either static block or static method
		while(!available){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		totalAmount -= amount;
		dispAmount();
		available = false;
		//notifyAll(); 
		//OR
		//notify();
		//OR
		this.notify();
		return amount;
	}
	public void dispAmount() {
		System.out.println("Toatal Amount :"+totalAmount);

	}
}

class Person1Consumer extends Thread{
	private Bank bank;
	int amount = 500;
	public Person1Consumer(Bank bank) {
		this.bank = bank;
	}
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			int money = bank.withDraw(amount+i);
			System.out.println("PersonConsumer :"+i+" withdrow "+money);
			//bank.dispAmount();
		}
	}
}

class Person2Producer extends Thread{
	private Bank bank;
	int amount = 500;
	public Person2Producer(Bank bank) {
		this.bank = bank;
	}
	@Override
	public void run() {
		for (int i = 1; i <= 5; i++) {
			amount = amount+i;
			bank.deposit(amount);
			System.out.println("PersonProducer :"+i+" deposit "+amount);
			//bank.dispAmount();
		}
	}
}
