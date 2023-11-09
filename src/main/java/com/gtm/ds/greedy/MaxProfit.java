/*
 * Copyright (c) 2023 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Insert your comment for {@link MaxProfit}.
 *
 * @author kumargautam
 */
//https://workat.tech/problem-solving/practice/tasks-for-profit
public class MaxProfit {

    static class Task {
        public int deadline, profit;

        public Task(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }


    static int getMaxProfit(Task[] tasks) {
        Arrays.sort(tasks, Comparator.comparingInt(t -> t.deadline));
        PriorityQueue<Integer> chosenTasks = new PriorityQueue<Integer>();
        for (int i = 0; i < tasks.length; i++) {
            if (chosenTasks.size() == tasks[i].deadline) {
                if (chosenTasks.peek() > tasks[i].profit) {
                    continue;
                }
                chosenTasks.poll();
            }
            chosenTasks.add(tasks[i].profit);
        }
        int totalProfit = 0;
        while (!chosenTasks.isEmpty()) {
            totalProfit += chosenTasks.peek();
            chosenTasks.poll();
        }
        return totalProfit;

    }

    public static void main(String[] args) {
        Task [] tasks = new Task[]{new Task(4, 20), new Task(2, 10),
                new Task(2, 40), new Task(1, 30)};
        System.out.println(getMaxProfit(tasks));

    }

}
