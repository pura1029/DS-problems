/**
 * 
 */
package com.gtm.interview;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author kumarga
 *
 */
@SuppressWarnings("unused")
public class MyStringToNumber {
	/**
	 * 
	 * @param numStr
	 * @return int
	 */
	public static int convert_String_To_Number(String numStr) throws NumberFormatException{
		int sum=0;
		char[] ch;
		if (numStr.startsWith("-") || numStr.startsWith("+")) {

			ch=numStr.substring(1, numStr.length()).toCharArray();
		}else{
			ch=numStr.toCharArray();
		}
		int zeroAscii = (int)'0';
		for (char c : ch) {
			int tempAscii=(int)c;
			if (tempAscii >= zeroAscii && tempAscii <= (int)'9') {
				sum=(sum*10)+(tempAscii-zeroAscii);
			}else{
				throw new NumberFormatException("Not a number :"+numStr);
			}
			
		}
		if (numStr.startsWith("-")){
			sum=-sum;
		}
		return sum;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\"-3256\" =="+convert_String_To_Number("-3256"));
		System.out.println("\"76289\" =="+convert_String_To_Number("76289"));
		System.out.println("\"-90087\" =="+convert_String_To_Number("-90087"));
		System.out.println("\"+10\"=="+convert_String_To_Number("+10"));
		System.out.println("\"+10\"=="+convert_String_To_Number("10a"));
		/*Scanner scanner=new Scanner(System.in);
		System.out.println("enter value :");
		int a=Integer.parseInt(scanner.nextLine());
		System.out.println("Value="+a);
		scanner.close();*/
	}
	
	class A{
		void disp()throws IOException{
			
		}
	}
	
	class B extends A{
		void disp()throws FileNotFoundException{
			
		}
	}
	
	 interface AI{
		public abstract void dis() ;
			
		
	}

}
