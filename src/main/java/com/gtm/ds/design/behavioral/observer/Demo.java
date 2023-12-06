package com.gtm.ds.design.behavioral.observer;

public class Demo {
    public static void main(String[] args) {
        String filePath = "/Users/kumargautam/Git_repo/GitHub-test/DS-problems/src/main/java/com/gtm/ds/design/observer/file.txt";
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener(filePath));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile(filePath);
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}