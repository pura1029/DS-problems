package com.gtm.ds.design.observer;

import java.io.File;
// The object that is being watched is called Subject.
public interface Subject {

    //methods to register and unregister observers
    void subscribe(String eventType, EventListener listener);

    void unsubscribe(String eventType, EventListener listener);

    //method to notify observers of change
    void notify(String eventType, File file);

}