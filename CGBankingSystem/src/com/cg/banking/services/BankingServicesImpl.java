package com.cg.banking.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.cg.banking.beans.*;
import com.cg.banking.daoservices.*;
import com.cg.banking.exceptions.*;
import com.cg.banking.util.BankingDBUtil;

public class BankingServicesImpl implements BankingServices{
	
	private AccountDAO accountDao = new AccountDAOImpl();
	private TransactionDAO transDao = new TransactionDAOImpl();
	Scanner sc = new Scanner(System.in);
	
	@Override
	public long openAccount(String accountType, float initBalance)
			throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
			if(initBalance<500) {
				throw new InvalidAmountException("Amount should be more than 500");
			}
			int pin = (int)( Math.random()*10000 ) ;
			String accountStatus = "ACTIVE";
			HashMap<Integer, Transaction> transactions = new HashMap<Integer, Transaction>();
			Account account = new Account(accountType, initBalance , pin , accountStatus ,transactions );
			account = accountDao.save(account);
			return account.getAccountNo();
	}

	@Override
	public float depositAmount(long accountNo, float amount)
			throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException {
		Account accnt = getAccountDetails(accountNo);
		if(accnt.getAccountStatus().equalsIgnoreCase("ACTIVE")) {
			float newAmount = accnt.getAccountBalance() + amount;
			accnt.setAccountBalance(newAmount);
			int transactionId = BankingDBUtil.getTRANSACTION_NO_COUNTER();
			Transaction transaction = new Transaction(transactionId, amount , "DEPOSITED");
			accnt.getTransactions().put(transactionId, transaction);
			return newAmount;
		}else {
			throw new AccountBlockedException("This account has been blocked");
		}
	}

	@Override
	public float withdrawAmount(long accountNo, float amount, int pinNumber) throws InsufficientAmountException,
			AccountNotFoundException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException {
		Account accnt = getAccountDetails(accountNo);
		if(accnt.getAccountStatus().equalsIgnoreCase("ACTIVE")){
			for(int i =0;i<2;i++) {
				if(accnt.getPinNumber()==pinNumber) {
					float newAmount = accnt.getAccountBalance() - amount ; 
					if(newAmount < 500) 
						throw new InsufficientAmountException("Balance cannot go below 500");
					else {
						accnt.setAccountBalance(newAmount);
						int transactionId = BankingDBUtil.getTRANSACTION_NO_COUNTER();
						Transaction transaction = new  Transaction(transactionId, amount, "WITHDRAW");
						accnt.getTransactions().put(transactionId, transaction);
					}
					return newAmount;
				}
				else {
					System.out.println("Your PIN is wrong . Kindly enter again");
					pinNumber = sc.nextInt();
				}
			}
			accnt.setAccountStatus("BLOCKED");
			throw new InvalidPinNumberException("YOUR PIN WAS WRONG MULTIPLE TIMES ");
		}else 
			throw new AccountBlockedException("YOUR ACCOUNT HAS BEEN BLOCKED");
	
}

	
	@Override
	public boolean fundTransfer(long accountNoTo, long accountNoFrom, float transferAmount, int pinNumber)
			throws InsufficientAmountException, AccountNotFoundException, InvalidPinNumberException,
			BankingServicesDownException, AccountBlockedException {
			float newAmount = withdrawAmount(accountNoFrom, transferAmount, pinNumber);
			float newAmountAfterDep = depositAmount(accountNoTo, transferAmount);
			if(newAmount!=0.00f) 
				return true;
			else
				return false;
		
	}

	@Override
	public Account getAccountDetails(long accountNo) throws AccountNotFoundException, BankingServicesDownException {
		Account account = accountDao.findOne(accountNo);
		if(account==null) {
			throw new AccountNotFoundException("Account not found : " + accountNo);
		}
		return account;
	}

	@Override
	public List<Account> getAllAccoutDetails() throws BankingServicesDownException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getAccountAllTransaction(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String accountString(long accountNo)
			throws BankingServicesDownException, AccountNotFoundException, AccountBlockedException {
		Account accnt = getAccountDetails(accountNo);
		return "Account [pinNumber=" + accnt.getPinNumber() + ", accountType=" + accnt.getAccountType() + ", accountStatus=" + accnt.getAccountStatus()
				+ ", accountBalance=" + accnt.getAccountBalance() + ", accountNo=" + accnt.getAccountNo()
				+  "]";
	}
	
}
