package com.cg.brs.dao;

import com.cg.brs.bean.UserBean;
import com.cg.brs.exception.RegisterException;

public interface IRegisterDAO {

		public int RegisterDetailDao(UserBean bean)	throws RegisterException;
		public Boolean ActivateDeatailDao(String Email) throws RegisterException;
		
}
