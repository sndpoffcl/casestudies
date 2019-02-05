package com.cg.banking.client;

import java.util.Scanner;

import com.cg.banking.beans.Account;
import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.*;


public class MainClass {
	public static void main(String[] args) throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException, AccountNotFoundException, AccountBlockedException, InsufficientAmountException, InvalidPinNumberException {
		boolean flag = true;
		BankingServices bankServices = new BankingServicesImpl();
		System.out.println("Kindly chose your option ");
		while(flag)
		{	
			System.out.println("Please chose an option: ");
			System.out.println("1. Create a new account ");
			System.out.println("2. Deposit money in an account");
			System.out.println("3. Withdram money from an account");
			System.out.println("4. Fund Transfer");
			System.out.println("5. Get Account Details");
			System.out.println("6. Show all accounts");
			System.out.println("7. Exit");
			Scanner sc = new Scanner(System.in);
			int switchKey = sc.nextInt();
			switch(switchKey)
			{
			case 1 : System.out.println("**CREATING NEW ACCOUNT**");
					 System.out.println("Please chose an account type \n 1.Saving Account \t 2.Current Account ");
					 int accType= sc.nextInt();
					 float initBalance;
					 String accountType;
					 if(accType == 1 ) {
						  accountType = "Savings Account";
					 }else{
						  accountType = "Current Account" ; 
					 }
					 System.out.println("Enter initial balance");
					 initBalance = sc.nextFloat();
					 long accountNo = bankServices.openAccount(accountType, initBalance);
					 Account newAcc = bankServices.getAccountDetails(accountNo);
					 System.out.println("Account created : KINDLY NOTE YOUR CREDENTIALS");
					 System.out.println("Account Number : " + newAcc.getAccountNo() );
					 System.out.println("Pin Number : " + newAcc.getPinNumber());
					 System.out.println("Account Status : " + newAcc.getAccountStatus());
					 System.out.println("Balance : " + newAcc.getAccountBalance());
					 System.out.println("Account type : " + newAcc.getAccountType() + "\n");
					 break;
					 
			case 2 : System.out.println("****DEPOSIT MONEY IN ACCOUNT****");
					 System.out.println("Enter your account number");
					 long accNo = sc.nextLong();
					 System.out.println("Enter the amount you want to deposit");
					 float depAmount = sc.nextFloat();
					 float newAmount = bankServices.depositAmount(accNo, depAmount);
					 System.out.println("Transaction successful \nUpdated Balance  :" + newAmount);
					 break;
					 
			case 3 : System.out.println("****WITHDRAW MONEY FROM ACCOUNT****");
					 System.out.println("Enter your account number");
					 accNo = sc.nextLong();
					 System.out.println("Enter the amount you want to Withdraw");
					 float withAmount = sc.nextFloat();
					 System.out.println("Enter your pin number");
					 int pinNo = sc.nextInt();
					 newAmount = bankServices.withdrawAmount(accNo, withAmount, pinNo);
					 System.out.println("Transaction successful \nUpdated Balance" + newAmount);
					 break;
					 
			case 4 : System.out.println("*****FUND TRANSFER*****");
					 System.out.println("Enter your account number");
					 accNo = sc.nextLong();
					 System.out.println("Enter amount you want to transfer");
					 float transAmount = sc.nextFloat();
					 System.out.println("Enter account number to transfer");
					 long newAccNo = sc.nextLong();
					 System.out.println("Enter your pin number");
					 pinNo = sc.nextInt();
					 newAmount = bankServices.withdrawAmount(accNo, transAmount, pinNo);
					 bankServices.depositAmount(newAccNo, transAmount);
					 System.out.println("Your updated account number is :" + newAmount);
					 break;
			
			case 5 : System.out.println("*****ACCOUNT DETAILS********");
					 System.out.println("Enter your account number");
					 accNo = sc.nextLong();
					 bankServices.getAccountDetails(accNo).toString();
					 
			case 7: flag = false;
					break;
			default: System.out.println("Invalid option");
					break;
			}
		}
	}
}
