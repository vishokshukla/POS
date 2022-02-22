package com.info.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.info.pos.entity.Cart;

@Repository
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Cart> getCart() {

		Session session  = sessionFactory.getCurrentSession();
		
		Query<Cart> query = session.createQuery("from Cart", Cart.class);
		List<Cart> carts = query.getResultList();
		
		return carts;
	}

	@Override
	public void saveCart(Cart cart) {

		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(cart);

	}

	@Override
	public Cart getCart(String cartId) {

		Session session = sessionFactory.getCurrentSession();
		
		Cart cart = session.get(Cart.class, cartId);
		
		return cart;
	}

	@Override
	public void deleteCart(String cartId) {

		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Cart where cartId=:cartId",Cart.class);
		query.setParameter("cartId", cartId);
		query.executeUpdate();

	}

}
