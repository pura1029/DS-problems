package com.gtm.interview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class CompareTextFiles {
	
	public Set<Entry<HashMap<String,String>, Integer>> sortByValue(Set<Entry<HashMap<String,String>, Integer>> lineSet){
		List<Entry<HashMap<String,String>, Integer>> listEntry = new ArrayList<>(lineSet);
		Collections.sort(listEntry, new Comparator<Entry<HashMap<String,String>, Integer>>() {

			@Override
			public int compare(Entry<HashMap<String, String>, Integer> o1, Entry<HashMap<String, String>, Integer> o2) {
				return (o2.getValue()).compareTo( o1.getValue() );
			}
		});
		return lineSet;
	}

	public static void main(String[] args) {
		BufferedReader reader1 = null;
		BufferedReader reader2 = null;
		try {
			reader1 = new BufferedReader(new FileReader("D:/GIT_Workspace/Zemo/src/cfile1.txt"));
			reader2 = new BufferedReader(new FileReader("D:/GIT_Workspace/Zemo/src/cfile2.txt"));

			boolean areEqual = true;
			int noOfLine = 1;

			String line1 = reader1.readLine();
			String line2 = reader2.readLine();
			HashMap<HashMap<String,String>, Integer> comWord = new HashMap<HashMap<String,String>, Integer>();
			HashMap<String,String> word ;
			while (line1 != null || line2 != null) {
				if (line1 == null || line2 == null) {
					areEqual = false;
					word = new HashMap<String,String>();
					word.put(line1, line2);
					comWord.put(word, noOfLine);
					//break;
				} else if(!line1.equalsIgnoreCase(line2)){
					areEqual = false;
					word = new HashMap<String,String>();
					word.put(line1, line2);
					comWord.put(word, noOfLine);
					//break;
				}
				line1 = reader1.readLine();
				line2 = reader2.readLine();
				noOfLine++;
			}
			if(areEqual)
			{
				System.out.println("Two files have same content.");
			}
			else
			{
				Collection<Integer> wordSet = comWord.values();
				Set<Integer> wordList = new TreeSet<>(wordSet);
				System.out.println("Two files have different content. They differ at line "+wordList);
				Set<Entry<HashMap<String,String>, Integer>> lineSet = comWord.entrySet();
				lineSet = new CompareTextFiles().sortByValue(lineSet);
				for (Entry<HashMap<String, String>, Integer> entry : lineSet) {
					HashMap<String, String> lineMap = entry.getKey();
					Integer lineNo = entry.getValue();
					Set<Entry<String, String>> textSet = lineMap.entrySet();
					for (Entry<String, String> entry2 : textSet) {
						System.out.println("File1 has "+entry2.getKey()+" and File2 has "+entry2.getValue()+" at line "+lineNo);
					}
					System.out.println();
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (reader1 != null){
				try {
					reader1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (reader2 != null){
				try {
					reader2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
