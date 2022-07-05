package com.gtm.interview;

import java.text.DecimalFormat;

public class DecimalFormatDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern = "#0.000";
		DecimalFormat format = new DecimalFormat(pattern);
	    double val = 1555512.08899;
	    
	    System.out.println("val::"+format.format(val));
	}

}
