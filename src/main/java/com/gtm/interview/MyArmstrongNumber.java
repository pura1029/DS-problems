/**
 * 
 */
package com.gtm.interview;

import java.util.Scanner;

/**
 * @author kumarga
 *
 */
public class MyArmstrongNumber {

	public String getArmstrongNumber(int from,int to){
		StringBuilder nos=new StringBuilder();
		for (int no = from; no <= to; no++) {
			boolean flag=isArmstrongNumber(no);
			if (flag) {
				nos.append(no).append(",");
			} 
		}
		if (nos.toString()!=null) {
			return nos.toString().substring(0,nos.length()-1);
		} else {
            return null;
		}
	}
	public boolean isArmstrongNumber(int number){
		int sum=0;
		int actualNo=number;
		while (number>0) {
			int temp=number%10;
			sum =sum+(temp*temp*temp);
			number=number/10;
		}
		if (actualNo==sum) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyArmstrongNumber myArmstrongNumber=new MyArmstrongNumber();
		Scanner scanner=new Scanner(System.in);
		try {
			System.out.println("Enter From No :");
			int from=Integer.parseInt(scanner.nextLine());
			System.out.println("Enter To No :");
			int to=Integer.parseInt(scanner.nextLine());
			String nos=myArmstrongNumber.getArmstrongNumber(from,to);
			System.out.println("Number in Comma ::"+nos);
			if(nos!=null){
				String armChar[]=nos.split(",");
				System.out.print("Armstrong Numbers are in between "+from+" and "+to+" ::");
				for (int i = 0; i < armChar.length; i++) {
					System.out.print(armChar[i]+" ");

				}	
			}else{
				System.out.print("No Armstrong Number is in between "+from+" and "+to+"!!");
			}
		} catch (NumberFormatException e) {
			System.err.println("Plz Enter Integer Number !!!");
			//e.printStackTrace();
		}

		scanner.close();
	}

}
