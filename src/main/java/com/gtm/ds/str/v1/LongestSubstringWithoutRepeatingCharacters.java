/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.str.v1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/
 * https://www.youtube.com/watch?v=Uf6YUcbctIk
 *
 * @author kumargautam
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int longestUniqueSubsttr(String str) {
        if (str.length() == 0)
            return 0;
        int maxans = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int l = 0;
        String ans = "";
        for (int r = 0; r < str.length(); r++) // outer loop for traversing the string
        {
            if (set.contains(str.charAt(r))) //if duplicate element is found
            {
                while (l < r && set.contains(str.charAt(r))) {
                    set.remove(str.charAt(l));
                    l++;
                }
            }
            set.add(str.charAt(r));
            maxans = Math.max(maxans, r - l + 1);
            ans = str.substring(l, r + 1);
        }
        System.out.println("longestUniqueSubsttr :" + ans);
        return maxans;
    }

    public static int longestUniqueSubStr(String str) {// using sliding window
        if (str.length() == 0)
            return 0;

        int l = 0;
        int r = 0;
        Map<Character, Integer> map = new HashMap<>();// <character,index>
        int counter = 0;
        String ans = "";
        while (l < str.length() && r < str.length()) {
            char ch = str.charAt(r);
            if (map.containsKey(ch)) { //if duplicate element is found, update left pointer
                l = Math.max(l, map.get(ch) + 1);
            }
            map.put(ch, r);// update current char index
            counter = Math.max(counter, r - l + 1);
            ans = str.substring(l, r + 1);
            r++;
        }
        System.out.println("longestUniqueSubStr :" + ans);
        return counter;
    }

    public static int longest2UniqueSubStr(String str) {// using sliding window
        if (str.length() == 0)
            return 0;

        int l = 0;
        int r = 0;
        Map<Character, Integer> map = new HashMap<>();// <character,count>
        int counter = 0;
        String ans = "";
        while (l < str.length() && r < str.length()) {
            char ch = str.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > 2) {
                char lCh = str.charAt(l++);
                map.put(lCh, map.get(lCh) - 1);
                if (map.get(lCh) == 0) {
                    map.remove(lCh);
                }
            }

            counter = Math.max(counter, r - l + 1);
            ans = str.substring(l, r + 1);
            r++;
        }
        System.out.println("longest2UniqueSubStr :" + ans);
        return counter;
    }

    public static void main(String[] args) {
        String str = "abbacdb";

        System.out.println(longestUniqueSubsttr(str));
        System.out.println(longestUniqueSubStr(str));
        String string = "ccaabbb";
        System.out.println(longest2UniqueSubStr(string));
    }
}
