package com.info.pos.dao;

import java.util.List;

import com.info.pos.entity.Cart;

public interface CartDAO {

	public List<Cart> getCart();
	
	public void saveCart(Cart cart);
	
	public Cart getCart(String cartId);
	
	public void deleteCart(String cartId);
}
