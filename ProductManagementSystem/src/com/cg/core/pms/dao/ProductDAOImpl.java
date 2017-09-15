package com.cg.core.pms.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cg.core.pms.dto.Product;
import com.cg.core.pms.exception.ProductException;
import com.cg.core.pms.service.IProductService;
import com.cg.core.pms.util.DButil;

public class ProductDAOImpl implements IProductDAO {

	
	static Logger myLogger = Logger.getLogger(ProductDAOImpl.class.getName());
	/*
	 * Method Name : addProduct
	 * Author: Vinay
	 * Date : 29th Aug 2017
	 * description : AddProduct accepts Product Object and inserts product Details
	 * into database. product Id is generated
	 * sequence. AddProduct also throws ProductException
	 */
	
	
	@Override
	public int addProduct(Product product) throws ProductException {
		myLogger.info("Inside AddProduct Method");
		
		int productId = 0;
		try(Connection con = DButil.getConnection()){
		//get product details
			String name     = product.getName();
			String category = product.getCategory();
			int quantity    = product.getQuantity();
			float price     = product.getPrice();
			
		//get sequence number assign to ProductId
			Statement stm = con.createStatement();
			
		ResultSet res=	stm.executeQuery("select Pro_id_seq.nextVal from dual");
			
		
		myLogger.info("Trying to generate id by seq");
			if(res.next() == false)
			{
				myLogger.fatal("Exception while generating sequence value");
				throw new ProductException("Could not add Product. Product id generation failed");
			}
			productId = res.getInt(1);
			
			
		//insert into database product details
			
			PreparedStatement pstm = 
					con.prepareStatement("insert into Product values(?,?,?,?,?)");
			pstm.setInt(1, productId);
			pstm.setString(2, name);
			pstm.setFloat(3,price);
			pstm.setString(4, category);
			pstm.setInt(5, quantity);
			myLogger.info("Trying to add product details to database");
			pstm.execute();
			
			myLogger.info("Adding product details to database successfull");
		}
		catch(Exception e)
		{
			myLogger.fatal("Exception while trying to add product to database");
			throw new ProductException(e.getMessage());
		}
		
		return productId;
	}

	@Override
	public Product getproduct(int id) throws ProductException {
		
		Product product = null;
		try (Connection con = DButil.getConnection())
		{
			PreparedStatement pstm = con.prepareStatement("select * from product where id = ?");
			pstm.setInt(1,id);
			
			ResultSet res = pstm.executeQuery();
			
			if(res.next() == false)
				throw new ProductException("No product with id"+id);
			else
			{
				product = new Product();
				product.setId(res.getInt("id"));
				product.setName(res.getString("name"));
				product.setPrice(res.getFloat("price"));
				product.setQuantity(res.getInt("quantity"));
				product.setCategory(res.getString("category"));				
			}
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new ProductException(e.getMessage());
		}
		return product;
	}

	@Override
	public void updateProduct(Product product) throws ProductException
	{
		
		try (Connection con = DButil.getConnection())
		{
			int id          = product.getId();
			String name     = product.getName();
			String category = product.getCategory();
			int quantity    = product.getQuantity();
			float price     = product.getPrice();
			PreparedStatement pstm = con.prepareStatement("update product set name=?,price=?,category=?,"
					+ "quantity=? where id =? ");
			pstm.setInt(5, id);
			pstm.setString(1,name);
			pstm.setFloat(2, price);
			pstm.setString(3, category);
			pstm.setInt(4, quantity);
			
			pstm.execute();
			
		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		}
		
	}

	@Override
	public Product removeProduct(int id) throws ProductException {
		
		Product product = null;
		try(Connection con = DButil.getConnection()){
			PreparedStatement pstm = con.prepareStatement("select * from product where id = ?");
					
			pstm.setInt(1, id);
			ResultSet res = pstm.executeQuery();
			if(res.next()==false)
				throw new ProductException("No Product with this id");
			else
			{
			 product = new Product();
			product.setId(res.getInt("id"));
			product.setName(res.getString("name"));
			product.setPrice(res.getFloat("price"));
			product.setQuantity(res.getInt("quantity"));
			product.setCategory(res.getString("category"));	
			PreparedStatement pstm2 = con.prepareStatement("delete from product where id =?");
			pstm2.setInt(1, id);
			pstm2.execute();
			
			
		}
		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		}
		
		return product;
	}

	@Override
	public ArrayList<Product> getAllProducts() throws ProductException {
		ArrayList<Product> products =null;
		boolean flag = false;
		try(Connection con = DButil.getConnection())
		{
			Statement stm=con.createStatement();
			ResultSet res = stm.executeQuery("select * from product");
			while(res.next())
			{
				if(flag==false)
				{
					products = new ArrayList<Product>();
				}
				Product product = new Product();
				product.setId(res.getInt("id"));
				product.setName(res.getString("name"));
				product.setPrice(res.getFloat("price"));
				product.setQuantity(res.getInt("quantity"));
				product.setCategory(res.getString("category"));	
				products.add(product);
				
				flag = true;
			}
			if(flag == false) throw new ProductException("no data found");
		} catch (Exception e) {
			throw new ProductException(e.getMessage());
		}
		
		
		return products;
	}

}
