package com.jabong.services.util;

public class StringUtil {
	/**
	 * test the value of attribute
	 * 
	 * @param result
	 * @param attribute
	 * @return boolean
	 */
	public static boolean empty(Object value) {
		boolean test = false;
		if (value.getClass().isArray()) {
			Object[] val = (Object[]) value;
			if (val.length == 0 || val == null) {
				test = true;
			}
		} else {
			if (value.equals(false) || value.equals("") || value.equals("0")
					|| value == null) {
				test = true;
			}
		}
		return test;
	}

}