/**
 * 
 */
package com.gtm.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author kumarga
 *
 */
public class ComaparatorMain {


	public static Comparator<Employee> idComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee o1, Employee o2) {
			// TODO Auto-generated method stub
			return (new Integer(o1.getEmpId()).compareTo(new Integer(o2.getEmpId())));
		}

	}; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Employee employee1 = new Employee(11,"Ram",20);
		Employee employee2 = new Employee(13,"Shyam",10);
		Employee employee3 = new Employee(12,"Aman",30);
		Employee employee4 = new Employee(14,"Raman",40);

		List<Employee> list = new ArrayList<Employee>();
		list.add(employee1);
		list.add(employee2);
		list.add(employee3);
		list.add(employee4);

		//Collections.sort(list, new ComaparatorByName());
		//Collections.sort(list, new ComaparatorByAge());
		//Collections.sort(list, idComparator);
		//Collections.sort(list, MyComparator.NameComparator);
		//Collections.sort(list, MyComparator.AgeComparator);
		Collections.sort(list, MyComparator.IdComparator);

		for (Employee employee : list) {
			System.out.println(employee.toString());
		}

	}

	/*static class MyComparator{
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
	}*/
}
