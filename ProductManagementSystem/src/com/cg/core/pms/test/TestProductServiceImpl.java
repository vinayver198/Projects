package com.cg.core.pms.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.core.pms.dto.Product;
import com.cg.core.pms.exception.ProductException;
import com.cg.core.pms.service.IProductService;
import com.cg.core.pms.service.ProductServiceImpl;

public class TestProductServiceImpl {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test1() {
		
		IProductService productService = new ProductServiceImpl();
		
		Product p1 =  new Product("SonyPhone",12000,"Electronics",12);
		
		 try {
			assertEquals(1010, productService.addProduct(p1));
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void test2() {
		
		IProductService productService = new ProductServiceImpl();
		
		
		
		 try {
			assertNotNull(productService.getproduct(1010));
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test3() {
		
		IProductService productService = new ProductServiceImpl();
		
		
		
		 try {
			assertNotNull(productService.getproduct(1010));
			//productService.getAllProducts();
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
