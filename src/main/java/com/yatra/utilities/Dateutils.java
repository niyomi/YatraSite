package com.yatra.utilities;

import java.util.Date;

public class Dateutils {
	
	public static String getTimeStamp()
	{
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}

}
