package com.info.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.pos.dao.CartDAO;
import com.info.pos.dao.InvoiceDAO;
import com.info.pos.dao.ProductDAO;
import com.info.pos.dao.SalesDAO;
import com.info.pos.dao.UserDAO;
import com.info.pos.entity.Cart;
import com.info.pos.entity.Invoice;
import com.info.pos.entity.Product;
import com.info.pos.entity.Sales;
import com.info.pos.entity.User;

@Service
public class POSServiceImpl implements POSService {

	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private InvoiceDAO invoiceDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private SalesDAO salesDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	
	@Override
	@Transactional
	public List<Cart> getCarts() {
		
		return cartDAO.getCart();
		
	}

	@Override
	@Transactional
	public Cart getCart(String cartId) {
		
		return cartDAO.getCart(cartId);
		
	}

	@Override
	@Transactional
	public void saveCart(Cart cart) {

		cartDAO.saveCart(cart);

	}

	@Override
	@Transactional
	public void deleteCart(String cartId) {

		cartDAO.deleteCart(cartId);

	}

	@Override
	@Transactional
	public List<Invoice> getInvoices() {

		return invoiceDAO.getInvoice();
		
	}

	@Override
	@Transactional
	public Invoice getInvoice(String invoiceId) {

		return invoiceDAO.getInvoice(invoiceId);
	}

	@Override
	@Transactional
	public void saveInvoice(Invoice invoice) {

		invoiceDAO.saveInvoice(invoice);
	}

	@Override
	@Transactional
	public void deleteInvoice(String invoiceId) {

		invoiceDAO.deleteInvoice(invoiceId);

	}

	@Override
	@Transactional
	public List<Product> getProducts() {

		return productDAO.getProducts();
	}

	@Override
	@Transactional
	public Product getProducts(String productId) {
		
		return productDAO.getProduct(productId);
	}

	@Override
	@Transactional
	public void saveProduct(Product product) {

		productDAO.saveProduct(product);

	}

	@Override
	@Transactional
	public void deleteProduct(String productId) {

		productDAO.deleteProduct(productId);

	}

	@Override
	@Transactional
	public List<Sales> getSales() {

		return salesDAO.getSales();
	}

	@Override
	@Transactional
	public Sales getSales(String salesId) {

		return salesDAO.getSales(salesId);
	}

	@Override
	@Transactional
	public void saveSales(Sales sales) {

		salesDAO.saveSales(sales);

	}

	@Override
	@Transactional
	public void deleteSales(String salesId) {

		salesDAO.deleteSales(salesId);

	}

	@Override
	@Transactional
	public List<User> getUsers() {

		return userDAO.getUsers();
	}

	@Override
	@Transactional
	public User getUser(String userId) {

		return userDAO.getUser(userId);
	}

	@Override
	@Transactional
	public void saveUser(User user) {

		userDAO.saveUser(user);

	}

	@Override
	@Transactional
	public void deleteUser(String userId) {

		userDAO.deleteUser(userId);

	}

}
