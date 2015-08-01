package com.jabong.models.dao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.jabong.models.Bundle;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

public class BundleDAO {
	private SessionFactory sessionFactory;

	public BundleDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<Bundle> list() {
		@SuppressWarnings("unchecked")
		List<Bundle> bundles = (List<Bundle>) sessionFactory
				.getCurrentSession().createCriteria(Bundle.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return bundles;
	}

	@Transactional
	public List<Bundle> fetchActiveList() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Bundle.class);
		criteria.add(Restrictions.eq("isActive", 1));
		criteria.add(Restrictions.gt("toDate", BundleDAO.getCurrentDate()));
		@SuppressWarnings("unchecked")
		List<Bundle> results = criteria.list();
		return results;
	}
	
	@Transactional
	public Object getDetailById(int bundleId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Bundle.class);
		criteria.add(Restrictions.eq("id", bundleId));
		Object result = criteria.list();
		return result;
	}
	
	

	public static String getCurrentDate() {
		return BundleDAO.getCurrentDate("yyyy-MM-dd HH:mm:ss");
	}

	public static String getCurrentDate(String format) {
		Calendar c = Calendar.getInstance();
		String sd = new SimpleDateFormat(format).format(c.getTime());
		return sd;
	}

}
