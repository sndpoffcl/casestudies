package com.cg.payroll.daoservices;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.util.PayrollDBUtil;

public class AssociateDAOImpl implements AssociateDAO {

	public Associate save(Associate associate) {
		associate.setAssociateId(PayrollDBUtil.getASSOCIATE_ID_COUNTER());
		PayrollDBUtil.associates.put(associate.getAssociateId(),associate);
		return associate;
	}

	public boolean update(Associate associate) {
		
		return false;
	}

	public Associate findOne(int associateId) {
		return PayrollDBUtil.associates.get(associateId);
	}

	public List<Associate> findAll() {
		return new  ArrayList<>(PayrollDBUtil.associates.values());
		//return PayrollDBUtil.associates.values().stream().collect(Collectors.toList());
	}

}
