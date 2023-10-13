package com.gtm.clone.deep;

//https://howtodoinjava.com/java/cloning/a-guide-to-object-cloning-in-java/
public class TestClone {

    /**
     * @param args
     * @throws CloneNotSupportedException
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Department hr = new Department(1, "HR");
        Employee original = new Employee(1, "Test", hr);
        Employee cloned = (Employee) original.clone();

        cloned.getDepartment().setName("Finance");
        System.out.println(original.getDepartment().getName());
        System.out.println(cloned.getDepartment().getName());

        System.out.println(original.getClass() == cloned.getClass());

        System.out.println(original == cloned);

    }

}
