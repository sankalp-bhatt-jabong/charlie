package com.jabong.services.response;

public class BaseResponse
{

    private int errorCode;
    private Object data;
    public static final int No_EXCEPTION             = 0;
    public static final int DATA_NOT_FOUND_EXCEPTION = 1;
    public static final int OTHER_EXCEPTION          = 2;

    public int getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(int errorCode)
    {
        this.errorCode = errorCode;
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
