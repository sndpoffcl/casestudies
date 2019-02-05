package com.cg.payroll.client;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.services.PayrollServices;
import com.cg.payroll.services.PayrollServicesImpl;

public class MainClass {
	public static void main(String[] args){
		PayrollServices services = new PayrollServicesImpl();
		int associateId = services.acceptAssociateDetails("Satish", "Mahajan", "satish@gmail.com", "YTP", "manager", "ABCD1234", 84000, 23000, 1200, 12800, 12345, "CITI", "Abc");
		System.out.println("Associate details" +  associateId);
		
	}
}
