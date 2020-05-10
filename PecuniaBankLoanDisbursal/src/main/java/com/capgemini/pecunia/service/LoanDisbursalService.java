package com.capgemini.pecunia.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.entity.LoanRequests;

public interface LoanDisbursalService {
	public List<LoanDisbursal> getApproveLoans(ResponseEntity<LoanRequests[]> approves);



}
