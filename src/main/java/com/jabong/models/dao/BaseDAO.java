package com.jabong.models.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BaseDAO {

	public static String getCurrentDate() {
		return BaseDAO.getCurrentDate("yyyy-MM-dd HH:mm:ss");
	}

	public static String getCurrentDate(String format) {
		Calendar c = Calendar.getInstance();
		String sd = new SimpleDateFormat(format).format(c.getTime());
		return sd;
	}

}
