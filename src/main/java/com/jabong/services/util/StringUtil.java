package com.jabong.services.util;

public class StringUtil
{
    /**
     * test the value of attribute
     * 
     * @param result
     * @param attribute
     * @return boolean
     */
    public static boolean empty(Object value)
    {
        if (value == null) {
            return true;
        }

        if (value.getClass().isArray()) {
            Object[] val = (Object[]) value;
            if (val.length == 0) {
                return true;
            }
        }

        if (value.equals(false) || value.equals("") || value.equals("0")) {
            return true;
        }
        return false;
    }

}