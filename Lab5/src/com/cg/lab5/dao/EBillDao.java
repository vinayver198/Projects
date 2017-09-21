package com.cg.lab5.dao;

import com.cg.lab5.bean.BillDetail;
import com.cg.lab5.bean.Consumer;
import com.cg.lab5.exception.ConsumerException;

public interface EBillDao 
{
	Consumer addConsumer(BillDetail bill) throws ConsumerException;
}
