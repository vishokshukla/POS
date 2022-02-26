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

import com.info.pos.entity.Sales;
import com.info.pos.service.POSService;

@RestController
@RequestMapping("/sales")
public class SalesController {

	static int i = 101;
	
	@Autowired
	private POSService posService;
	
	@GetMapping("/sales")
	public List<Sales> getSales() {
		return posService.getSales();
	}
	
	@GetMapping("/sales/{invoiceId}")
	public Sales getSales(@PathVariable String invoiceId) {
		Sales sales = posService.getSales(invoiceId);
		if(sales == null)
			throw new RuntimeException("Sales not found");
		return sales;
	}
	
	@PostMapping("/sales")
	public Sales addSales(@RequestBody Sales sales) {
		sales.setInvoiceId("sid"+i++);
		posService.saveSales(sales);
		return sales;
	}
	
	@PutMapping("/sales")
	public Sales updateSales(@RequestBody Sales sales) {
		posService.saveSales(sales);
		return sales;
	}
	
	@DeleteMapping("/sales/{invoiceId}")
	public String deleteSales(@PathVariable String invoiceId) {
		Sales sales = posService.getSales(invoiceId);
		if(sales == null)
			throw new RuntimeException("sales not found");
		posService.deleteSales(invoiceId);
		return "sales deleted";
	}
	
}
