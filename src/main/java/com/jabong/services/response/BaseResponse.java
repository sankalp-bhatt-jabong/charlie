package com.jabong.services.response;

public class BaseResponse
{

    private int errorcode;
    private Object data;
    public static final int NO_EXCEPTION             = 0;
    public static final int DATA_NOT_FOUND_EXCEPTION = 1;
    public static final int OTHER_EXCEPTION          = 2;

    public int getErrorcode()
    {
        return errorcode;
    }
    public void setErrorcode(int errorcode)
    {
        this.errorcode = errorcode;
    }
    public void setErrorCode(int errorcode)
    {
        this.errorcode = errorcode;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

}
