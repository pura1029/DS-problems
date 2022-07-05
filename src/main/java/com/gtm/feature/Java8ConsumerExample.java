package com.gtm.feature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Java8ConsumerExample {
	public static void main(String[] args) {

		List<Student> studentList=createStudentList(); 
		// Creating Consumer for student object which will be used in forEach method of list
		Consumer<Student> consumerForStudent=(Student s) -> {
			System.out.println("name : "+s.getName()+" == Age : "+s.getAge());
		};
		studentList.forEach(consumerForStudent);
	}
	public static List<Student> createStudentList()
	{
		List<Student> studentList=new ArrayList<Student>();
		Student s1=new Student(1, "Arpit", "M", 19);
		Student s2=new Student(2, "John", "M", 17);
		Student s3=new Student(3, "Mary", "F", 14);
		Student s4=new Student(4, "Martin", "M", 21);
		Student s5=new Student(5, "Monica", "F", 16);
		Student s6=new Student(6, "Ally", "F", 20);

		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		studentList.add(s5);
		studentList.add(s6);
		return studentList;
	}
}
