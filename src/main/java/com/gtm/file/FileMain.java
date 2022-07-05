package com.gtm.file;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class FileMain {

	public static void readFile(String fileName){
		final String deli = "\\s+";
		File file = new File(fileName);
		long size = file.length();
		try(InputStream is = new BufferedInputStream(new FileInputStream(file))) {
			Scanner sc = new Scanner(is, StandardCharsets.UTF_8.name());
			Pattern pattern = Pattern.compile(deli);
			sc.useDelimiter(pattern);
			HashMap<String, Integer> wordMap = new HashMap<>();
			int len = 1;
			int current = 0;
			Set<Integer> percentCompleted = new HashSet<>();
			while (sc.hasNext()) {
				progress(percentCompleted, current, size);
				String word = (String) sc.next();
				if(wordMap.containsKey(word)){
					wordMap.put(word, (wordMap.get(word)+1));
				}else{
					wordMap.put(word, 1);
				}

				current += (word.getBytes(StandardCharsets.UTF_8.name()).length + len);
			}
			progress(percentCompleted, current, size);
			sc.close();
			printMap(wordMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void progress(Set<Integer> percentCompleted, int current, long size) {
		int percentComplete;
		percentComplete = getPercentage(current, size);
		if ((percentComplete % 5 == 0) && !percentCompleted.contains(percentComplete)) {
			percentCompleted.add(percentComplete);
			logInfo("Percentage Complete: " + percentComplete + "%");
		}
	}

	public static int getPercentage(long current, long total) {
		return (int) (((double) current / total) * (100));
	}

	public static void logInfo(String message) {
		System.out.print("INFO: ");
		System.out.println(message);
	}

	private static void printMap(HashMap<String, Integer> wordMap) {
		SortedMap<Integer, Set<Object>> sortedWordMap = new TreeMap<Integer, Set<Object>>(
				new Comparator<Integer>() {
					public int compare(Integer o1, Integer o2) {
						return o2.compareTo(o1);
					}
				});
		for (Iterator<String> iterator = wordMap.keySet().iterator(); iterator.hasNext();) {
			String word = (String) iterator.next();
			Integer count = wordMap.get(word);
			Set<Object> set = sortedWordMap.get(count);
			if(set == null){
				set = new HashSet<>();
				sortedWordMap.put(count, set);
			}
			set.add(word);
		}
		StringBuilder builder = new StringBuilder();
		int counter = 0;
		for (Integer freq : sortedWordMap.keySet()) {
			counter++;

			builder.append("@HigeshtFreq: ");
			builder.append(counter);
			builder.append(" : ");

			builder.append(" With a frequency of '");
			builder.append(freq);
			builder.append("' times, word :");

			builder.append("'");
			builder.append(sortedWordMap.get(freq));
			builder.append("'");
			logInfo(builder.toString());
			builder.delete(0, builder.length());
		}
	}

	public static void main(String[] args) {
		readFile("test.txt");
	}

}
