/**
 * 
 */
package com.gtm.interview;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * @author kumarga
 *
 */
@SuppressWarnings("unused")
public class MyDistinctFileWords {


	public Map<String, Integer> getDistinctWordList(String fileName){

		FileInputStream fis = null;
		DataInputStream dis = null;
		BufferedReader br = null;
		Map<String, Integer> wordMap = new HashMap<String, Integer>();
		try {
			fis = new FileInputStream(fileName);
			dis = new DataInputStream(fis);
			br = new BufferedReader(new InputStreamReader(dis));
			String line = null;
			while((line = br.readLine()) != null){
				StringTokenizer st = new StringTokenizer(line, " ,.;:\"");
				while(st.hasMoreTokens()){
					String tmp = st.nextToken().toLowerCase();
					if(wordMap.containsKey(tmp)){
						wordMap.put(tmp, wordMap.get(tmp)+1);
					} else {
						wordMap.put(tmp, 1);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try{
				if(br != null) 
					br.close();
				}catch(Exception ex){}
		}
		return wordMap;
	}

	public static void main(String a[]){

		MyDistinctFileWords distFw = new MyDistinctFileWords();
		Map<String, Integer> wordMap = distFw.getDistinctWordList("C:/Users/kumarga/Downloads/MyTestFile.txt.txt");
		Set<Entry<String, Integer>> wordSet=wordMap.entrySet();
		System.out.println("Distinct Word are :");
		for (Map.Entry<String, Integer> entry : wordSet) {
			String key=entry.getKey();
			int value=entry.getValue();
			if(value==1){
				System.out.println(key+"-->Nos of time ::"+value);
			}
		}

	}
}
