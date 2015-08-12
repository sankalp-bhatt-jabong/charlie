package com.jabong.services.util;

import java.io.IOException;
import java.util.Properties;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.core.io.ClassPathResource;

public class SeaLogger {

	private static String path = "config/log4j.properties";

	private Logger exceptionLogger = null;
	private Logger utilityLogger = null;

	private static SeaLogger selfInstance = null;

	/**
	 * Disable Creation of Objects of this class, from outside.
	 */
	private void SeaLogger() {

	}

	public static SeaLogger getInstance() throws IOException {
		if (selfInstance == null) {
			Properties props = new Properties();
			props.load((new ClassPathResource(path)).getInputStream());
			LogManager.resetConfiguration();
			PropertyConfigurator.configure(props);
			selfInstance = new SeaLogger();
			selfInstance.exceptionLogger = Logger.getLogger("EXCEPTION");
			selfInstance.utilityLogger = Logger.getLogger("UTILITY");
		}
		return selfInstance;
	}

	public Logger getExceptionLogger() {
		return selfInstance.exceptionLogger;
	}

	public Logger getUtilityLogger() {
		return selfInstance.utilityLogger;
	}

}
