package com.jabong.models.dao;

import java.util.List;

import com.jabong.models.Voucher;
import com.jabong.services.util.DateUtil;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class VoucherDAO extends BaseDAO {
	private SessionFactory sessionFactory;

	public VoucherDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Voucher getDetailById(int id) {
		Voucher vouchers = (Voucher) sessionFactory.getCurrentSession()
				.createQuery("from Voucher V where V.id=:id")
				.setParameter("id", id).uniqueResult();

		return vouchers;
	}

	@Transactional
	public List<Object> getActiveList() {
		@SuppressWarnings("unchecked")
		List<Object> vouchers = (List<Object>) sessionFactory.getCurrentSession()
				.createQuery("SELECT V.id, V.conditionsRuleset from Voucher V where"
						+ " V.showOnWebsite = 1 AND V.isActive = 1")
				.list();

		return vouchers;
	}

	@Transactional
	public Object getSalesRuleData(int id) {
		Object voucherCode = (Object) sessionFactory.getCurrentSession()
				.createQuery("SELECT vsr.code, vsr.fromDate, vsr.toDate from VoucherSalesRule vsr "
						+ "where vsr.fkSalesRuleSet =:id and vsr.fromDate <= :currentDate "
						+ "and  vsr.toDate >= :currentDate")
				.setParameter("id", id)
				.setParameter("currentDate", DateUtil.getCurrentDate()).uniqueResult();


		return voucherCode;
	}

	@Transactional
	public String mapToTagValue(int id) {
		@SuppressWarnings("unchecked")
		String promoName = (String) sessionFactory
				.getCurrentSession()
				.createQuery("SELECT po.name from PromotionOptions po where po.id =:id")
				.setParameter("id", id).uniqueResult();

		return promoName;
	}

}
