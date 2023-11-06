package com.gtm.ds.design.adapter1;

public class PngShower implements AdvancedImageViewer {
    @Override
    public void showPng(String fileName) {
        System.out.println("Showing png file. Name: " + fileName);
    }

    @Override
    public void showJpg(String fileName) {
        //do nothing
    }
}
