package com.jabong.models.dao;

import java.util.List;
import com.jabong.models.Bundle;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

public class BundleDAO extends BaseDAO{
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
		criteria.setFetchMode("bundleSets", FetchMode.JOIN);
		criteria.setFetchMode("bundleSets.bundleSetOptions", FetchMode.JOIN);
		Object result = criteria.uniqueResult();
		return result;
	}

	@Transactional
	public List<?> getReverseSkuBundleMap() {
		Session session = sessionFactory.getCurrentSession();
		List<?> res = session.getNamedQuery("sku2BundleMapping")
				.list();
		return res;
	}

	
}
