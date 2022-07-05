package com.gtm.clone.shallow;

public class TestClone {

	/**
	 * @param args
	 * @throws CloneNotSupportedException 
	 */
	public static void main(String[] args) throws CloneNotSupportedException {
		Department hr = new Department(1, "Human Resource");
		Employee original = new Employee(1, "Admin", hr);
		Employee cloned = (Employee)original.clone();
		
		cloned.getDeparment().setName("Finance");
		System.out.println(original.getDeparment().getName());
		
		System.out.println(original.getClass() == cloned.getClass());
		
		System.out.println(original != cloned);

	}

}
