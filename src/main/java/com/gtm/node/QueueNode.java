package com.gtm.node;

public class QueueNode {

	private int size;
	QNode front, rear;

	public void enQueue(int data){
		QNode newNode = new QNode(data);
		if (rear == null) {
			this.rear = newNode;
			this.front = newNode;
		}else{
			this.rear.next = newNode;
			rear = newNode;
		}
		System.out.println("equeue done "+data);
		size++;
	}


	public int deQueue(){
		QNode temp = front;
		int d = -1;
		if (temp != null) {
			front = temp.next;
			d = temp.data;
			size--;
		}
		System.out.println("dequeue done "+d);
		return d;
	}

	public void printQueue(){
		QNode temp = front;
		System.out.print("Queue data : ");
		while (temp != null) {
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
		System.out.println();
	}
	public int size(){
		return size;
	}
	public static void main(String[] args) {
		QueueNode qn = new QueueNode();
		qn.enQueue(1);
		qn.enQueue(2);
		System.out.println("Queue size :"+qn.size);
		qn.printQueue();
		qn.deQueue();
		System.out.println("Queue size :"+qn.size);
		qn.deQueue();
		qn.printQueue();
	}

	static class QNode{
		int data;
		QNode next;

		public QNode(int data){
			this.data = data;
			this.next = null;
		}
	}

}
