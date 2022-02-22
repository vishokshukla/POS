package com.info.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.info.pos.entity.Invoice;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Invoice> getInvoice() {

		Session session = sessionFactory.getCurrentSession();
		Query<Invoice> query = session.createQuery("from Invoice", Invoice.class);
		
		List<Invoice> invoices = query.getResultList();
		
		return invoices;
	}

	@Override
	public void saveInvoice(Invoice invoice) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(invoice);

	}

	@Override
	public Invoice getInvoice(String invoiceId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Invoice invoice = session.get(Invoice.class, invoiceId);
		
		return invoice;
	}

	@Override
	public void deleteInvoice(String invoiceId) {

		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Invoice where invoiceId=:invoiceId", Invoice.class);
		query.setParameter("invoiceId", invoiceId);
		query.executeUpdate();
		
	}

}
