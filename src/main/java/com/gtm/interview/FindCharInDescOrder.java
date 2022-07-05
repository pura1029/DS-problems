package com.gtm.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class FindCharInDescOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BufferedReader br = null;
		String filePath ="C:/Users/kumarga/Downloads/MyTestFile.txt.txt";
		int topList = 0;
		Set<Enteries> liSet = new TreeSet<Enteries>(new CompareLine());

		try {
			br=new BufferedReader(new FileReader(new File(filePath)));
			String line=br.readLine();
			topList=line.trim().length();
			while ((line=br.readLine())!=null) {
				line=line.trim();
				if (!"".equals(line)) {
					liSet.add(new Enteries(line.length(), line));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = 0;
		for(Enteries ent:liSet){
			System.out.println(ent.line+"\n");
			if(++count == topList){
				break;
			}
		}
	}
		public static class Enteries{
			Integer length;
			String line;
			public Enteries(Integer length, String line) {
				this.length = length;
				this.line = line;
			}

		}

		public static class CompareLine implements Comparator<Enteries>{

			@Override
			public int compare(Enteries o1, Enteries o2) {
				if(o2.length>o1.length){
					return 1;
				}else{
					return -1;
				}

			}

		}
	}
