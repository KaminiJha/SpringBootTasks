package com.springboot.workers.springjdbc.util;

import java.sql.Timestamp;

public class DateTimeUtilities {

	public static String getTime()
	{
		return new Timestamp(System.currentTimeMillis()).toString();
	}
}
