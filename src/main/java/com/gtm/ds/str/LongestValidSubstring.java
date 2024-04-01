/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.str;

import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/length-of-the-longest-valid-substring/description/
 *
 * @author kumargautam
 */
public class LongestValidSubstring {

    public static int longestValidSubstring(String word, List<String> forbidden) {
        int maxLen = Integer.MIN_VALUE;
        for (int i = 0; i < word.length(); i++) {
            for (int j = i; j < word.length(); j++) {
                String tempStr = word.substring(i, j + 1);
                if (verifyStr(tempStr, forbidden)) {
                    //System.out.println(tem);
                    if (tempStr.length() > maxLen) {
                        maxLen = tempStr.length();
                    }
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }

    private static boolean verifyStr(String tempStr, List<String> forbidden) {
        for (String str : forbidden) {
            if(tempStr.contains(str)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word = "cbaaaabc";
        List<String> forbidden = Arrays.asList("aaa", "cb");
        System.out.println(longestValidSubstring(word, forbidden));
    }
}
