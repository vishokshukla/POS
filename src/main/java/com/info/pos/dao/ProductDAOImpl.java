package com.info.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.info.pos.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> getProducts() {
		Session currSession = sessionFactory.getCurrentSession();
		
		Query<Product> query = currSession.createQuery("from product order by productName", Product.class);
		List<Product> products = query.getResultList();
		
		return products;
	}

	@Override
	public void saveProduct(Product product) {
		
		Session currSession = sessionFactory.getCurrentSession();
		currSession.saveOrUpdate(product);
		
	}

	@Override
	public Product getProduct(String productId) {

		Session currSession = sessionFactory.getCurrentSession();
		
		Product product = currSession.get(Product.class, productId);
		
		return product;
	}

	@Override
	public void deleteProduct(String productId) {

		Session currSession = sessionFactory.getCurrentSession();
		
		Query query = currSession.createQuery("delete from Product where id=:productId");
		query.setParameter("productId", productId);
		
		query.executeUpdate();
		
	}

}
