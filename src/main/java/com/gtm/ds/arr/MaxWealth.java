package com.gtm.ds.arr;

//https://leetcode.com/problems/richest-customer-wealth/
public class MaxWealth {

    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        for (int[] ints : accounts) {
            int sum = 0;
            for (int anInt : ints) {
                sum += anInt;
            }
            if (sum > ans) {
                ans = sum;
            }
        }
        /*for (int person = 0; person < accounts.length; person++) {
            int sum = 0;
            for (int account = 0; account < accounts[person].length; account++) {
                sum += accounts[person][account];
            }
            if (sum > ans) {
                ans = sum;
            }
        }*/
        return ans;
    }

    public static void main(String[] args) {

        int[][] accounts = { { 11, 2, 3 }, { 3, 5, 1 }, { 4, 5, 6 } };
        System.out.println("Richest Customer Wealth :" + new MaxWealth().maximumWealth(accounts));
    }

}
