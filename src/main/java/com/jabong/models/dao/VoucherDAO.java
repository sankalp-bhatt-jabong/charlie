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

}
