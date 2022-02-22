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

import com.info.pos.entity.Cart;
import com.info.pos.service.POSService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private POSService posService;
	
	@GetMapping("/cart")
	public List<Cart> getCart() {
		return posService.getCarts();
	}
	
	@GetMapping("/cart/{cartId}")
	public Cart getCart(@PathVariable String cartId) {
		
		Cart cart = posService.getCart(cartId);
		if(cart == null)
			throw new RuntimeException("cart not found");
		return cart;
	}
	
	@PostMapping("/cart") 
	public Cart addCart(@RequestBody Cart cart) {
		cart.setCartProductId(null);
		posService.saveCart(cart);
		return cart;
	}
	
	@PutMapping("/cart")
	public Cart updateCart(@RequestBody Cart cart) {
		posService.saveCart(cart);
		return cart;
	}
	
	@DeleteMapping("/cart/{cartId}") 
	public String deleteCart(@PathVariable String cartId) {
		Cart cart = posService.getCart(cartId);
		if(cart == null)
			throw new RuntimeException("id not found");
		posService.deleteCart(cartId);
		
		return "Deleted cart with id : " + cartId;
	}
}
