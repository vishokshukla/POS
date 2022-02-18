package com.info.pos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@Column(name = "product_id")
	private String productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_barcode")
	private int productBarcode;
	
	@Column(name = "product_price")
	private double productPrice;
	
	@Column(name = "product_quantity")
	private int productQuantity;
	
	@Column(name = "supplier_id")
	private String productSupplierId;
	
	public Product() {

	}

	public Product(String productId, String productName, int productBarcode, double productPrice, int productQuantity,
			String productSupplierId) {
		this.productId = productId;
		this.productName = productName;
		this.productBarcode = productBarcode;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productSupplierId = productSupplierId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
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

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProductSupplierId() {
		return productSupplierId;
	}

	public void setProductSupplierId(String productSupplierId) {
		this.productSupplierId = productSupplierId;
	}
	
}
