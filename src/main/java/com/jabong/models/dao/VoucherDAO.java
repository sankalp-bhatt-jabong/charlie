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
	public List<Voucher> list(int id) {
		@SuppressWarnings("unchecked")
		
		List<Voucher> vouchers = (List<Voucher>) sessionFactory.getCurrentSession()
				.createQuery("from Voucher V where V.id=:id").setParameter("id",id).list();

		return vouchers;
	}
	
	@Transactional
	public List<Voucher> activeList() {
		@SuppressWarnings("unchecked")
		
		List<Voucher> vouchers = (List<Voucher>) sessionFactory.getCurrentSession()
				.createCriteria(Voucher.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

		return vouchers;
	}

}
