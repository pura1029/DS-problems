package com.gtm.ds.inttest;

import java.util.Arrays;
import java.util.Comparator;
//https://javaconceptoftheday.com/return-value-from-try-catch-finally-blocks/
public class ExceptionTest {

    private String str = "1";

    public void test() {
        test1();
    }

    public void test1() {
        try {
            test2();
            str += 8;
        } catch (Exception e) {
            str += 6;
        }
        str += 7;
    }

    public void test2() throws Exception {
        //If try-catch-finally blocks are returning a value according to rules,
        // then you should not keep any statements after finally block.
        // Because they become unreachable and in Java, Unreachable code gives compile time error.
        try {
            str += 3;
            throw new Exception();
        } catch (Exception e) {
            str += 5;
            throw e;
        } finally {
            str += 4;
        }
        //str += 2;//Compile Time Error : Unreachable Code
    }

    public String test3() {
        try {
            str += 8;
            return str;
        } catch (Exception e) {
            str += 6;
            return str;
        } finally {
            str += 4;
        }
        //str += 7;//Compile Time Error : Unreachable Code
    }

    public String test4() {
        try {
            str = "" + 8;
            return str;
        } catch (Exception e) {
            str = "" + 6;
            return str;
        } finally {
            //finally block overrides any return values from try and catch blocks.
            str = "" + 4;
            return str;
        }
        //str += 7;//Compile Time Error : Unreachable Code
    }

    public String test5() {
        try {
            str = "" + 8;
            return str;
        } catch (Exception e) {
            str = "" + 6;
            return str;
        } finally {
            //Now, This block may or may not return a value
            //as both try and catch blocks are returning a value
        }
        //str += 7;//Compile Time Error : Unreachable Code
    }

    public String test6() {
        try {
            str = "" + 8;
            //This block may or may not return a value as finally block is returning a value
        } catch (Exception e) {
            str = "" + 6;
            //This block may or may not return a value as finally block is returning a value
        } finally {
            str = "" + 4;
            return str;
        }
        //str += 7;//Compile Time Error : Unreachable Code
    }

    public String test7() {
        try {
            str = "" + 8;
            //This block may or may not return a value as finally block is returning a value
        } catch (Exception e) {
            str = "" + 6;
            //This block may or may not return a value as finally block is returning a value
        } finally {
            str = "" + 4;
            //return str;
        }
        str += 7;
        return str;
    }

    public static void main(String[] args) {
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.test();
        System.out.println(exceptionTest.str);

        Integer[] arr = {2, 4, 3, 1};

        Comparator<Integer> comparator = (n1, n2) -> n2.compareTo(n1);
        Arrays.sort(arr, comparator);

        System.out.println(Arrays.toString(arr));

        System.out.println(new ExceptionTest().test3());
        System.out.println(new ExceptionTest().test4());
        System.out.println(new ExceptionTest().test7());
    }

}
