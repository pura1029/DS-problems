package com.gtm.ds.design.behavioral.observer;

import java.io.File;

//The object that watch on the state of another object are called Observer
public interface EventListener {

    //method to update the observer, used by subject
    void update(String eventType, File file);
}