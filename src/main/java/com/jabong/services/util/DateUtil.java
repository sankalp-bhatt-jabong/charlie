package com.jabong.services.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static String getCurrentDate() {
		return DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss");
	}

	public static String getCurrentDate(String format) {
		Calendar c = Calendar.getInstance();
		String sd = new SimpleDateFormat(format).format(c.getTime());
		return sd;
	}

	/**
	 * To convert date in a particular format
	 * 
	 * @param dateTime
	 * @return String
	 * @throws ParseException 
	 */
	public static String formatDateTime(String dateTime) throws ParseException {
		Date date = null;
		String formattedDate = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		date = df.parse(dateTime);
		formattedDate = df.format(date);
		return formattedDate;
	}

}
