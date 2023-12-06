package com.gtm.ds.design.behavioral.observer;

import java.io.File;

public class LogOpenListener implements EventListener {
    private File file;

    public LogOpenListener(String filePath) {
        this.file = new File(filePath);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Save to log " + this.file + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}