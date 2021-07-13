package com.stockMarket.constants;

import java.util.Date;

public class CommonConstants {
	
	private CommonConstants() {
		
	}

	public static final int INT_ONE = 1;
	public static final int TEN_CR = 100000000;
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	
	public static Date today() {
		return new Date();
	}
}
