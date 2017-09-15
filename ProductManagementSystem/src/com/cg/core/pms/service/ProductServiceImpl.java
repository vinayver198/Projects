package com.cg.core.pms.service;



import java.util.ArrayList;

import com.cg.core.pms.dao.IProductDAO;
import com.cg.core.pms.dao.ProductDAOImpl;
import com.cg.core.pms.dto.Product;
import com.cg.core.pms.exception.ProductException;

public class ProductServiceImpl implements IProductService{

	IProductDAO productDAO;
	
	 public ProductServiceImpl() {
		// TODO Auto-generated constructor stub
		 
		 productDAO = new ProductDAOImpl();
	}
	
	
	@Override
	public int addProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		return productDAO.addProduct(product);
		
	}

	@Override
	public Product getproduct(int id) throws ProductException {
		// TODO Auto-generated method stub
		
		return productDAO.getproduct(id);
	}

	@Override
	public void updateProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		productDAO.updateProduct(product);
	}

	@Override
	public Product removeProduct(int id) throws ProductException {
		// TODO Auto-generated method stub
		return productDAO.removeProduct(id);
	}

	@Override
	public ArrayList<Product> getAllProducts() throws ProductException {
		// TODO Auto-generated method stub
		return productDAO.getAllProducts();
	}

}
