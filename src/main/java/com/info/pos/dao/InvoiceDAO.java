package com.info.pos.dao;

import java.util.List;

import com.info.pos.entity.Invoice;

public interface InvoiceDAO {

	public List<Invoice> getInvoice();
	
	public void saveInvoice(Invoice invoice);
	
	public Invoice getInvoice(String invoiceId);
	
	public void deleteInvoice(String invoiceId);
}
