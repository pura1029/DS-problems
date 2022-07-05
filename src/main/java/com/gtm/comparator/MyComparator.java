/**
 * 
 */
package com.gtm.comparator;

import java.util.Comparator;

/**
 * @author kumarga
 *
 */
public class MyComparator {

	public static Comparator<Employee> IdComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return (new Integer(o1.getEmpId()).compareTo(new Integer(o2.getEmpId())));
		}

	};
	public static Comparator<Employee> NameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return (o1.getEmpName()).compareTo(o2.getEmpName());
		}

	};
	public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return (new Integer(o1.getEmpAge()).compareTo(new Integer(o2.getEmpAge())));
		}

	};
}
