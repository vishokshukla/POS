package com.info.pos.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice {
	
	@EmbeddedId
	private InvoiceProductId invoiceProductId;
	
	@SuppressWarnings("serial")
	@Embeddable
	public class InvoiceProductId implements Serializable {
		
		@Column(name = "invoice_id")
		private String invoiceId;
		
		@Column(name = "product_id")
		private String productId;
		
		public InvoiceProductId() {
			
		}

		public InvoiceProductId(String invoiceId, String productId) {
			this.invoiceId = invoiceId;
			this.productId = productId;
		}
		
	}
	
	@Column(name = "product_name")
	private String invoiceProductName;
	
	@Column(name = "product_quantity")
	private int invoiceProductQuantity;
	
	@Column(name = "unit_price")
	private double invoiceProductUnitPrice;
	
	@Column(name = "total_price")
	private double invoiceProductTotalPrice;
	
	public Invoice() {
		
	}

	public Invoice(InvoiceProductId invoiceProductId, String invoiceProductName, int invoiceProductQuantity,
			double invoiceProductUnitPrice, double invoiceProductTotalPrice) {
		this.invoiceProductId = invoiceProductId;
		this.invoiceProductName = invoiceProductName;
		this.invoiceProductQuantity = invoiceProductQuantity;
		this.invoiceProductUnitPrice = invoiceProductUnitPrice;
		this.invoiceProductTotalPrice = invoiceProductTotalPrice;
	}

	public InvoiceProductId getInvoiceProductId() {
		return invoiceProductId;
	}

	public void setInvoiceProductId(InvoiceProductId invoiceProductId) {
		this.invoiceProductId = invoiceProductId;
	}

	public String getInvoiceProductName() {
		return invoiceProductName;
	}

	public void setInvoiceProductName(String invoiceProductName) {
		this.invoiceProductName = invoiceProductName;
	}

	public int getInvoiceProductQuantity() {
		return invoiceProductQuantity;
	}

	public void setInvoiceProductQuantity(int invoiceProductQuantity) {
		this.invoiceProductQuantity = invoiceProductQuantity;
	}

	public double getInvoiceProductUnitPrice() {
		return invoiceProductUnitPrice;
	}

	public void setInvoiceProductUnitPrice(double invoiceProductUnitPrice) {
		this.invoiceProductUnitPrice = invoiceProductUnitPrice;
	}

	public double getInvoiceProductTotalPrice() {
		return invoiceProductTotalPrice;
	}

	public void setInvoiceProductTotalPrice(double invoiceProductTotalPrice) {
		this.invoiceProductTotalPrice = invoiceProductTotalPrice;
	}
	
}
