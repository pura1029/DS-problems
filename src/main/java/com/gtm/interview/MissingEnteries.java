package com.gtm.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingEnteries {



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 20;
		Integer arr[] = {2,3,6,7,8};
		List<Integer> entry =  new ArrayList<Integer>(Arrays.asList(arr));
		StringBuilder seqBuild = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (!entry.contains(i)) {
				seqBuild.append(i).append(",");
			}

		}
		seqBuild.setLength(seqBuild.length()-1);
		System.out.println("sequesnce :"+seqBuild.toString());

	}

}
