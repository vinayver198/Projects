package com.cg.brs.service;

import com.cg.brs.bean.UserBean;
import com.cg.brs.exception.RegisterException;

public interface IRegisterService {
	
	public int RegisterDetailDao(UserBean bean)	throws RegisterException;
	public Boolean ActivateDeatailDao(String Email) throws RegisterException;
}
