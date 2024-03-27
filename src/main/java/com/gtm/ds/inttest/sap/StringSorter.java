package com.gtm.ds.inttest.sap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Write Java code to sort list strings based on the occurrence and
 * if occurrence is same then sort based on alphabetical order and remove duplicate string.
 */
public class StringSorter {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple", "pineapple");
        List<String> sortedStrings = sortByOccurrence(strings);

        System.out.println("Sorted strings: " + sortedStrings);
    }

    public static List<String> sortByOccurrence(List<String> strings) {
        Map<String, Integer> occurrenceMap = new HashMap<>();

        // Count the occurrence of each string
        for (String str : strings) {
            occurrenceMap.put(str, occurrenceMap.getOrDefault(str, 0) + 1);
        }

        // Custom comparator to sort by occurrence and then alphabetically
        Comparator<String> customComparator = (s1, s2) -> {
            int countComparison = Integer.compare(occurrenceMap.get(s2), occurrenceMap.get(s1));
            if (countComparison != 0) {
                return countComparison; // Sort by occurrence
            } else {
                return s1.compareTo(s2); // If occurrence is same, sort alphabetically
            }
        };

        // Sort the strings using the custom comparator
        strings = strings.stream().sorted(customComparator).distinct().collect(Collectors.toList());
        return strings;
    }
}
