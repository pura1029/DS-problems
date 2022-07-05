/**
 * 
 */
package com.gtm.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author kumarga
 *
 */
public class ComparableMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EmployeeCompareById employeeCompareById1 = new EmployeeCompareById(11,"Ram",20);
		EmployeeCompareById employeeCompareById2 = new EmployeeCompareById(13,"Shyam",10);
		EmployeeCompareById employeeCompareById3 = new EmployeeCompareById(12,"Aman",30);
		EmployeeCompareById employeeCompareById4 = new EmployeeCompareById(14,"Raman",40);

		Set<EmployeeCompareById> set = new HashSet<EmployeeCompareById>();
		set.add(employeeCompareById1);
		set.add(employeeCompareById2);
		set.add(employeeCompareById3);
		set.add(employeeCompareById4);

		List<EmployeeCompareById> list = new ArrayList<EmployeeCompareById>(set);

		Collections.sort(list);

		for (EmployeeCompareById employeeCompareById : list) {
			System.out.println(employeeCompareById.toString());
		}
	}

}
