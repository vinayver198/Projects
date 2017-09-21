package com.cg.brs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;





import com.cg.brs.bean.UserBean;
import com.cg.brs.exception.RegisterException;
import com.cg.brs.util.DBUtil;

public class RegisterDetailDAO implements IRegisterDAO {

	public RegisterDetailDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int RegisterDetailDao(UserBean bean) throws RegisterException {
		// TODO Auto-generated method stub
		int firmId=0;
		
		try(Connection con= DBUtil.getConnection())
		{
			String name= bean.getOwnerName();
			String bname= bean.getbName();
			String email= bean.geteMailId();
			Long phNo= bean.getMobileNo();
			String isActive= "N";
			
			Statement stm= con.createStatement();
			
			ResultSet res= stm.executeQuery("select seq_firm_master.nextVal from dual");
			/*
			int i = 10;
			Integer i1 = new Integer(1); 
			
			i1.toString();
			*/
			if(res.next()== false)
			{	
				
				throw new RegisterException("Sorry Could not Complete your Request.");
			}
			
			firmId= res.getInt(1);
			
			PreparedStatement pstm= con.prepareStatement("INSERT INTO firms_master VALUES(?,?,?,?,?,?)");
			pstm.setInt(1,firmId);
			pstm.setString(2, name);
			pstm.setString(3,bname);
			pstm.setString(4, email);
			
			String s= phNo.toString();
			pstm.setString(5,s);
			pstm.setString(6,isActive);
			
		
		
			int row = pstm.executeUpdate();
			if(row > 0)
			{
				System.out.println("Your request has been successfully registered along with id: "+firmId);
				
			}
			else
			{
				throw new RegisterException("System Error. Try Again Later.");
			}
			
			
			
		} catch (Exception e) {
		
			throw new RegisterException(e.getMessage());
		} 
		
		return firmId;
	}

	@Override
	public Boolean ActivateDeatailDao(String Email) throws RegisterException {
		// TODO Auto-generated method stub
		
		try(Connection con= DBUtil.getConnection())
		{
			PreparedStatement pstm= con.prepareStatement("Update firms_master set isactive=? where email=?");
			pstm.setString(1, "Y");
			pstm.setString(2, Email);
			pstm.execute();
			return true;
		}
		catch(Exception e)
		{
			throw new RegisterException("Could Not process your request");
		}
		
		
		
	}

}
