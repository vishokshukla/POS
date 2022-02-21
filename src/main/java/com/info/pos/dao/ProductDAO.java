package com.info.pos.dao;

import java.util.List;

import com.info.pos.entity.Product;

public interface ProductDAO {

	public List<Product> getProducts();
	
	public void saveProduct(Product product);
	
	public Product getProduct(String productId);
	
	public void deleteProduct(String productId);

}
