package com.gtm.interview;


/**
 * Java Program to reverse Integer in Java, number can be negative.
 * Example 1:  x = 123, return 321
 * Example 2:  x = -123, return -321
 *
 * @author kumarga
 */
public class ReverseInteger {

	public static void main(String args[]) {
		int input = -20;
		int output = reverseInteger(input);
		System.out.println("Input : " + input + " Output : " + output);
	}

	/*
	 * Java method to reverse an integer value. there are couple of corner cases
	 * which this method doesn't handle e.g. integer overflow.
	 */
	public static int reverseInteger(int number) {
		boolean isNegative = number < 0 ? true : false;
		if(isNegative){
			number = number * -1;
		}
		int reverse = 0;
		int lastDigit = 0;
		int count = 0;
		boolean isLastDigitAsZero = false;
		while (number >= 1) {
			lastDigit = number % 10; // gives you last digit
			if (lastDigit == 0 && reverse == 0) {
				isLastDigitAsZero = true;
				count ++;
			}
			reverse = reverse * 10 + lastDigit;
			number = number / 10; // get rid of last digit
		}
		if (isLastDigitAsZero) {
			String reveseTem = String.valueOf(reverse);
			String zero ="0";
			for (int i = 1; i < count; i++) {
				zero = zero.concat(zero);
			}
			reveseTem = zero.concat(reveseTem);
			reveseTem = isNegative ? "-".concat(reveseTem) : reveseTem;
			System.out.println("Reverse Val :"+reveseTem);
			//reverse = Integer.parseInt(reveseTem);
		}
		return isNegative == true? reverse*-1 : reverse;
	}
}
