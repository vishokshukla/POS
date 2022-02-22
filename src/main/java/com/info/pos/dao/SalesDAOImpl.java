package com.info.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.info.pos.entity.Sales;

@Repository
public class SalesDAOImpl implements SalesDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Sales> getSales() {

		Session session = sessionFactory.getCurrentSession();
		Query<Sales> query = session.createQuery("from Sales", Sales.class);
		
		List<Sales> sales = query.getResultList();
		
		return sales;
	}

	@Override
	public void saveSales(Sales sales) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(sales);

	}

	@Override
	public Sales getSales(String salesId) {

		Session session = sessionFactory.getCurrentSession();
		Sales sales = session.get(Sales.class, salesId);
		
		
		return sales;
	}

	@Override
	public void deleteSales(String salesId) {

		Session session = sessionFactory.getCurrentSession();
		Query<Sales> query = session.createQuery("delete from Sales where salesId=:salesId");
		
		query.setParameter("salesId", salesId);
		
		query.executeUpdate();

	}

}
