package com.gtm.clone.deep;

public class Employee implements Cloneable {

	private Department department;
	private int id;
	private String name;


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public Department getDeparment() {
		return department;
	}

	public void setDeparment(Department department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		Employee cloned=(Employee)super.clone();
		cloned.setDeparment((Department)cloned.getDeparment().clone());
		return cloned;
		
	}
}
