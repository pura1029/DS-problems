package com.gtm.ds.recursion;

public class NumberofSteps {

    public int numberOfSteps(int num) {
        return helper(num, 0);
    }

    private int helper(int num, int step) {
        if (num == 0) {
            return step;
        }

        if (num % 2 == 0) {
            return helper(num / 2, step + 1);
        }

        return helper(num - 1, step + 1);
    }

    public int numberOfSteps1(int num) {
        int step = 0;
        while (num > 0) {
            if (num % 2 == 0) {
                step++;
                num /= 2;
            } else {
                step++;
                num -= 1;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new NumberofSteps().numberOfSteps1(14));

    }

}
