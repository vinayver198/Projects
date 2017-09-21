package com.cg.dth.dao;

public interface IQueryMapper {

	String VIEW = "SELECT subscriber_id,mobile_number,package_id,account_balance FROM subscriber_account_details WHERE mobile_number=?";
	String UPDATE ="UPDATE subscriber_account_details SET account_balance=account_balance-? WHERE mobile_number=?";
	String Amount="SELECT package_amount FROM datasky_packages WHERE package_id=?";
	String Date="UPDATE subscriber_account_details SET rechargedate=rechargedate+30 WHERE mobile_number=?";
}
