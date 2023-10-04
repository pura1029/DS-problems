/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.greedy;

import java.util.Arrays;

/**
 * Insert your comment for {@link FractionalKnapsackProblem}.
 *
 * @author kumargautam
 */
//https://www.geeksforgeeks.org/fractional-knapsack-problem/
public class FractionalKnapsackProblem {

    // Item value class
    static class ItemValue {
        int profit;
        int weight;
        double valuePerUnitWeight;

        // Item value function
        public ItemValue(int val, int wt) {
            this.weight = wt;
            this.profit = val;
            this.valuePerUnitWeight = (double) (val / wt);
        }
    }

    private static double getMaxValue(ItemValue[] arr, int capacity) {
        Arrays.sort(arr, (item1, item2) -> {
            if (item1.valuePerUnitWeight < item2.valuePerUnitWeight)
                return 1;
            else
                return -1;
        });
        double totalValue = 0d;
        for (ItemValue i : arr) {
            int curWt = i.weight;
            int curVal = i.profit;
            if (capacity - curWt >= 0) {

                // This weight can be picked whole
                capacity = capacity - curWt;
                totalValue += curVal;
            } else {
                // Item can't be picked whole
                totalValue += (capacity * i.valuePerUnitWeight);
                capacity = 0;
                break;
            }

        }
        return totalValue;
    }

    //https://www.scaler.com/topics/fractional-knapsack-problem/
    public static void main(String[] args) {
        ItemValue[] arr = {new ItemValue(60, 10),
                new ItemValue(100, 20),
                new ItemValue(120, 30)};

        int capacity = 50;

        double maxValue = getMaxValue(arr, capacity);
        // Function call
        System.out.println(maxValue);

    }
}
