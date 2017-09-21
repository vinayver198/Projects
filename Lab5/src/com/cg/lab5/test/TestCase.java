package com.cg.lab5.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.lab5.bean.BillDetail;

public class TestCase {

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
	public void test() 
	{
		 
		BillDetail bill = new BillDetail();
		bill.setCurReading(125.0f);
		bill.setUnitConsumed(125.0f);
		bill.setNetAmount(125.0f);
		bill.setBillDate(Date.valueOf(LocalDate.now()));
		
		
	}

}
