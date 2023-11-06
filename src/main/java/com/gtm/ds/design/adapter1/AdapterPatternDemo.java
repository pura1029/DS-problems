package com.gtm.ds.design.adapter1;

//https://www.scaler.com/topics/design-patterns/adapter-design-pattern/
public class AdapterPatternDemo {
    public static void main(String[] args) {

        GalleryApp gallery = new GalleryApp();

        gallery.show("jpeg", "naruto.jpeg");
        gallery.show("png", "sasuke.png");
        gallery.show("jpg", "jiraya.jpg");
        gallery.show("gif", "sakura.gif");
    }
}
