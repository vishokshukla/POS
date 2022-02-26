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

import com.info.pos.entity.Invoice;
import com.info.pos.service.POSService;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
	
	static int i = 101;
	static int p = 101;
	
	@Autowired
	private POSService posService;
	
	@GetMapping("/invoice")
	public List<Invoice> getInvoice() {
		return posService.getInvoices();
	}
	
	@GetMapping("/invoice/{invoiceId}")
	public Invoice getInvoice(@PathVariable String invoiceId) {
		Invoice invoice = posService.getInvoice(invoiceId);
		if(invoice == null)
			throw new RuntimeException("Invoice Not found");
		return invoice;
	}

	@PostMapping("invoice")
	public Invoice addInvoice(@RequestBody Invoice invoice) {
		invoice.setInvoiceProductId(invoice.new InvoiceProductId("iid"+i++, "pid"+p++));
		posService.saveInvoice(invoice);
		return invoice;
	}
	
	@PutMapping("/user")
	public Invoice updateInvoice(@RequestBody Invoice invoice) {
		posService.saveInvoice(invoice);
		return invoice;
	}
	
	@DeleteMapping("/invoice/{invoiceId}")
	public String deleteInvoice(@PathVariable String invoiceId) {
		Invoice invoice = posService.getInvoice(invoiceId);
		if(invoice == null)
			throw new RuntimeException("invoice not found");
		posService.deleteInvoice(invoiceId);
		return "invoice deleted";
	}
	
}
