package com.cg.payroll.beans;

public class Associate {
	
	private int yearlyInvcestmentUnder80C;
	private String firstName, lastName , department , designation , pancard , emailId;
	private Salary salary;
	private BankDetails bankDetails;
	
	public Salary getSalary() {
		return salary;
	}


	public void setSalary(Salary salary) {
		this.salary = salary;
	}


	public BankDetails getBankDetails() {
		return bankDetails;
	}


	public void setBankDetails(BankDetails bankDetails) {
		this.bankDetails = bankDetails;
	}
	
	@Override
	public String toString() {
		return "Associate [yearlyInvcestmentUnder80C=" + yearlyInvcestmentUnder80C + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", department=" + department + ", designation=" + designation
				+ ", pancard=" + pancard + ", emailId=" + emailId + ", associateId=" + associateId + "]";
	}
	 
	
	public Associate(int yearlyInvestmentUnder80C, String firstName2, String lastName2, String department2, String designation2, String panCard2, String emailId2, Salary salary, BankDetails bankDetails) {
		this.yearlyInvcestmentUnder80C = yearlyInvestmentUnder80C;
		this.firstName = firstName2 ; 
		this.lastName = lastName2;
		this.department = department2;
		this.designation = designation2;
		this.pancard = panCard2;
		this.emailId = emailId2;
		this.salary= salary;
		this.bankDetails = bankDetails;
	}
	private int associateId;
	public int getAssociateId() {
		return associateId;
	}
	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}
	public int getYearlyInvcestmentUnder80C() {
		return yearlyInvcestmentUnder80C;
	}
	public void setYearlyInvcestmentUnder80C(int yearlyInvcestmentUnder80C) {
		this.yearlyInvcestmentUnder80C = yearlyInvcestmentUnder80C;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
}
