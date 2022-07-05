package com.gtm.node;

import java.util.Arrays;

public class MyGenericsStack<S extends Object> {
	private S stackArr[];
	private int stackSize;
	private int top;




	@SuppressWarnings("unchecked")
	public MyGenericsStack(int stackSize) {
		super();
		this.stackSize = stackSize;
		this.stackArr = (S[]) new Object[stackSize];
		top = -1;
	}

	/**
	 * This method adds new entry to the top
	 * of the stack
	 * @param entry
	 * @throws Exception
	 */
	public void push(S entry){
		if (this.isStackFull()) {
			System.out.println(("Stack is full. Increasing the capacity."));
			this.increaseStackCapacity();
		}
		System.out.println("Adding :"+entry);
		this.stackArr[++top] = entry;
	}

	/**
	 * This method removes an entry from the
	 * top of the stack.
	 * @return
	 * @throws Exception
	 */
	public S pop() throws Exception {
		if (this.isStackEmpty()) {
			throw new Exception("Stack is empty, Can not remove element.");
		}
		S entry = this.stackArr[top--];
		System.out.println("Removed entry: "+entry);
		return entry;
	}

	/**
	 * This method returns top of the stack
	 * without removing it.
	 * @return
	 */
	public S peek() {
		return stackArr[top];
	}

	/**
	 * This method returns true if the stack is
	 * empty
	 * @return
	 */
	public boolean isStackEmpty() {
		return (top == -1);
	}

	/**
	 * This method returns true if the stack is full
	 * @return
	 */
	public boolean isStackFull() {
		return (top == stackSize - 1);
	}

	@SuppressWarnings({"unchecked" })
	private void increaseStackCapacity(){
		S newStack [] = (S[]) new Object[stackSize*2];
		for (int i = 0; i < stackSize; i++) {
			newStack[i] = stackArr[i];
		}
		this.stackSize = stackSize*2;
		this.stackArr = newStack;
	}

	public void revertStack(MyGenericsStack<Integer> s) throws Exception {
		if (s.isStackEmpty()) {
			return;
		} else {
			Integer a = s.pop();
			revertStack(s);
			appendStack(s, a);
		}
	}

	public void appendStack(MyGenericsStack<Integer> s, Integer a) throws Exception {
		if (s.isStackEmpty()) {
			s.push(a);
			return;
		} else {
			Integer o = s.pop();
			appendStack(s, a);
			s.push(o);
		}
	}


	@Override
	public String toString() {
		return "MyGenericsStack [stackArr=" + Arrays.toString(stackArr) + "]";
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		MyGenericsStack<String> stringStack = new MyGenericsStack<String>(2);
		stringStack.push("java2novice");
		MyGenericsStack<Integer> integerStack = new MyGenericsStack<Integer>(2);
		integerStack.push(23);
		integerStack.push(24);
		integerStack.push(25);
		System.out.println("peek entry : "+integerStack.peek());
		System.out.println("stack before reverse "+integerStack.toString());
		integerStack.revertStack(integerStack);
		System.out.println("stack after reverse "+integerStack.toString());

	}

}
