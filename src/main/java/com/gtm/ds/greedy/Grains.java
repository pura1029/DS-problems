/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.greedy;

import java.util.Arrays;

/**
 * Insert your comment for {@link Grains}.
 *
 * @author kumargautam
 */
//https://workat.tech/problem-solving/practice/sack-of-grains
public class Grains {

    static class Grain {
        public int weight, value;

        public Grain(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static double maxSackValue(Grain[] grains, int w) {
        // Sort based on value/kg by descending order
        Arrays.sort(grains, (g1, g2) -> Double.compare((double) g2.value / g2.weight, (double) g1.value / g1.weight));
        double totalValue = 0.0;
        for (int i = 0; i < grains.length; i++) {
            Grain grain = grains[i];
            if (w - grain.weight >= 0) {
                totalValue += grain.value;
                w -= grain.weight;
            } else {
                totalValue += (w * (double) grain.value / grain.weight);
                break;
            }
        }
        return totalValue;
    }

    public static void main(String[] args) {
        Grain[] grains = new Grain[]{new Grain(5, 20), new Grain(8, 20),
                new Grain(4, 15), new Grain(5, 8)};

        System.out.println(maxSackValue(grains, 12));
    }
}
