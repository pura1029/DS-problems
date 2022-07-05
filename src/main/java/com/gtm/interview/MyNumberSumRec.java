/**
 * 
 */
package com.gtm.interview;

/**
 * @author kumarga
 *
 */
public class MyNumberSumRec {
	int sum=0;
	static int reverse=0;
	public int getNumberSum(int number){
		
		if (number==0) {
			return sum;
		} else {
           sum+=number%10;
           return (getNumberSum(number/10));
		}
	}

	public static int reverse(int no){
		
		if (no<1) {
			return reverse;
		} else {
           reverse=reverse*10 + no%10;
           return (reverse(no/10));
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Sum :"+new MyNumberSumRec().getNumberSum(123));
       System.out.println("Reverse Number:"+MyNumberSumRec.reverse(123));
	}

}
