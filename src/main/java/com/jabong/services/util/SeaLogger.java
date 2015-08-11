package com.jabong.services.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SeaLogger {

    private static String path = "src/resources/config/log4j.properties";
    private static SeaLogger sealogger = null;
    
    private void SeaLogger() {
    
    }
    
    public static SeaLogger getInstance() {
    	if (sealogger == null) {
    		PropertyConfigurator.configure(path);
    		sealogger = new SeaLogger();
    	}
    	return sealogger;
    }
    
    public Logger getLogger(Class<?> className) {
    	return Logger.getLogger(className);
    }
	
}
