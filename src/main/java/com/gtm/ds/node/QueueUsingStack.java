package com.gtm.ds.node;

import java.util.Stack;

/**
 * 
 * @author Gautam Kumar
 * <p>Implement <b>Queue</b> using 2 or 1 <b>Stack</b>
 *	@see	com.gtm.ds.node.Queue
 *	@see	com.gtm.ds.node.Queue1
 */
public class QueueUsingStack {
	/**
	 * 
	 * @author Gautam Kumar
	 * 
	 * class of queue having two stacks
	 * enQueue(x)
	 * 1) Push x to stack1 (assuming size of stacks is unlimited).
	 * deQueue()
	 *1) If both stacks are empty then error.
	 *2) If stack2 is empty
	 *   While stack1 is not empty, push everything from stack1 to stack2.
	 *3) Pop the element from stack2 and return it.
	 *@see	com.gtm.ds.node.Queue1
	 */
	static class Queue
	{
		private Stack<Integer> s1;
		private Stack<Integer> s2;

		public Queue(){
			s1 = new Stack<>();
			s2 = new Stack<>(); 
		}

		/* Function to push an item to stack*/
		private void push(Stack<Integer> top_ref, int new_data)
		{
			//Push the data onto the stack
			top_ref.push(new_data);
		}
		/* Function to pop an item from stack*/
		private int pop(Stack<Integer> top_ref)
		{
			/*If stack is empty then error */
			if(top_ref.isEmpty())
			{
				System.out.println("Stack Overflow");
				System.exit(0);    
			}
			//pop the data from the stack
			return top_ref.pop(); 
		}
		//Function to enqueue an item to the queue
		public void enQueue(int x)
		{
			push(s1, x);
		}
		/* Function to dequeue an item from queue */
		public int deQueue()
		{
			int x;
			/* If both stacks are empty then error */
			if(s1.isEmpty() && s2.isEmpty() )
			{
				System.out.println("Q is empty");
				System.exit(0);
			}

			/* Move elements from stack1 to stack 2 only if
	        stack2 is empty */
			if(s2.isEmpty())
			{
				while(!s1.isEmpty())
				{
					x = pop(s1);
					push(s2, x);

				}
			}
			x = pop(s2);
			return x;
		}
	}
	/**
	 * 
	 * @author kumarga 
	 *
	 * class of queue having one stacks
	 * <p>enQueue(x)<br/>
	 * 1) Push x to stack1.
	 * <p>deQueue()<br/>
	 * 1) If <code>stack1</code> is empty then error.<br/>
	 * 2) If stack1 has only one element then return it.<br/>
	 * 3) <em>Recursively pop everything from the stack1, store the popped item 
	 *    in a variable res,</em>  push the res back to stack1 and return res.
	 *    @see		com.gtm.ds.node.Queue
	 */
	static class Queue1
	{
		private Stack<Integer> s1;

		public Queue1(){
			s1 = new Stack<>();
		}

		/* Function to push an item to stack*/
		private void push(Stack<Integer> top_ref, int new_data)
		{
			//Push the data onto the stack
			top_ref.push(new_data);
		}
		/* Function to pop an item from stack*/
		private int pop(Stack<Integer> top_ref)
		{
			/*If stack is empty then error */
			if(top_ref.isEmpty())
			{
				System.out.println("Stack Overflow");
				System.exit(0);    
			}
			//pop the data from the stack
			return top_ref.pop(); 
		}
		//Function to enqueue an item to the queue
		public void enQueue(int x)
		{
			push(s1, x);
		}
		/* Function to dequeue an item from queue */
		public int deQueue()
		{
			int x,res=0;

			/* If the stacks is empty then error */
			if(s1.isEmpty())
			{
				System.out.println("\nQ is Empty");
				System.exit(0);
			}else if(s1.size() == 1){
				return pop(s1);
			}else{
				/* pop an item from the stack1 */
				x = pop(s1);

				/* store the last dequeued item */
				res = deQueue();

				/* push everything back to stack1 */
				push(s1,x);

				return res;
			}
			return res;
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		/* Dequeue items */
		System.out.print(q.deQueue()+" ");
		System.out.print(q.deQueue()+" ");
		System.out.print(q.deQueue()+" ");
		System.out.print(q.deQueue()+" ");
		q.enQueue(5);
		System.out.print(q.deQueue()+" ");

		System.out.println("\nqueue2 ");
		Queue1 q1 = new Queue1();
		q1.enQueue(1);
		q1.enQueue(2);
		q1.enQueue(3);
		q1.enQueue(4);
		/* Dequeue items */
		System.out.print(q1.deQueue()+" ");
		System.out.print(q1.deQueue()+" ");
		System.out.print(q1.deQueue()+" ");
		System.out.print(q1.deQueue()+" ");
		q1.enQueue(5);
		System.out.print(q1.deQueue()+" ");
	}
}

