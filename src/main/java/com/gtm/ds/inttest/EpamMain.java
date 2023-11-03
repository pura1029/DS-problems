package com.gtm.ds.inttest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class EpamMain {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        //Input: strs = ["eat","tea”,”elbow”,”ate”,”below”,”bat"]
        //Output: [["bat”],[“below”,”elbow”],[“ate","eat","tea"]]

        String[] words = {"eat", "tea", "elbow", "ate", "below", "bat"};

        System.out.println(groupWords(words));
        System.out.println(groupWords1(words));

        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSum(nums));

        //[1,11,142,200,300]
        List<Integer> list = Arrays.asList(1, 11, 142, 200, 300);
        list.stream().filter(i -> String.valueOf(i).startsWith("1")).forEach(System.out::println);

        String str1 = "gram";
        String str2 = "arm";

        // Function call
        if (isAnagram(str1, str2))
            System.out.print("The two strings are "
                    + "anagram of each other");
        else
            System.out.print("The two strings are "
                    + "not anagram of each other");
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

    private static List<List<String>> groupWords1(String[] words) {

        Map<String, Set<String>> map = new HashMap<>();

        for (String word : words) {
            char[] wordChar = word.toCharArray();
            Arrays.sort(wordChar);
            String sortedStr = new String(wordChar);
            if (map.containsKey(sortedStr)) {
                Set<String> listStr = map.get(sortedStr);
                listStr.add(word);
            } else {
                Set<String> listStr = new TreeSet<>();
                map.put(sortedStr, listStr);
                listStr.add(word);
            }
        }
        return map.values().stream().map(set -> new ArrayList<>(set)).sorted(Comparator.comparingInt(ArrayList::size)).collect(Collectors.toList());
    }

    //https://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/
    public static boolean isAnagram(String a, String b) {
        // Check if length of both strings is same or not
        if (a.length() != b.length()) {
            return false;
        }
        // Create a HashMap containing Character as Key and
        // Integer as Value. We will be storing character as
        // Key and count of character as Value.
        HashMap<Character, Integer> map = new HashMap<>();
        // Loop over all character of String a and put in
        // HashMap.
        for (int i = 0; i < a.length(); i++) {
            // Check if HashMap already contain current
            // character or not
            if (map.containsKey(a.charAt(i))) {
                // If contains increase count by 1 for that
                // character
                map.put(a.charAt(i),
                        map.get(a.charAt(i)) + 1);
            } else {
                // else put that character in map and set
                // count to 1 as character is encountered
                // first time
                map.put(a.charAt(i), 1);
            }
        }
        // Now loop over String b
        for (int i = 0; i < b.length(); i++) {
            // Check if current character already exists in
            // HashMap/map
            if (map.containsKey(b.charAt(i))) {
                // If contains reduce count of that
                // character by 1 to indicate that current
                // character has been already counted as
                // idea here is to check if in last count of
                // all characters in last is zero which
                // means all characters in String a are
                // present in String b.
                map.put(b.charAt(i),
                        map.get(b.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        // Extract all keys of HashMap/map
        Set<Character> keys = map.keySet();
        // Loop over all keys and check if all keys are 0.
        // If so it means it is anagram.
        for (Character key : keys) {
            if (map.get(key) != 0) {
                return false;
            }
        }
        // Returning True as all keys are zero
        return true;
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