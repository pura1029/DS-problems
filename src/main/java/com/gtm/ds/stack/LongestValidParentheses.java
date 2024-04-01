/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/longest-valid-parentheses/description/
 *
 * @author kumargautam
 */
public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        int result = 0;
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                result = Math.max(result, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "(()";//2
        String s1 = ")()())";//4
        String s2 = "";//0

        System.out.println(longestValidParentheses(s));
        System.out.println(longestValidParentheses(s1));
        System.out.println(longestValidParentheses(s2));
    }
}
