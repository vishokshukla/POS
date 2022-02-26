package com.info.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.pos.entity.Product;
import com.info.pos.service.POSService;

@RestController
@RequestMapping("/product")
public class ProductController {

	static int p = 101;
	
	@Autowired
	private POSService posService;
	
	@GetMapping("/product")
	public List<Product> getProduct() {
		return posService.getProducts();
	}
	
	@GetMapping("/product/{productId}")
	public Product getProduct(@PathVariable String productId) {
		Product product = posService.getProducts(productId);
		if(product == null)
			throw new RuntimeException("Product not found");
		return product;
	}
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		product.setProductId("pid"+p++);
		posService.saveProduct(product);
		return product;
	}
	
	@PutMapping("/product")
	public Product updateProduct(@RequestBody Product product) {
		posService.saveProduct(product);
		return product;
	}
	
	@DeleteMapping("/product/{productId}")
	public String deleteProduct(@PathVariable String productId) {
		Product product = posService.getProducts(productId);
		if(product == null)
			throw new RuntimeException("Product not found");
		posService.deleteProduct(productId);
		return "Product deleted";
	}
	
}
