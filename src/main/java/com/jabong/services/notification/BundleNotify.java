package com.jabong.services.notification;

import java.util.List;

import org.springframework.scheduling.annotation.Async;

import com.jabong.models.Bundle;
import com.jabong.models.dao.BundleDAO;
import com.jabong.services.JabongBus;
import com.jabong.services.response.BundleListResponse;

public class BundleNotify {
	
	
	private BundleDAO bundleDao;

	public void setBundleDao(BundleDAO bundleDao) {
		this.bundleDao = bundleDao;
	}

	public void update(Integer id) {
		
		
	}
	
	public void create(Integer id) {
		
	}
	
	public void delete(Integer id) {
		
	}
	
	@Async
	public void activeList() {
		
		    JabongBusMessage jb = new JabongBusMessage();
		    jb.setType("Bundle");
		try { 
		//Thread.sleep(10000);
		List<Bundle> bundles = bundleDao.fetchActiveList();
		BundleListResponse response = new BundleListResponse(bundles);
		Object data = response.getData();
		
		
		jb.setData(data);
		jb.publish();
		} catch (Exception e) {
			
		}
	}
}
