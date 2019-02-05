package com.cg.banking.beans;


import java.util.HashMap;
import java.util.Map;

public class Account {
	private int pinNumber;
	private String accountType, accountStatus;
	private float accountBalance;
	private Map<Integer, Transaction> transactions;
	private long accountNo;
	private int pinCounter;
	
	
	@Override
	public String toString() {
		return "Account [pinNumber=" + pinNumber + ", accountType=" + accountType + ", accountStatus=" + accountStatus
				+ ", accountBalance=" + accountBalance + ", transactions=" + transactions + ", accountNo=" + accountNo
				+ ", pinCounter=" + pinCounter + "]";
	}
	public int getPinCounter() {
		return pinCounter;
	}
	public void setPinCounter(int pinCounter) {
		this.pinCounter = pinCounter;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Account(String accountType2, float initBalance, int pin, String accountStatus2, HashMap<Integer, Transaction> transactions2) {
		this.accountType = accountType2;
		this.accountBalance = initBalance; 
		this.pinNumber = pin;
		this.accountStatus = accountStatus2;
		this.transactions = transactions2;
		
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	public Map<Integer, Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(Map<Integer, Transaction> transactions) {
		this.transactions = transactions;
	}
	
	

}
