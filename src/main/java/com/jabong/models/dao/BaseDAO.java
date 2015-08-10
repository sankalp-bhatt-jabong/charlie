package com.jabong.models.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BaseDAO {

	public static String getCurrentDate() {
		return BaseDAO.getCurrentDate("yyyy-MM-dd HH:mm:ss");
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
	 */
	public static String getDateTime(String dateTime) {
		Date date = null;
		String formattedDate = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = df.parse(dateTime);
			formattedDate = df.format(date);
		} catch (Exception ex) {
			ex.getStackTrace();
		}
		return formattedDate;
	}

}
