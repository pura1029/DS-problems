/**
 * 
 */
package com.gtm.interview;

/**
 * @author kumarga
 *
 */
public class ReplaceCharInString {

	private String word;


	public ReplaceCharInString() {
		super();
	}
	public ReplaceCharInString(String word) {
		super();
		this.word = word;
	}
	public String replace(char oldChar, char newChar){
		for (int i = 0; i < word.length(); i++) {
			char temp = word.charAt(i);
			if (temp == oldChar) {
				int index = word.indexOf(oldChar);
				int length =  word.length();
				word = word.substring(0, index) + newChar + word.substring((index+1), length);
			}
		}
		return word;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "aRamanja";
		ReplaceCharInString string = new ReplaceCharInString(word);
		System.out.println("after replacing : "+string.replace('a', 'k'));
		
		System.out.println(word.substring(3));
	}

}
