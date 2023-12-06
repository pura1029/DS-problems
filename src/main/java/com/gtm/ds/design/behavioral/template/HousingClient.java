package com.gtm.ds.design.behavioral.template;
//https://www.digitalocean.com/community/tutorials/template-method-design-pattern-in-java
//https://refactoring.guru/design-patterns/template-method/java/example
public class HousingClient {

    public static void main(String[] args) {

        HouseTemplate houseType = new WoodenHouse();

        //using template method
        houseType.buildHouse();
        System.out.println("************");

        houseType = new GlassHouse();

        houseType.buildHouse();
    }

}