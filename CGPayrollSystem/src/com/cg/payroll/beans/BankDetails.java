package com.cg.payroll.beans;

public class BankDetails {
	public BankDetails(int accountNumber2, String bankName2, String ifscCode2) {
		this.accountNumber = accountNumber2;
		this.bankName = bankName2;
		this.ifscCode = ifscCode2;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getIfscCode() {
		return ifscCode;
	}
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	private int accountNumber;
	private String bankName , ifscCode;
}
