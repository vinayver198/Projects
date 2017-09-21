package com.cg.lab5.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;






import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import com.cg.lab5.bean.BillDetail;
import com.cg.lab5.bean.Consumer;
import com.cg.lab5.exception.ConsumerException;
import com.cg.lab5.util.DButil;

public class EBillDaoImpl implements EBillDao {

	@Override
	public Consumer addConsumer(BillDetail bill) throws ConsumerException {
		Consumer consumer= new Consumer();
		Statement stm;
		
		int billNum=0;
		ResultSet res;
		try(Connection con=DButil.getConnection())
		{
			System.out.println("In try DAO");
		int   consumerNo = bill.getConsumerNo();
		System.out.println(consumerNo);
		float curReading      =bill.getCurReading();
		System.out.println(curReading);
		float unitConsumed    =bill.getUnitConsumed();
		float netAmount =bill.getNetAmount();
		Date  billDate        =bill.getBillDate();
		System.out.println(billDate);
		
		 
		stm=con.createStatement();
		res=stm.executeQuery("select consumer_Num from Consumers");
		ArrayList idList=null;
		
		if(res.next()==false)
		{
			
			throw new ConsumerException("Something went wrong.");
		}
		 
		else
		{
			idList = new ArrayList();
			do
			{
				int temp = res.getInt(1);
				idList.add(temp);
			}
			while(res.next());
		}
		boolean flag = false;
		idList.get(0);
		for (int i=0;i<idList.size();i++)
		{
			if(idList.get(i).equals(consumerNo))
			{
				flag=true;
			}
		}
		
		System.out.println(flag);
		if(flag==false)
		{
			throw new ConsumerException("Consumer Number not found");
			
		}
		
		boolean abc=false;
		if(abc==false)
		{
			throw new ConsumerException(" Number not found");
			
		}
		
		PreparedStatement pstm1=con.prepareStatement("select consumer_name,address from Consumers where consumer_num = ?");
		pstm1.setInt(1, consumerNo);
		pstm1.executeQuery();
		res = pstm1.getResultSet();
		if(res.next()==false)
		{
			
			throw new ConsumerException("Something went wrong.");
		}
		String name= res.getString(1);
		//System.out.println(name);
		String address = res.getString(2);
		//System.out.println(address);
		consumer.setAddress(address);
		consumer.setConsumerName(name);
		consumer.setConsumerNo(consumerNo);
		
		
		
		stm=con.createStatement();
		res=stm.executeQuery("select seq_bill_num.nextVal from dual");
				
		if(res.next()==false)
		{
			
			throw new ConsumerException("Bill Number Generation failed.");
		}
		
		billNum=res.getInt(1);
		System.out.println(consumerNo);
		PreparedStatement pstm=con.prepareStatement("insert into  BillDetails values(?,?,?,?,?,?)");
		pstm.setInt(1,billNum);
		pstm.setInt(2,consumerNo);
		pstm.setFloat(3, curReading);
		pstm.setFloat(4, unitConsumed);
		pstm.setFloat(5, netAmount);
		pstm.setDate(6, (java.sql.Date) billDate);
		pstm.execute();
		
		}
		catch(Exception e)
		{	
			throw new ConsumerException(e.getMessage());
		}
		
		
		
		return consumer;

	}

	}


