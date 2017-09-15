package com.cg.core.pms.service;

import java.util.ArrayList;

import com.cg.core.pms.dto.Product;
import com.cg.core.pms.exception.ProductException;

public interface IProductService
{
public int addProduct(Product product) throws ProductException;
	
	public Product getproduct(int id) throws ProductException;
	
	public void updateProduct(Product product) throws ProductException;
	public Product removeProduct(int id) throws ProductException;
	
	public ArrayList<Product> getAllProducts() throws ProductException;


}
