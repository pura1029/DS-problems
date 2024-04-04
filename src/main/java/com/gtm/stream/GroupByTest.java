/*
 * Copyright (c) 2024 VMware, Inc. All Rights Reserved.
 *
 */

package com.gtm.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Insert your comment for {@link GroupByTest}.
 *
 * @author kumargautam
 */
public class GroupByTest {

    enum Gender {
        Male, Female
    }

    @AllArgsConstructor
    @Getter
    static class Aadhaar {
        String name;
        Gender gender;
        String city;
    }

    public static void main(String[] args) {
        List<Aadhaar> aadhaars = new ArrayList<>();
        aadhaars.add(new Aadhaar("abc", Gender.Male, "Bang"));
        aadhaars.add(new Aadhaar("bcd", Gender.Male, "Bang"));
        aadhaars.add(new Aadhaar("cde", Gender.Female, "Bang"));
        aadhaars.add(new Aadhaar("cdf", Gender.Male, "Vara"));

        Map<String, Map<Gender, List<Aadhaar>>> mapByCity = aadhaars.stream().collect(Collectors.groupingBy(Aadhaar::getCity, Collectors.groupingBy(Aadhaar::getGender)));

        double per = (double) mapByCity.get("Bang").get(Gender.Male).size() * 100.0 / mapByCity.get("Bang").values().stream().
                flatMapToInt(aaList -> IntStream.of(aaList.size())).sum();

        System.out.println(per);
    }
}
