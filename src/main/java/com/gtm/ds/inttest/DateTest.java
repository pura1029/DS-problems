package com.gtm.ds.inttest;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTest {

	public static void main(String[] args) {
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");// 2018-06-06T21:59:36Z
		System.out.println(zonedDateTime.format(formatter));
	}

}