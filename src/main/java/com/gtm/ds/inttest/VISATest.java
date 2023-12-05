/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.inttest;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Insert your comment for {@link VISATest}.
 *
 * @author kumargautam
 */
public class VISATest {

    public static int[] cal(int[] time) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[time.length];
        int j = 0;
        int t = 0;
        for (int i = 0; i < time.length; i++) {
            t = 300 + time[i];
            if (queue.size() >= 10) {
                queue.add(t);
                res[j++] = t;
            } else if (queue.isEmpty()) {
                queue.add(t);
                res[j++] = t;
            } else if (queue.peekLast() <= time[i]) {
                queue.remove();
                queue.add(t);
                res[j++] = t;
            } else {
                t = 300 + queue.peekLast();
                queue.add(t);
                res[j++] = t;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //int[] time = {4, 400, 600, 800};
        int[] time = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        System.out.println(Arrays.toString(cal(time)));
    }
}
