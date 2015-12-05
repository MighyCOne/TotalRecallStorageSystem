package com.eintern.business;

public class MoneyHandler {
	
	private final double LATE_FEE=500;
	private final double STORAGE_PRICE=2000;
	private int time_remaining=10;
	
	
	public double getLATE_FEE() {
		return LATE_FEE;
	}
	public double getSTORAGE_PRICE() {
		return STORAGE_PRICE;
	}
	public int getTime_remaining() {
		return time_remaining;
	}
	public void setTime_remaining(int time_remaining) {
		this.time_remaining = time_remaining;
	}
	

	
	
	
	

}
