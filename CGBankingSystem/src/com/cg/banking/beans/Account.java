package com.cg.banking.beans;


import java.util.HashMap;
import java.util.Map;

public class Account {
	private int pinNumber;
	private String accountType, accountStatus;
	private float accountBalance;
	private Map<Integer, Transaction> transactions;
	private long accountNo;
	
	
	
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
	
	public Account(long accountNo,String accountType2, float initBalance, int pin, String accountStatus2, HashMap<Integer, Transaction> transactions2) {
		this.accountNo = accountNo;
		this.accountType = accountType2;
		this.accountBalance = initBalance; 
		this.pinNumber = pin;
		this.accountStatus = accountStatus2;
		this.transactions = transactions2;
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(accountBalance);
		result = prime * result + (int) (accountNo ^ (accountNo >>> 32));
		result = prime * result + ((accountStatus == null) ? 0 : accountStatus.hashCode());
		result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
		result = prime * result + pinNumber;
		result = prime * result + ((transactions == null) ? 0 : transactions.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (Float.floatToIntBits(accountBalance) != Float.floatToIntBits(other.accountBalance))
			return false;
		if (accountNo != other.accountNo)
			return false;
		if (accountStatus == null) {
			if (other.accountStatus != null)
				return false;
		} else if (!accountStatus.equals(other.accountStatus))
			return false;
		if (accountType == null) {
			if (other.accountType != null)
				return false;
		} else if (!accountType.equals(other.accountType))
			return false;
		if (pinNumber != other.pinNumber)
			return false;
		if (transactions == null) {
			if (other.transactions != null)
				return false;
		} else if (!transactions.equals(other.transactions))
			return false;
		return true;
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
