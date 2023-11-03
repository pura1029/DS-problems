package com.gtm.ds.inttest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class EpamMain {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //Input: strs = ["eat","tea”,”elbow”,”ate”,”below”,”bat"]
        //Output: [["bat”],[“below”,”elbow”],[“ate","eat","tea"]]

        String[] words = {"eat", "tea", "elbow", "ate", "below", "bat"};

        //System.out.println(groupWords(words));

        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSum(nums));

        //[1,11,142,200,300]
        List<Integer> list = Arrays.asList(1, 11, 142, 200, 300);
        list.stream().filter(i -> String.valueOf(i).startsWith("1")).forEach(System.out::println);
    }

    private static List<List<String>> groupWords(String[] words) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {
            char[] wordChar = word.toCharArray();
            Arrays.sort(wordChar);
            String sortedStr = new String(wordChar);
            if (map.containsKey(sortedStr)) {
                List<String> listStr = map.get(sortedStr);
                listStr.add(word);
            } else {
                List<String> listStr = new ArrayList<>();
                map.put(sortedStr, listStr);
                listStr.add(word);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            Collections.sort(list);
            res.add(list);
        }
        Collections.sort(res, (list1, list2) -> list1.size() - list2.size());
        return res;
    }

    private static int maxSum(int[] nums) {
        //[-2,1,-3,4,-1,2,1,-5,4]
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        sum += nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum < 0) {
                sum = 0;
            }

            if (sum > maxSum) {
                maxSum = sum;
            }
        }

        return maxSum;
    }
}