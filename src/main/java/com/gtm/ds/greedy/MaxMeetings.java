/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Insert your comment for {@link MaxMeetings}.
 *
 * @author kumargautam
 */
//https://workat.tech/problem-solving/practice/max-meetings-in-a-room
public class MaxMeetings {

    static class Meeting {
        public int start;
        public int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static int getMaxMeetings(Meeting[] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(m -> m.end));
        int count = 1;
        int prvEnd = meetings[0].end;
        for (int i = 1; i < meetings.length; i++) {
            if (prvEnd <= meetings[i].start) {
                count++;
                prvEnd = meetings[i].end;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Meeting[] meetings = new Meeting[]{new Meeting(3, 29), new Meeting(50, 93), new Meeting(88, 92),
                new Meeting(54, 67), new Meeting(50, 87)};

        System.out.println(getMaxMeetings(meetings));
    }
}
