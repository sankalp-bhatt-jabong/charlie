package com.jabong.models.dao;

import java.util.List;

import com.jabong.models.Bundle;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

public class BundleDAO extends BaseDAO {
	
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
		criteria.add(Restrictions.lt("fromDate", BundleDAO.getCurrentDate()));
		@SuppressWarnings("unchecked")
		List<Bundle> results = criteria.list();
		return results;
	}

	@Transactional
	public Bundle getDetailById(int bundleId, Boolean displaySku) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Bundle.class);
		criteria.add(Restrictions.eq("id", bundleId));
		criteria.setFetchMode("bundleMessages", FetchMode.JOIN);
		criteria.setFetchMode("bundleSets", FetchMode.JOIN);
		if (displaySku) {
			criteria.setFetchMode("bundleSets.bundleSetOptions", FetchMode.JOIN);
		}
		Bundle result = (Bundle) criteria.uniqueResult();
		return result;
	}

	@Transactional
	public List<?> getReverseSkuBundleMap() {
		Session session = sessionFactory.getCurrentSession();
		List<?> res = session.getNamedQuery("sku2BundleMapping")
				.setString("to_date", BundleDAO.getCurrentDate())
				.setString("from_date", BundleDAO.getCurrentDate()).list();
		return res;
	}

	@Transactional
	public List<?> getBundlesOfSku(String sku) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.getNamedQuery("sku2BundleMappingBySku")
				.setString("sku", sku)
				.setString("to_date", BundleDAO.getCurrentDate())
				.setString("from_date", BundleDAO.getCurrentDate());
		List<?> res = query.list();
		return res;
	}
	
	@Transactional
    public List<?> getBundleToSkuList(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        List<?> res = session.getNamedQuery("bundle2SkuMappingById")
                .setInteger("id", id).list();
        return res;
    }

}
