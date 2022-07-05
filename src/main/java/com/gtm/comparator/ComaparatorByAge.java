/**
 * 
 */
package com.gtm.comparator;

import java.util.Comparator;

/**
 * @author kumarga
 *
 */
public class ComaparatorByAge implements Comparator<Employee> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Employee empoyee1, Employee empoyee2) {
		return empoyee1.getEmpAge() > empoyee2.getEmpAge() ? 1 : empoyee1.getEmpAge() < empoyee2.getEmpAge() ? -1 : 0;
	}
	
}
