/**
 * 
 */
package com.gtm.interview;

/**
 * @author kumarga
 *
 */
public class TwoMaxNumbers {

	public void printTwoMaxNumbers(int[] nums){
		int maxOne=0;
		int maxTwo=0;
		for (int no : nums) {
			if (maxOne<no) {
				maxTwo=maxOne;
				maxOne=no;
			}else if(maxTwo<no){
				maxTwo=no;
			}
		}
		System.out.println("First Maximum No : "+maxOne);
		System.out.println("First Maximum No : "+maxTwo);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {5,34,78,2,45,1,99,23,79};
       new TwoMaxNumbers().printTwoMaxNumbers(num);
	}

}
