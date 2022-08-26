package com.gtm.ds.inttest.observer.dp;

// This interface is implemented by all those
// classes that are to be updated whenever there
// is an update from CricketData

//Subscriber class
public interface Observer {
	public void update(int runs, int wickets, float overs);
}