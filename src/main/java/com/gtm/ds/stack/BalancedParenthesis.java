package com.gtm.ds.stack;

public class BalancedParenthesis {

	static class Stack{
		int top = -1;
		char items[] = new char[100];
		void push(char x) {
			if (top == 99) 
				System.out.println("Stack full");
			else
				items[++top] = x;
		}

		char pop(){
			if (top == -1) {
				System.out.println("Underflow error");
				return '\0';
			}else{
				char element = items[top];
				top--;
				return element;
			}
		}

		boolean isEmpty() {
			return (top == -1) ? true : false;
		}
	}

	/* Returns true if character1 and character2
    are matching left and right Parenthesis */
	static boolean isMatchingPair(char character1, char character2){
		if (character1 == '(' && character2 == ')')
			return true;
		else if (character1 == '{' && character2 == '}')
			return true;
		else if (character1 == '[' && character2 == ']')
			return true;
		else
			return false;
	}

	/* Return true if expression has balanced 
    Parenthesis */
	static boolean areParenthesisBalanced(char ch[]){
		/* Declare an empty character stack */
		Stack stack = new Stack();
		for (int i = 0; i < ch.length; i++) {
			/*If the ch[i] is a starting 
            parenthesis then push it*/
			if (ch[i] == '{' || ch[i] == '(' || ch[i] == '[')
				stack.push(ch[i]);

			/* If ch[i] is an ending parenthesis 
            then pop from stack and check if the 
            popped parenthesis is a matching pair*/
			if (ch[i] == '}' || ch[i] == ')' || ch[i] == ']')
			{

				/* If we see an ending parenthesis without 
                a pair then return false*/
				if (stack.isEmpty())
					return false;
				/* Pop the top element from stack, if 
                it is not a pair parenthesis of character 
                then there is a mismatch. This happens for 
                expressions like {(}) */
				else if (!isMatchingPair(stack.pop(), ch[i]) )
					return false;
			}
		}
		/* If there is something left in expression 
        then there is a starting parenthesis without 
        a closing parenthesis */

		if (stack.isEmpty())
			return true; /*balanced*/
		else
			return false;/*not balanced*/

	}
	
	public static void main(String[] args) {
		char exp[] = {'{','(',')','}','[',']'};
		if (areParenthesisBalanced(exp))
			System.out.println("Balanced ");
		else
			System.out.println("Not Balanced ");  
	}

}
