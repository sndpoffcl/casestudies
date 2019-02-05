package com.cg.banking.util;

import java.util.HashMap;

import com.cg.banking.beans.Account;



public class BankingDBUtil {
	public static HashMap<Long, Account> accounts = new HashMap<Long, Account>();
	private static long ACCOUNT_NO_COUNTER = 100000;
	private static int TRANSACTION_NO_COUNTER = 100;
	
	public static long getACCOUNT_NO_COUNTER() {
		return ++ACCOUNT_NO_COUNTER;
	}
	
	public static int getTRANSACTION_NO_COUNTER() {
		return ++TRANSACTION_NO_COUNTER;
	}
	
}