package com.cg.dth.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;



import java.time.format.DateTimeFormatter;

import com.cg.dth.dto.accountBean;
import com.cg.dth.exception.DTHException;
import com.cg.dth.util.DbConnection;


public class DTHImpl implements IDTH {
	PreparedStatement preparedStatement = null;
	Connection conn = null;
	ResultSet resultSet = null;
	@Override
	public accountBean getOnMobile(long mobileNo) throws DTHException {
	
		accountBean dto = new accountBean();
		try {
			conn = DbConnection.getConnection();
			//System.out.println("A");For Checking connection printing on console.
			preparedStatement = conn.prepareStatement(IQueryMapper.VIEW);
			//System.out.println("B");
			preparedStatement.setLong(1, mobileNo);
			//System.out.println("C");
			resultSet = preparedStatement.executeQuery();
			//System.out.println("D");
			while (resultSet.next()) {
				dto.setSubscriberId(resultSet.getInt(1));
				dto.setMobileNo(resultSet.getLong(2));
				dto.setPackageId(resultSet.getString(3));
				dto.setAccountBalance(resultSet.getFloat(4));
				
				
			}

		} catch (SQLException e) {
			throw new DTHException("dao/sql/ERROR:"
					+ e.getMessage());
		} catch (Exception e) {
			throw new DTHException("ERROR:" + e.getMessage());
		} finally {
			try {
				if (conn != null) {
					preparedStatement.close();
					conn.close();
					resultSet.close();
				}
			} catch (Exception e) {
				throw new DTHException(
						"Could not close the connection");
			}
		}
		return dto;
	}
	

	@Override
	public boolean updateBalance(accountBean account) throws DTHException {
		
		
		
		ResultSet rs=null;
		int recsAffected=0;
		float amount= getAmount(account.getPackageId());
		try
		
		{   
			conn = DbConnection.getConnection();
			
			preparedStatement = conn.prepareStatement(IQueryMapper.UPDATE);
		
		  
			preparedStatement.setFloat(1, amount);
			preparedStatement.setLong(2,account.getMobileNo());
          recsAffected= preparedStatement.executeUpdate(); 
		
		}
		catch(SQLException e)
		{
			throw new DTHException("Problem in updating Data",e);
		}	
		if(recsAffected==1)
			return true;
		else
			
		return false;
	}


	@Override
	public float getAmount(String packageid) throws DTHException {
		// TODO Auto-generated method stub
		float amount=0;
		int recsAffected=0;
		try
		
		{   
			conn = DbConnection.getConnection();
			
			preparedStatement = conn.prepareStatement(IQueryMapper.Amount);
		
		 
			preparedStatement.setString(1,packageid);
			
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{  
				amount = resultSet.getFloat(1);
			} 
		
          
		}
		catch(SQLException e)
		{
			throw new DTHException("Problem in updating Data",e);
		}	
		
			return amount;
		
	}
	
	public boolean updateDate(accountBean account) throws DTHException
	{
		int recs=0;
try
		
		{   
			conn = DbConnection.getConnection();
			
			preparedStatement = conn.prepareStatement(IQueryMapper.Date);
		
		 
			preparedStatement.setLong(1,account.getMobileNo());
			
			recs = preparedStatement.executeUpdate();
			
		
          
		}
		catch(SQLException e)
		{
			throw new DTHException("Problem in updating Data",e);
		}	
		
			if(recs==1)
				return true;
			else
				return false;
			
		
		
		
	}

	
}
