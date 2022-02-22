package com.info.pos.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.info.pos.entity.User;

@Repository
public class UserDAOImple implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<User> getUsers() {

		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("from User order by userName", User.class);
		List<User> users = query.getResultList();
		
		return users;
	}

	@Override
	public void saveUser(User user) {

		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);

	}

	@Override
	public User getUser(String userId) {
		
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, userId);
		
		return user;
	}

	@Override
	public void deleteUser(String userId) {

		Session session = sessionFactory.getCurrentSession();
		
		Query<User> query = session.createQuery("delete from User where userId=:userId");
		query.setParameter("userId", userId);
		
		query.executeUpdate();
		
	}

}
