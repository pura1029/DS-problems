package com.gtm.interview;

public class RemoveDuplicateContent {

	public int[] removeDupInt(int[] val){

		int res[] = new int[val.length];
		int j = 0;
		for (int i : val) {
			if (!isExists(res, i)) {
				res[j++] = i;
			}
		}
		int res1[] = new int[j];
		for (int i = 0; i < j; i++) {
			res1[i] = res[i];
		}
		return res1;
	}
	private static boolean isExists(int[] array, int value){
		for (int i : array) {
			if(i == value)
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int val[] = new int[]{1,2,1,3,4,5,4,6,6,7,7,9,9,8,10,8};
		int val1[] = new RemoveDuplicateContent().removeDupInt(val);
		for (int i : val1) {
			System.out.println(i);
		}

	}

}
