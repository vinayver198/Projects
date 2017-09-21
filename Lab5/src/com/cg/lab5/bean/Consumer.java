package com.cg.lab5.bean;

public class Consumer 
{
	private int consumerNo;
	private String consumerName;
	private String address;
	public int getConsumerNo() {
		return consumerNo;
	}
	public void setConsumerNo(int consumerNo) {
		this.consumerNo = consumerNo;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public Consumer(int consumerNo) {
		
		this.consumerNo = consumerNo;
	}
	public Consumer(int consumerNo, String consumerName, String address) {
		super();
		this.consumerNo = consumerNo;
		this.consumerName = consumerName;
		this.address = address;
	}
	public Consumer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Consumer [consumerNo=" + consumerNo + ", consumerName="
				+ consumerName + ", address=" + address + "]";
	}
	
	
	
}
