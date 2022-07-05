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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Employee empoyee1, Employee empoyee2) {
		return empoyee1.getEmpName().compareTo(empoyee2.getEmpName());
		// return empoyee1.getEmpId() > empoyee2.getEmpId() ? 1 : empoyee1.getEmpId() <
		// empoyee2.getEmpId() ? -1 : 0;

	}

	public int compareTo(String firstString, String anotherString) {
		int len1 = firstString.length();
		int len2 = anotherString.length();
		int lim = Math.min(len1, len2);
		char v1[] = firstString.toCharArray();
		char v2[] = anotherString.toCharArray();

		int k = 0;
		while (k < lim) {
			char c1 = v1[k];
			char c2 = v2[k];
			if (c1 != c2) {
				return c1 - c2;
			}
			k++;
		}
		return len1 - len2;
	}

	public static void main(String[] args) {
		ComaparatorByName byName = new ComaparatorByName();
		System.out.println(byName.compareTo("Gautam", "Gaurav"));
	}

}
