/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.inttest.walmart;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static void longestSubStr(String str) {
        int count = -1;
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            Set<Character> characters = new HashSet<>();
            String temp = "";
            for (int j = i; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (characters.add(ch)) {
                    temp += ch;
                } else {
                    break;
                }
            }
            if (temp.length() > count) {
                res = temp;
                count = temp.length();
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        //String str = "abcabcbb";
        //String str = "pwwkew";
        String str = "bbbbb";
        longestSubStr(str);
    }
}
