package com.gtm.interview;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.TreeSet;

public class TwoLinesWithMaxChar {

	public static void main(String[] args) {
		String filePath = "src/com/gtm/interview/input.txt";
		int topList = 0;
		TreeSet<Entries> liSet = new TreeSet<>(new MyComp());
		try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
			String line = br.readLine();
			topList = Integer.parseInt(line.trim());
			while((line = br.readLine()) != null){
				line = line.trim();
				if(!"".equals(line)){
					liSet.add(new Entries(line.length(), line));
				}

			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = 0;
		for(Entries ent:liSet){
			System.out.println(ent.line);
			if(++count == topList){
				break;
			}
		}

	}


	public static class Entries{
		Integer length;
		String line;
		public Entries(Integer l,String line){
			length = l;
			this.line = line;
		}
	}

	public static class MyComp implements Comparator<Entries>{

		@Override
		public int compare(Entries e1, Entries e2) {
			if(e2.length > e1.length){
				return 1;
			} else {
				return -1;
			}
		}

	}
}
