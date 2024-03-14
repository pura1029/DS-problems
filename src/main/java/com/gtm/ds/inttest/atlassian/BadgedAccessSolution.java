package com.gtm.ds.inttest.atlassian; /**
 * We are working on a security system for a badged-access room in our company's building.
 * <p>
 * Given an ordered list of employees who used their badge to enter or exit the room, write a function that returns two collections:
 * <p>
 * 1. All employees who didn't use their badge while exiting the room - they recorded an enter without a matching exit. (All employees are required to leave the room before the log ends.)
 * <p>
 * 2. All employees who didn't use their badge while entering the room - they recorded an exit without a matching enter. (The room is empty when the log begins.)
 * <p>
 * Each collection should contain no duplicates, regardless of how many times a given employee matches the criteria for belonging to it.
 * <p>
 * records1 = [
 * ["Paul",     "enter"],
 * ["Pauline",  "exit"],
 * ["Paul",     "enter"],
 * ["Paul",     "exit"],
 * ["Martha",   "exit"],
 * ["Joe",      "enter"],
 * ["Martha",   "enter"],
 * ["Steve",    "enter"],
 * ["Martha",   "exit"],
 * ["Jennifer", "enter"],
 * ["Joe",      "enter"],
 * ["Curtis",   "exit"],
 * ["Curtis",   "enter"],
 * ["Joe",      "exit"],
 * ["Martha",   "enter"],
 * ["Martha",   "exit"],
 * ["Jennifer", "exit"],
 * ["Joe",      "enter"],
 * ["Joe",      "enter"],
 * ["Martha",   "exit"],
 * ["Joe",      "exit"],
 * ["Joe",      "exit"]
 * ]
 * <p>
 * Expected output: ["Steve", "Curtis", "Paul", "Joe"], ["Martha", "Pauline", "Curtis", "Joe"]
 * <p>
 * Other test cases:
 * <p>
 * records2 = [
 * ["Paul", "enter"],
 * ["Paul", "exit"],
 * ]
 * <p>
 * Expected output: [], []
 * <p>
 * records3 = [
 * ["Paul", "enter"],
 * ["Paul", "enter"],
 * ["Paul", "exit"],
 * ["Paul", "exit"],
 * ]
 * <p>
 * Expected output: ["Paul"], ["Paul"]
 * <p>
 * records4 = [
 * ["Raj", "enter"],
 * ["Paul", "enter"],
 * ["Paul", "exit"],
 * ["Paul", "exit"],
 * ["Paul", "enter"],
 * ["Raj", "enter"],
 * ]
 * <p>
 * Expected output: ["Raj", "Paul"], ["Paul"]
 * <p>
 * All Test Cases:
 * mismatches(records1) => ["Steve", "Curtis", "Paul", "Joe"], ["Martha", "Pauline", "Curtis", "Joe"]
 * mismatches(records2) => [], []
 * mismatches(records3) => ["Paul"], ["Paul"]
 * mismatches(records4) => ["Raj", "Paul"], ["Paul"]
 * <p>
 * n: length of the badge records array
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BadgedAccessSolution {

    public static List<Set<String>> find(String[][] records) {
        Map<String, String> ruleMap = new HashMap<>();
        List<Set<String>> res = new ArrayList<>();
        Set<String> existSet = new HashSet<>();
        Set<String> enterSet = new HashSet<>();
        for (int i = 0; i < records.length; i++) {
            String name = records[i][0];
            String action = records[i][1];

            if ("exit".equals(action)) {
                if (!ruleMap.containsKey(name)) {
                    existSet.add(name);
                } else if (ruleMap.containsKey(name) && ruleMap.get(name).equals("enter")) {
                    ruleMap.remove(name);
                } else if (ruleMap.containsKey(name) && ruleMap.get(name).equals("exit")) {
                    existSet.add(name);
                }
            } else if ("enter".equals(action)) {
                if (ruleMap.containsKey(name) && ruleMap.get(name).equals("enter")) {
                    enterSet.add(name);
                } else if (!ruleMap.containsKey(name)) {
                    ruleMap.put(name, action);
                }
            }
        }

        if (!ruleMap.isEmpty()) {
            System.out.println("ruleMap::" + ruleMap);
            ruleMap.entrySet().stream().forEach(entry -> {
                if (entry.getValue().equals("enter")) {
                    enterSet.add(entry.getKey());
                }
            });
        }
        res.add(enterSet);
        res.add(existSet);
        return res;
    }

    public static void main(String[] argv) {
        String[][] records1 = {
                {"Paul", "enter"},
                {"Pauline", "exit"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Martha", "exit"},
                {"Joe", "enter"},
                {"Martha", "enter"},
                {"Steve", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Joe", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Joe", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Joe", "enter"},
                {"Joe", "enter"},
                {"Martha", "exit"},
                {"Joe", "exit"},
                {"Joe", "exit"},
        };

        String[][] records2 = {
                {"Paul", "enter"},
                {"Paul", "exit"},
        };

        String[][] records3 = {
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
        };

        String[][] records4 = {
                {"Raj", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"},
                {"Paul", "enter"},
                {"Raj", "enter"},
        };

        System.out.println(find(records1));
        System.out.println(find(records2));
        System.out.println(find(records3));
        System.out.println(find(records4));
    }

}
