package com.info.pos.dao;

import java.util.List;

import com.info.pos.entity.User;

public interface UserDAO {
	
	public List<User> getUsers();
	
	public void saveUser(User user);
	
	public User getUser(String userId);
	
	public void deleteUser(String userId);

}
