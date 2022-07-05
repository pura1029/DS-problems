package com.gtm.string;

public class DuplicateCharInString {


	private static final int NO_OF_CHARS = 256;

	/* Print duplicates present in the passed string */
	public static void printDups(String str){
		// Create an array of size 256 and fill count of every character in it
		int count[] = new int[NO_OF_CHARS];
		fillCharCounts(str, count);

		for (int i = 0; i < NO_OF_CHARS; i++)
			if(count[i] > 1)
				System.out.printf("%c,  count = %d \n", i,  count[i]);

	}

	/* Fills count array with frequency of characters */
	private static void fillCharCounts(String str, int[] count){
		for (int i = 0; i < str.length();  i++)
			count[Character.isLowerCase(str.charAt(i)) ? str.charAt(i) : Character.toLowerCase(str.charAt(i))]++;
	}

	// Driver Method
	public static void main(String[] args){
		String str = "test String";
		printDups(str);

		System.out.println("A :"+(int)'A'+",Z :"+(int)'Z'+",a :"+(int)'a'+",z :"+(int)'z');

		System.out.println("0 :"+(int)'0'+",9 :"+(int)'9');
		char c ='C';
		int ch = (int)c;
		if(ch >= 65 && ch <= 90){
			System.out.println("Upper Case");
			System.out.println("Lower Case :"+(char)(ch + 32));
		}
		else if(ch >= 97 && ch <= 122){
			System.out.println("Lower Case");
			System.out.println("Upper Case :"+(char)(ch - 32));
		}


	}
}
