/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.greedy;

import java.util.Arrays;

/**
 * Insert your comment for {@link MinPlatforms}.
 *
 * @author kumargautam
 */
//https://workat.tech/problem-solving/practice/trains-and-platforms
public class MinPlatforms {

    static class Train {
        public int arrival, departure;

        public Train(int arrival, int departure) {
            this.arrival = arrival;
            this.departure = departure;
        }
    }

    static int minPlatforms(Train[] trains) {
        int requiredPlatforms = 0;
        int n = trains.length;
        int[] sortedArrivals = new int[n];
        int[] sortedDepartures = new int[n];
        for (int i = 0; i < n; i++) {
            sortedArrivals[i] = trains[i].arrival;
            sortedDepartures[i] = trains[i].departure;
        }
        Arrays.sort(sortedArrivals);
        Arrays.sort(sortedDepartures);
        int i = 0, j = 0, currentTrains = 0;
        while (i != n && j != n) {
            if (sortedArrivals[i] <= sortedDepartures[j]) {
                currentTrains++;
                i++;
                requiredPlatforms = Math.max(requiredPlatforms, currentTrains);
            } else {
                currentTrains--;
                j++;
            }
        }
        return requiredPlatforms;
    }

    public static void main(String[] args) {
        Train[] trains = new Train[]{new Train(120, 130), new Train(130, 150),
                new Train(125, 145), new Train(150, 180)};
        System.out.println(minPlatforms(trains));
    }
}
