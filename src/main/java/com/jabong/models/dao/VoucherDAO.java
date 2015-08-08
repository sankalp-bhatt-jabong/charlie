package com.jabong.models.dao;

import java.util.List;
import com.jabong.models.Voucher;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class VoucherDAO {
	private SessionFactory sessionFactory;

	public VoucherDAO(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public Voucher getDetailById(int id) {
		@SuppressWarnings("unchecked")
		Voucher vouchers = (Voucher) sessionFactory.getCurrentSession()
				.createQuery("from Voucher V where V.id=:id")
				.setParameter("id", id).uniqueResult();

		return vouchers;
	}

	@Transactional
	public List<Object> getActiveList() {
		@SuppressWarnings("unchecked")
		List<Object> vouchers = (List<Object>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"SELECT V.id, V.conditionsRuleset from Voucher V where V.showOnWebsite=1")
				.list();

		return vouchers;
	}

	@Transactional
	public String getSalesRuleData(int id) {
		@SuppressWarnings("unchecked")
		String voucherCode = (String) sessionFactory
				.getCurrentSession()
				.createQuery(
						"SELECT vsr.code from VoucherSalesRule vsr where vsr.fkSalesRuleSet =:id")
				.setParameter("id", id).uniqueResult();

		return voucherCode;
	}

}
