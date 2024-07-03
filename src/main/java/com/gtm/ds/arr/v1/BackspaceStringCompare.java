package com.gtm.ds.arr.v1;

/**
 * Problem:
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Solution:
 * Use two pointers to traverse both strings from the end to the beginning.
 * Skip characters in both strings when a backspace is encountered.
 * Compare the characters at the current positions of the pointers.
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        String S = "ab#c";
        String T = "ad#c";
        System.out.println(backspaceCompare(S, T)); // Output: true

        S = "ab##";
        T = "c#d#";
        System.out.println(backspaceCompare(S, T)); // Output: true

        S = "a##c";
        T = "#a#c";
        System.out.println(backspaceCompare(S, T)); // Output: true

        S = "a#c";
        T = "b";
        System.out.println(backspaceCompare(S, T)); // Output: false
    }

    public static boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;

        while (i >= 0 || j >= 0) {
            i = getNextValidIndex(S, i);
            j = getNextValidIndex(T, j);

            if (i < 0 && j < 0) return true; // Both strings have been fully processed
            if (i < 0 || j < 0) return false; // One string has been fully processed while the other has not
            if (S.charAt(i) != T.charAt(j)) return false; // Characters do not match

            i--;
            j--;
        }

        return true;
    }

    private static int getNextValidIndex(String str, int index) {
        int backspaceCount = 0;

        while (index >= 0) {
            if (str.charAt(index) == '#') {
                backspaceCount++;
            } else if (backspaceCount > 0) {
                backspaceCount--;
            } else {
                break;
            }
            index--;
        }

        return index;
    }
}
