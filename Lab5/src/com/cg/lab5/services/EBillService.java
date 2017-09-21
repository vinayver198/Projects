package com.cg.lab5.services;

import com.cg.lab5.bean.BillDetail;
import com.cg.lab5.bean.Consumer;
import com.cg.lab5.exception.ConsumerException;

public interface EBillService 
{
	Consumer addConsumer(BillDetail bill) throws ConsumerException;
}
