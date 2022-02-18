package com.info.pos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sales")
public class Sales {
	
	@Id
	@Column(name = "invoice_id")
	private String invoiceId;
	
	@Column(name = "customer_id")
	private String invoiceCustomerId;
	
	@Column(name = "customer_name")
	private String invoiceCustomerName;
	
	@Column(name = "total_quantity")
	private int invoiceTotalQuantity;
	
	@Column(name = "total_bill")
	private double invoiceTotalAmount;
	
	@Column(name = "invoice_status")
    private String invoiceStatus;
	
	public Sales() {
		
	}

	public Sales(String invoiceId, String invoiceCustomerId, String invoiceCustomerName, int invoiceTotalQuantity,
			double invoiceTotalAmount, String invoiceStatus) {
		this.invoiceId = invoiceId;
		this.invoiceCustomerId = invoiceCustomerId;
		this.invoiceCustomerName = invoiceCustomerName;
		this.invoiceTotalQuantity = invoiceTotalQuantity;
		this.invoiceTotalAmount = invoiceTotalAmount;
		this.invoiceStatus = invoiceStatus;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceCustomerId() {
		return invoiceCustomerId;
	}

	public void setInvoiceCustomerId(String invoiceCustomerId) {
		this.invoiceCustomerId = invoiceCustomerId;
	}

	public String getInvoiceCustomerName() {
		return invoiceCustomerName;
	}

	public void setInvoiceCustomerName(String invoiceCustomerName) {
		this.invoiceCustomerName = invoiceCustomerName;
	}

	public int getInvoiceTotalQuantity() {
		return invoiceTotalQuantity;
	}

	public void setInvoiceTotalQuantity(int invoiceTotalQuantity) {
		this.invoiceTotalQuantity = invoiceTotalQuantity;
	}

	public double getInvoiceTotalAmount() {
		return invoiceTotalAmount;
	}

	public void setInvoiceTotalAmount(double invoiceTotalAmount) {
		this.invoiceTotalAmount = invoiceTotalAmount;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}
	
}
