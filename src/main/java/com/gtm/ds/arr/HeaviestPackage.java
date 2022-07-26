package com.gtm.ds.arr;

import java.util.ArrayList;
import java.util.List;
//https://stackoverflow.com/questions/72686890/how-to-write-an-algorithm-to-find-maximum-possible-weight-of-a-package
public class HeaviestPackage {

	public static long getHeaviestPackage(List<Integer> packageWeights) {

		int max = 0;
		for (int i = packageWeights.size() - 1; i >= 0; --i) {
			if (packageWeights.get(i) < max) {
				max += packageWeights.get(i); // merge
			} else {
				max = packageWeights.get(i); // too big to merge - this is the new max
			}
		}
		return max;
	}

	public static void main(String[] args) {
		List<Integer> packageWeights=new ArrayList<>();
		packageWeights.add(30);
		packageWeights.add(15);
		packageWeights.add(6);
		packageWeights.add(7);
		
		System.out.println(HeaviestPackage.getHeaviestPackage(packageWeights));
	}

}
