package com.gtm.ds.node;

import java.util.LinkedList;
import java.util.Queue;

//stack can be implemented using one queues
public class StackUsingQue {
	Queue<Integer> q = new LinkedList<>();

	// Push operation
	void push(int val) 
	{
		// get previous size of queue
		int size = q.size();

		// Add current element
		q.add(val);

		// Pop (or Dequeue) all previous
		// elements and put them after current
		// element
		for (int i = 0; i < size; i++) 
		{
			// this will add front element into
			// rear of queue
			int x = q.remove();
			q.add(x);
		}
	}

	// Removes the top element
	int pop() 
	{
		if (q.isEmpty()) 
		{
			System.out.println("No elements");
			return -1;
		}
		int x = q.remove();
		return x;
	}

	// Returns top of stack
	int top() 
	{
		if (q.isEmpty())
			return -1;
		return q.peek();
	}

	// Returns true if Stack is empty else false
	boolean isEmpty() 
	{
		return q.isEmpty();
	}

	// Driver program to test above methods
	public static void main(String[] args) 
	{
		StackUsingQue s = new StackUsingQue();
		s.push(10);
		s.push(20);
		System.out.println("Top element :" + s.top());
		s.pop();
		s.push(30);
		s.pop();
		System.out.println("Top element :" + s.top());

		System.out.println("StackQue1.......");
		StackQue1 s2 = new StackQue1();
		s2.push(10);
		s2.push(20);
		System.out.println("Top element :" + s2.top());
		s2.pop();
		s2.push(30);
		s2.pop();
		System.out.println("Top element :" + s2.top());
	}
}
// stack can be implemented using two queues
class StackQue1 {
	// Two inbuilt queues
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	// elements
	int curr_size;

	public StackQue1()
	{
		curr_size = 0;
	}

	public void push(int x)
	{
		curr_size++;

		// Push x first in empty q2
		q2.add(x);

		// Push all the remaining 
		// elements in q1 to q2. 
		while (!q1.isEmpty())
		{
			q2.add(q1.peek());
			q1.poll();
		}

		// swap the names of two queues
		Queue<Integer> q = q1;
		q1 = q2;
		q2 = q;
	}

	public void pop(){

		// if no elements are there in q1 
		if (q1.isEmpty())
			return ;
		q1.poll();
		curr_size--;
	}

	public int top()
	{
		if (q1.isEmpty())
			return -1;
		return q1.peek();
	}

	public int size()
	{
		return curr_size;
	}
}
