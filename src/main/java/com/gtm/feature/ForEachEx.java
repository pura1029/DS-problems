package com.gtm.feature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class ForEachEx {
	private static void dis() {
		Map < String, List < String >> phoneNumbers = new HashMap < String, List < String >> ();
		phoneNumbers.put("John Lawson", Arrays.asList("3232312323", "8933555472"));
		phoneNumbers.put("Mary Jane", Arrays.asList("12323344", "492648333"));
		phoneNumbers.put("Mary Lou", Arrays.asList("77323344", "938448333"));

		Map < String, List < String >> filteredNumbers = phoneNumbers.entrySet()
				.stream().filter(x -> x.getKey().contains("Mary"))
				.collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
		filteredNumbers.forEach((key, value)->{
			System.out.print("Name: " + key + ": ");
			value.forEach((v)->{
				System.out.print(v+" ");
			});
			System.out.println();
		});

		System.out.println("groupingBy key");
		Map<Object, List<Entry<String, List<String>>>> filteredNumbers1 = phoneNumbers.entrySet()
				.stream().collect(Collectors.groupingBy(p -> p.getKey()));

		filteredNumbers1.forEach((kk, vv) ->{
			System.out.print("Name: " + kk + " AND ");
			vv.forEach((v)->{
				System.out.print("phoneNumbers: " +v.getValue());
			});
			System.out.println();
		});

	}

	public static void main(String[] args) {
		dis();
	}
}
