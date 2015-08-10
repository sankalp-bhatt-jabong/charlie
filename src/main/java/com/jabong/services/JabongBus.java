package com.jabong.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jabong.models.dao.BundleDAO;

@Component
public class JabongBus {

	final static Logger logger = Logger.getLogger(JabongBus.class);
	
	static BundleDAO bundleDao;
	
	public static void setBundleDao() {
		JabongBus.bundleDao = ApplicationContextProvider.getApplicationContext()
		.getBean("bundleDao", BundleDAO.class);
		logger.debug("Bundle dao set");
	}

	@Async
	public void publish() {
		JabongBus.setBundleDao();
		try {
			Thread.sleep(100000); // 100 seconds
			bundleDao.getReverseSkuBundleMap();
		} catch (Exception e) {
			logger.error("Sorry, something wrong!", e);
		}
	}

}
