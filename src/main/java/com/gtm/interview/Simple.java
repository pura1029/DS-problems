/**
 * 
 */
package com.gtm.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author kumarga
 *
 */
public class Simple {

    /**
     * @param args
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(new Student(101, "Vijay", 23));
        al.add(new Student(106, "Ajay", 27));
        al.add(new Student(105, "Jai", 21));

        Collections.sort(al);
        Iterator itr = al.iterator();
        while (itr.hasNext()) {
            Student st = (Student) itr.next();
            System.out.println(st.rollno + " " + st.name + " " + st.age);
            Object object = null;
            String string = (String) object;
            System.out.println("String:" + string);
        }
    }
}
