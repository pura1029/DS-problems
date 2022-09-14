package com.gtm.ds.inttest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MergeLists {

	static class Product {
		int id;
		String name;
		int makeId;

		public Product(int id, String name, int makeId) {
			this.id = id;
			this.name = name;
			this.makeId = makeId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product other = (Product) obj;
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

	}

	public static void main(String[] args) {
		// you can write to stdout for debugging purposes, e.g.
		System.out.println("This is a debug message");

		List<Product> list1 = new ArrayList<>();

		list1.add(new Product(1, "product one", 1));
		list1.add(new Product(2, "product two", 1));
		list1.add(new Product(3, "product three", 1));

		List<Product> list2 = new ArrayList<>();

		list2.add(new Product(101, "product four", 1));
		list2.add(new Product(2, "product two", 1));
		list2.add(new Product(3, "product five", 2));

		Set<Product> setPro = new HashSet<>();
		Map<String, Product> mapPro = new HashMap<>();

		int i = 0;
		int j = 0;
		while (i < list1.size() || j < list2.size()) {

			if (i < list1.size()) {
				Product p1 = list1.get(i);
				boolean flag = setPro.contains(p1);
				if (!flag) {
					mapPro.put(p1.name, p1);
				}
				if (!flag)
					setPro.add(p1);
				i++;
			}

			if (j < list2.size()) {
				Product p2 = list2.get(j);
				boolean flag1 = setPro.contains(p2);
				if (!flag1) {
					mapPro.put(p2.name, p2);
				}
				if (!flag1)
					setPro.add(p2);
				j++;
			}
		}
		System.out.println("Product size :" + setPro.size());
		System.out.println("Id :" + mapPro.get("product three").id);
	}
}
