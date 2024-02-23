/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.ds.inttest.walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchProducts {

    public static List<List<String>> search(List<String> products, String key) {
        Collections.sort(products, String.CASE_INSENSITIVE_ORDER::compare);
        List<List<String>> result = new ArrayList<>();

        for (int i = 1; i <= key.length(); i++) {//nlogn+(n*n)=>n2
            String sKey = key.substring(0, i);
            List<String> resList = new ArrayList<>();
            int count = 0;
            for (String product : products) {
                if (count == 3) {
                    break;
                }
                if (product.startsWith(sKey)) {
                    resList.add(product);
                    count++;
                }
            }
            result.add(resList);
        }

        return result;
    }


    public static void main(String[] args) {
        List<String> products = Arrays.asList("mobile", "mouse", "moneypot", "monitor", "mousepad");
        List<List<String>> result = search(products, "mouse");
        System.out.println(result);
    }
}
