package com.cg.dth.dao;

import com.cg.dth.dto.accountBean;
import com.cg.dth.exception.DTHException;

public interface IDTH {

	public accountBean getOnMobile(long mobileNo) throws DTHException;
	public boolean updateBalance(accountBean account) throws DTHException;
	public float getAmount(String packageid) throws DTHException;
	public boolean updateDate(accountBean account) throws DTHException;
}
