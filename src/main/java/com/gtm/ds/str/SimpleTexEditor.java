package com.gtm.ds.str;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

//https://www.hackerrank.com/challenges/simple-text-editor/problem
public class SimpleTexEditor {

    private StringBuilder sb;
    private Deque<StringBuilder> prev;

    public SimpleTexEditor() {
        sb = new StringBuilder();
        prev = new LinkedList<>();
    }

    /*
     * 1 append - Append string W to the end of S . 2 Delete the last k characters
     * of S. 3 print - Print the kth character of S. 4 undo - Undo the last (not
     * previously undone) operation of type 1 or 2, reverting S to the state it was
     * in prior to that operation.
     */
    public void performOperations(String[] str) {
        String op = "";
        String arg = "";
        if (str.length >= 2) {
            op = str[0];
            arg = str[1];
        }

        if (str.length >= 1) {
            op = str[0];
        }

        switch (op) {
            case "0":
                System.out.println(sb);
                break;
            case "1":
                prev.push(new StringBuilder(sb.toString()));
                sb.append(arg);
                break;
            case "2":
                prev.push(new StringBuilder(sb.toString()));
                sb.delete(sb.length() - Integer.parseInt(arg), sb.length());
                break;
            case "3":
                System.out.println(sb.charAt(Integer.parseInt(arg) - 1));
                break;
            case "4":
                sb = prev.pop();
                break;
            default:
                System.out.println("Operation is not supported please enter [0,1,2,3,4]");
                break;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        SimpleTexEditor editor = new SimpleTexEditor();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ops = Integer.parseInt(br.readLine());

        for (int i = 0; i < ops; i++) {
            String str[] = br.readLine().split(" ");
            editor.performOperations(str);
        }
    }

}
