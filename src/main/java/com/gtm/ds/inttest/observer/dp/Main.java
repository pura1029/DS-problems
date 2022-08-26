package com.gtm.ds.inttest.observer.dp;

//https://www.geeksforgeeks.org/observer-pattern-set-2-implementation/
// Java program to demonstrate working of
//onserver pattern
// Driver Class
public class Main {
	public static void main(String args[]) {
		//Subscriber class
		// create objects for testing
		AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
		CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();

		//publisher class
		// pass the displays to Cricket data
		CricketData cricketData = new CricketData();

		// register display elements
		cricketData.registerObserver(averageScoreDisplay);
		cricketData.registerObserver(currentScoreDisplay);

		// in real app you would have some logic to
		// call this function when data changes
		cricketData.dataChanged();

		// remove an observer
		cricketData.unregisterObserver(averageScoreDisplay);

		// now only currentScoreDisplay gets the
		// notification
		cricketData.dataChanged();
	}
}