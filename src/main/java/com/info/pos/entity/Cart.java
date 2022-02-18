package com.info.pos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	
	@EmbeddedId
	private CartProductId cartProductId;
	
	@SuppressWarnings("serial")
	@Embeddable
	public class CartProductId implements Serializable {
		@Column(name = "cart_id")
		private String cartId;
		
		@Column(name = "product_id")
		private String productId;

	    public CartProductId() {}

		public CartProductId(String cartId, String productId) {
			this.cartId = cartId;
			this.productId = productId;
		}

	}
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_barcode")
	private int productBarcode;
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "unit_price")
	private double productUnitPrice;
	
	@Column(name = "total_price")
	private double productTotalPrice;

	public Cart() {

	}

	public Cart(CartProductId cartProductId, String productName, int productBarcode, int productQuantity,
			double productUnitPrice, double productTotalPrice) {
		this.cartProductId = cartProductId;
		this.productName = productName;
		this.productBarcode = productBarcode;
		this.productQuantity = productQuantity;
		this.productUnitPrice = productUnitPrice;
		this.productTotalPrice = productTotalPrice;
	}

	public CartProductId getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(CartProductId cartProductId) {
		this.cartProductId = cartProductId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductBarcode() {
		return productBarcode;
	}

	public void setProductBarcode(int productBarcode) {
		this.productBarcode = productBarcode;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public double getProductUnitPrice() {
		return productUnitPrice;
	}

	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}

	public double getProductTotalPrice() {
		return productTotalPrice;
	}

	public void setProductTotalPrice(double productTotalPrice) {
		this.productTotalPrice = productTotalPrice;
	}
	
}
