package com.cg.lab5.services;

import com.cg.lab5.bean.BillDetail;
import com.cg.lab5.bean.Consumer;
import com.cg.lab5.dao.EBillDao;
import com.cg.lab5.dao.EBillDaoImpl;
import com.cg.lab5.exception.ConsumerException;

public class EBillServiceImpl implements EBillService {
	
	private EBillDao dao;
	public EBillServiceImpl() {
		dao = new EBillDaoImpl();
	}
	@Override
	public Consumer addConsumer(BillDetail bill) throws ConsumerException {
		
		return dao.addConsumer(bill);
	}

}
