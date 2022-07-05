/**
 * 
 */
package com.gtm.interview;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author kumarga
 *
 */
public class DuplicateCharsInString {
 
	public  static void findDuplicateChars(String str){
		Map<Character, Integer> dupMap=new TreeMap<Character, Integer>();
		char ch[]=str.toCharArray();
		for (char c : ch) {
			if(dupMap.containsKey(c)){
				dupMap.put(c, (dupMap.get(c))+1);
			}else{
				dupMap.put(c, 1);
			}
		}
		Set<Character> keys=dupMap.keySet();
		for (Character key : keys) {
			if(dupMap.get(key)>1){
				System.out.println("Duplicate character : "+key+" repeated nos : "+dupMap.get(key));
			}
		}
	}
	public static void main(String[] args) {
		DuplicateCharsInString.findDuplicateChars("1255556632213141");
	}
}
