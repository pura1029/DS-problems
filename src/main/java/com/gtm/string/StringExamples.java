package com.gtm.string;
//https://javaconceptoftheday.com/how-the-strings-are-stored-in-the-memory/
public class StringExamples {
    public static void main(String[] args) {
        String s1 = new String("JAVA");

        System.out.println(s1);         //Output : JAVA

        s1 = s1.concat("J2EE");

        String s2 = "JAVAJ2EE";

        System.out.println(s1.hashCode());         //Output : JAVA
        System.out.println(s2.hashCode());
        System.out.println(s1 == s2);

        String str1 = "Hello";
        String str2 = "World";
        String str3 = new String("HelloWorld");
        String str4 = str1 + str2;

        //Till now you have five String objects, four in String Constant Pool and one in Heap. So your str4 is a new object altogether inside the String Pool, Please check the below code also,

        String str5 = "HelloWorld"; //This line will create one more String Constant Pool object because we are using the variable name as str5.
        String str6 = "HelloWorld";//This line will not create any object, this will refer the same object str5.

        System.out.println(str3==str4); //false
        System.out.println(str4==str5);//false
        System.out.println(str5==str6);//true
    }
}