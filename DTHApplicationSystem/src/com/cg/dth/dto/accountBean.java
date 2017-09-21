package com.cg.dth.dto;

import java.time.LocalDate;

public class accountBean {

	private int subscriberId;
	private long mobileNo;
	private String packageId;
	private float accountBalance;
	private LocalDate rechargedate;
	public int getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(int subscriberId) {
		this.subscriberId = subscriberId;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public LocalDate getRechargedate() {
		return rechargedate;
	}
	public void setRechargedate(LocalDate rechargedate) {
		this.rechargedate = rechargedate;
	}
	

}
