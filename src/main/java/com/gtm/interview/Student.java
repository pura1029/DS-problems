/**
 * 
 */
package com.gtm.interview;

/**
 * @author kumarga
 *
 */
@SuppressWarnings("rawtypes")
public class Student implements Comparable {

	int rollno;  
	String name;  
	int age;  
	Student(int rollno,String name,int age){  
	this.rollno=rollno;  
	this.name=name;  
	this.age=age;  
	}
	@Override
	public int compareTo(Object arg0) {
		Student s=(Student)arg0;
		if (age==s.age) {
			return 0;
		}
		if (age>s.age) {
			return 1;
		} else {
			return -1;
		}
		
	}
	public static void main(String[] args) {
		new Student(101,"Vijay",23);  
		new Student(106,"Ajay",27);  
		new Student(105,"Jai",21); 
	}

}
