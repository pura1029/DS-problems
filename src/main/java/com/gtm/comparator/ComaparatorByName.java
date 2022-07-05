/**
 * 
 */
package com.gtm.comparator;

import java.util.Comparator;

/**
 * @author kumarga
 *
 */
public class ComaparatorByName implements Comparator<Employee> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Employee empoyee1, Employee empoyee2) {
		return empoyee1.getEmpName().compareTo(empoyee2.getEmpName());
		//return empoyee1.getEmpId() > empoyee2.getEmpId() ? 1 : empoyee1.getEmpId() < empoyee2.getEmpId() ? -1 : 0;
				
	}

}
