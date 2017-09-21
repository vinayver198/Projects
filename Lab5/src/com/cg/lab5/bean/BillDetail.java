package com.cg.lab5.bean;


import java.sql.Date;

public class BillDetail 
{

	private int billNo;
	private int consumerNo;
	private float curReading;
	private float unitConsumed;
	private float netAmount;
	private Date billDate;
	public BillDetail(int billNo, int consumerNo, float curReading,
			float unitConsumed, float netAmount, Date billDate) {
		
		this.billNo = billNo;
		this.consumerNo = consumerNo;
		this.curReading = curReading;
		this.unitConsumed = unitConsumed;
		this.netAmount = netAmount;
		this.billDate = billDate;
	}
	
	
	
	public BillDetail(int consumerNo,float curReading, float unitConsumed, float netAmount,
			Date billDate) {
		this.consumerNo = consumerNo;
		this.curReading = curReading;
		this.unitConsumed = unitConsumed;
		this.netAmount = netAmount;
		this.billDate = billDate;
	}



	public BillDetail() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getBillNo() {
		return billNo;
	}
	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}
	
	
	public int getConsumerNo() {
		return consumerNo;
	}



	public void setConsumerNo(int consumerNo) {
		this.consumerNo = consumerNo;
	}



	public float getCurReading() {
		return curReading;
	}
	public void setCurReading(float curReading) {
		this.curReading = curReading;
	}
	public float getUnitConsumed() {
		return unitConsumed;
	}
	public void setUnitConsumed(float unitConsumed) {
		this.unitConsumed = unitConsumed;
	}
	public float getNetAmount() {
		return netAmount;
	}
	public void setNetAmount(float netAmount) {
		this.netAmount = netAmount;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	@Override
	public String toString() {
		return "BillDetail [billNo=" + billNo + ", consumerNo = " + consumerNo
				+ ", curReading=" + curReading + ", unitConsumed="
				+ unitConsumed + ", netAmount=" + netAmount + ", billDate="
				+ billDate + "]";
	}




	
	
	
}
