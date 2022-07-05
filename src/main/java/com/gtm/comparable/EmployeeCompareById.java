/**
 * 
 */
package com.gtm.comparable;

/**
 * @author kumarga
 *
 */
public class EmployeeCompareById implements Comparable<EmployeeCompareById> {


	private int empId;
	private String empName;
	private int empAge;
	public EmployeeCompareById() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeCompareById(int empId, String empName, int empAge) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	@Override
	public String toString() {
		return "EmployeeCompareById [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(EmployeeCompareById employee1) {
		
		//return this.getEmpId() > employee1.getEmpId() ? 1 : this.getEmpId() < employee1.getEmpId() ? -1 : 0;
		
		/*String thisName = this.getEmpName();
		String compName = employee1.getEmpName();
		return  ((int)thisName.charAt(0)) - ((int)compName.charAt(0));*/
		
		Integer thisId = this.getEmpId();
		Integer comId = employee1.getEmpId();
		return thisId.compareTo(comId);
		
		//return ((this.getEmpName()).compareTo(employee1.getEmpName()));
	}

}
