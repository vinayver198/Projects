package com.cg.dth.service;

import com.cg.dth.dto.accountBean;
import com.cg.dth.exception.DTHException;

public interface ICustomerService {
	
	public accountBean getOnMobile(long mobileNo) throws DTHException;
	public boolean updateBalance(accountBean account,float amount) throws DTHException;
	public float getAmount(String packageid) throws DTHException;
	public boolean updateDate(accountBean account) throws DTHException;
}
