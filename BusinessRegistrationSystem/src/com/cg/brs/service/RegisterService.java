package com.cg.brs.service;

import com.cg.brs.bean.UserBean;
import com.cg.brs.dao.IRegisterDAO;
import com.cg.brs.dao.RegisterDetailDAO;
import com.cg.brs.exception.RegisterException;

public class RegisterService implements IRegisterService {
	
	IRegisterDAO dao;

	public RegisterService() {
		dao= new RegisterDetailDAO();
	}

	@Override
	public int RegisterDetailDao(UserBean bean) throws RegisterException {
		
		return dao.RegisterDetailDao(bean);
	}

	@Override
	public Boolean ActivateDeatailDao(String Email) throws RegisterException {
		// TODO Auto-generated method stub
		return dao.ActivateDeatailDao(Email);
	}

}
