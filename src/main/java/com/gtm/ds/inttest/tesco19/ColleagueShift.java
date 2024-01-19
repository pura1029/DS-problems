/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */
package com.gtm.ds.inttest.tesco19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;


public class ColleagueShift {

    private static class Shift {
        private int start;
        private int end;

        public Shift(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Shift{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void getShift(List<Shift> shiftList) {
        if (shiftList == null || shiftList.isEmpty()) {
            return;
        }
        //Sorting
        Collections.sort(shiftList, Comparator.comparingInt(sh -> sh.start));
        Stack<Shift> shiftStack = new Stack<>();
        shiftStack.push(shiftList.get(0));
        /**
         * result list
         * index value=0
         * list.set(index,shift)
         */

        for (int i = 1; i < shiftList.size(); i++) {
            Shift prevShift = shiftStack.peek();
            Shift shift = shiftList.get(i);
            if (shift.start <= prevShift.end) {
                prevShift.end = shift.end;
                shiftStack.pop();
                shiftStack.push(prevShift);
            } else {
                shiftStack.push(shift);
            }
        }

        Enumeration<Shift> elements = shiftStack.elements();
        while (elements.hasMoreElements()) {
            System.out.println(elements.nextElement());
        }
    }

    public static void main(String[] args) {
        List<Shift> shiftList = new ArrayList<>();

        shiftList.add(new Shift(8, 10));
        shiftList.add(new Shift(14, 19));
        shiftList.add(new Shift(10, 12));
        getShift(shiftList);
        System.out.println("===================");
        List<Shift> shiftList1 = new ArrayList<>();

        shiftList1.add(new Shift(8, 11));
        shiftList1.add(new Shift(14, 19));
        shiftList1.add(new Shift(10, 12));

        getShift(shiftList1);
        System.out.println("===================");
        List<Shift> shiftList2 = new ArrayList<>();

        shiftList2.add(new Shift(8, 11));

        getShift(shiftList2);
        /**
         * if time in epoch value
         * To display the time of given date will use Date object,
         * convert form epoch value to time of given date
         */
        Date date = new Date(System.currentTimeMillis());

    }

}
