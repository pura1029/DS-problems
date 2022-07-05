/**
 * 
 */
package com.gtm.interview;

/**
 * @author kumarga
 *
 */
public class ReverseString {

	
	public static String reverse(String str) {
	    if ((null == str) || (str.length() <= 1)) {
	        return str;
	    }
	    return reverse(str.substring(1)) + str.charAt(0);
	}
	public void printBinaryFormat(int number){
        int binary[] = new int[25];
        int index = 0;
        while(number > 0){
            binary[index++] = number%2;
            number = number/2;
        }
        for(int i = index-1;i >= 0;i--){
            System.out.print(binary[i]);
        }
    }
	public void printDecimaFormat(int no){
		int decimal = 0;
		int power = 0;
		while (no > 0) {
			int lastNo = no % 10;
			decimal = decimal + (lastNo * ((int)Math.pow(2, power)));
			no = no/10;
			power++;
		}
		
		System.out.println("Decimal : "+decimal);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("After Reverse :"+reverse("gautam"));
		//new ReverseString().printBinaryFormat(25);
		int bin = (int) 0100D;//'D' denotes 0100 is decimal no
		new ReverseString().printDecimaFormat(bin);
		char b = '\u0011';
		System.out.println((int)b);
      
	}

}
