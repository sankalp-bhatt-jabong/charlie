package com.jabong.models.dao;

import java.util.List;

import com.jabong.models.Bundle;
import com.jabong.json.ActiveBundles;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class BundleDAO {
	private SessionFactory sessionFactory;

	public BundleDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Bundle> list() {
		@SuppressWarnings("unchecked")
		
		List<Bundle> bundles = (List<Bundle>) sessionFactory.getCurrentSession()
				.createCriteria(Bundle.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return bundles;
	}
	
	@Transactional
	public List<ActiveBundles> activeList() {
		//ActiveBundles activeBundleList = new ActiveBundles();
		@SuppressWarnings("unchecked")
		
		List<ActiveBundles> bundles = (List<ActiveBundles>) sessionFactory.getCurrentSession()
				.createQuery("SELECT B.id from Bundle B where B.isActive=1").list();

		return bundles;
	}

}
