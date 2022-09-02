package com.gtm.ds.inttest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class RemoveDuplicateEmpFromList {

	static class Emp {
		int id;
		int dId;
		String name;

		public Emp(int id, int dId, String name) {
			super();
			this.id = id;
			this.dId = dId;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Emp [id=" + id + ", dId=" + dId + ", name=" + name + "]";
		}
	}

	static class EmpKey {
		int id;
		int dId;

		public EmpKey(int id, int dId) {
			super();
			this.id = id;
			this.dId = dId;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + dId;
			result = prime * result + id;
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
			EmpKey other = (EmpKey) obj;
			if (dId != other.dId)
				return false;
			if (id != other.id)
				return false;
			return true;
		}
	}

	public static void removeDuplicate(List<Emp> emps) {
		Set<EmpKey> empKeys = new HashSet<>();
		Iterator<Emp> iterator = emps.iterator();
		while (iterator.hasNext()) {
			Emp emp = iterator.next();
			EmpKey empKey = new EmpKey(emp.id, emp.dId);
			if (empKeys.contains(empKey)) {
				iterator.remove();
			} else {
				empKeys.add(empKey);
			}
		}
	}

	public static void main(String[] args) {
		Emp emp1 = new Emp(1, 1, "Ram");
		Emp emp2 = new Emp(1, 2, "Ram");
		Emp emp3 = new Emp(2, 1, "Ramu");
		Emp emp4 = new Emp(2, 2, "Ramu");
		List<Emp> emps = new ArrayList<>();
		emps.add(emp1);
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		emps.add(emp3);
		System.out.println(emps);

		removeDuplicate(emps);

		System.out.println("After duplicate remove...");
		System.out.println(emps);
	}

}
