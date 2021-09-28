package com.gtm.ds.recursion;

public class TawersOfHanoi {

    public void move(int n, char from, char to, char aux) {
        if (n == 1) {
            System.out.println("Move disk-" + n + " from " + from + " to " + to);
            return;
        }

        move(n - 1, from, aux, to);
        System.out.println("Move disk-" + n + " from " + from + " to " + to);
        move(n - 1, aux, to, from);

    }

    public static void main(String[] args) {
        TawersOfHanoi hanoi = new TawersOfHanoi();
        hanoi.move(3, 'A', 'B', 'C');

    }

}
