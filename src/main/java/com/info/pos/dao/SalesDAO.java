package com.info.pos.dao;

import java.util.List;

import com.info.pos.entity.Sales;

public interface SalesDAO {

	public List<Sales> getSales();
	
	public void saveSales(Sales sales);
	
	public Sales getSales(String salesId);
	
	public void deleteSales(String salesId);
}
