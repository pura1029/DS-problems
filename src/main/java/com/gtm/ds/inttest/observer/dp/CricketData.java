package com.gtm.ds.inttest.observer.dp;

import java.util.ArrayList;
import java.util.Iterator;
//publisher class
public class CricketData implements Subject {
	int runs;
	int wickets;
	float overs;
	ArrayList<Observer> observerList;

	public CricketData() {
		observerList = new ArrayList<>();
	}

	@Override
	public void registerObserver(Observer o) {
		observerList.add(o);
	}

	@Override
	public void unregisterObserver(Observer o) {
		observerList.remove(observerList.indexOf(o));
	}

	@Override
	public void notifyObservers() {
		for (Iterator<Observer> it = observerList.iterator(); it.hasNext();) {
			Observer o = it.next();
			o.update(runs, wickets, overs);
		}
	}

	// get latest runs from stadium
	private int getLatestRuns() {
		// return 90 for simplicity
		return 90;
	}

	// get latest wickets from stadium
	private int getLatestWickets() {
		// return 2 for simplicity
		return 2;
	}

	// get latest overs from stadium
	private float getLatestOvers() {
		// return 90 for simplicity
		return (float) 10.2;
	}

	// This method is used update displays
	// when data changes
	public void dataChanged() {
		// get latest data
		runs = getLatestRuns();
		wickets = getLatestWickets();
		overs = getLatestOvers();

		notifyObservers();
	}
}