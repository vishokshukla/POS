package com.info.pos.service;

import java.util.List;

import com.info.pos.entity.Cart;
import com.info.pos.entity.Invoice;
import com.info.pos.entity.Product;
import com.info.pos.entity.Sales;
import com.info.pos.entity.User;

public interface POSService {
	
	public List<Cart> getCarts();
	public Cart getCart(String cartId);
	public void saveCart(Cart cart);
	public void deleteCart(String cartId);
	
	public List<Invoice> getInvoices();
	public Invoice getInvoice(String invoiceId);
	public void saveInvoice(Invoice invoice);
	public void deleteInvoice(String invoiceId);
	
	public List<Product> getProducts();
	public Product getProducts(String productId);
	public void saveProduct(Product product);
	public void deleteProduct(String productId);
	
	public List<Sales> getSales();
	public Sales getSales(String salesId);
	public void saveSales(Sales sales);
	public void deleteSales(String salesId);
	
	public List<User> getUsers();
	public User getUser(String userId);
	public void saveUser(User user);
	public void deleteUser(String userId);
}
