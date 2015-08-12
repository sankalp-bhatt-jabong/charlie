package com.jabong.exception;

public class DataNotFoundException extends Exception
{
    private static final String MESSAGE = "data not found";

    // Parameterless Constructor
    public DataNotFoundException()
    {
        super(MESSAGE);
    }

    // Constructor that accepts a message
    public DataNotFoundException(String message)
    {
        super(message);

    }

}
