package com.cg.banking.test;

import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.banking.beans.*;
import com.cg.banking.exceptions.*;
import com.cg.banking.services.*;
import com.cg.banking.util.BankingDBUtil;



public class BankingServicesTest {
		
	private static BankingServices bankServices;
	
	@BeforeClass
	public static void setUpTestEnv() {
		bankServices = new BankingServicesImpl();
	}
	
	@Before
	public void setUpTestData() {
		HashMap<Integer, Transaction> transactions1 = new HashMap<Integer, Transaction>();
		Account account1 = new Account(100001,"Savings", 5000 , 1234 , "ACTIVE" ,new HashMap<Integer, Transaction>() );
		BankingDBUtil.accounts.put(account1.getAccountNo(),account1);
		HashMap<Integer, Transaction> transactions2 = new HashMap<Integer, Transaction>();
		Account account2 = new Account(100002,"Current", 5000 , 1234 , "ACTIVE" ,new HashMap<Integer, Transaction>() );
		BankingDBUtil.accounts.put(account2.getAccountNo(),account2);
		
		BankingDBUtil.ACCOUNT_NO_COUNTER=100002;
	}
	
	@Test(expected=AccountNotFoundException.class)
	public void testGetAccountDetailsForInvalidAccountNo() throws AccountNotFoundException, BankingServicesDownException{
		bankServices.getAccountDetails(9876544);
	}
	
	@Test
	public void testGetAccountDetailsForValidAccountNo() throws AccountNotFoundException, BankingServicesDownException{
		Account expectedAccount = new Account(100001,"Savings", 5000 , 1234 , "ACTIVE" ,new HashMap<Integer, Transaction>());
		Account actualAccount = bankServices.getAccountDetails(100001);
		Assert.assertEquals(expectedAccount, actualAccount);
	}
	
	@Test
	public void testOpenAccountForValidData() throws InvalidAmountException, InvalidAccountTypeException, BankingServicesDownException {
		long expectedId= 100003;
		long actualId = bankServices.openAccount("savings", 6000);
		Assert.assertEquals(expectedId, actualId);
	}
	
	@Test(expected=AccountNotFoundException.class)
	public void testDepositAmountForInvalidAccountNo() throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException{
		bankServices.depositAmount(123456, 5000);
	}
	
	@Test
	public void testDepositAmountForValidAccountNo() throws AccountNotFoundException, BankingServicesDownException, AccountBlockedException{
		long expectedAmount = 10000;
		long actualAmount = (long)(bankServices.depositAmount(100001, 5000));
		Assert.assertEquals(expectedAmount, actualAmount);
	}
	
	@Test(expected = AccountNotFoundException.class)
	public void testWithdrawAmountForInvalidAccountNo() throws AccountNotFoundException, InsufficientAmountException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException{
		bankServices.withdrawAmount(123345, 56789, 1234);
	}
	
	@Test
	public void testWithdrawAmountForValidAccountNo() throws AccountNotFoundException, InsufficientAmountException, InvalidPinNumberException, BankingServicesDownException, AccountBlockedException{
		long expectedAmount = 4000;
		long actualAmount = (long)( bankServices.withdrawAmount(100001, 1000, 1234));
		Assert.assertEquals(expectedAmount, actualAmount);
	}
	
	
	
	@After
	public void tearDownTestData() {
		BankingDBUtil.accounts.clear();
		BankingDBUtil.ACCOUNT_NO_COUNTER=100;
	}
	@AfterClass
	public static void tearDownTestEnv() {
		bankServices = null ;
	}
}
