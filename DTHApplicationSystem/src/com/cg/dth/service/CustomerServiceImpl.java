package com.cg.dth.service;

import com.cg.dth.dao.DTHImpl;
import com.cg.dth.dao.IDTH;
import com.cg.dth.dto.accountBean;
import com.cg.dth.exception.DTHException;

public class CustomerServiceImpl implements ICustomerService {
IDTH service=new DTHImpl();
	@Override
	public accountBean getOnMobile(long mobileNo) throws DTHException {
		// TODO Auto-generated method stub
		return service.getOnMobile(mobileNo);
	}

	@Override
	public boolean updateBalance(accountBean account, float amount)
			throws DTHException {
		// TODO Auto-generated method stub
		return service.updateBalance(account);
	}

	@Override
	public float getAmount(String packageid) throws DTHException {
		// TODO Auto-generated method stub
		return service.getAmount(packageid);
	}

	@Override
	public boolean updateDate(accountBean account) throws DTHException {
		// TODO Auto-generated method stub
		return service.updateDate(account);
	}

	
}
