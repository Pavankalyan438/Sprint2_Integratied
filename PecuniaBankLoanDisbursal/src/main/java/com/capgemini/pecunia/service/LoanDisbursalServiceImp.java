package com.capgemini.pecunia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.dao.LoanDisbursalDao;
import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.entity.LoanRequests;

@Service
public class LoanDisbursalServiceImp implements LoanDisbursalService {
	@Autowired
	LoanDisbursalDao dao;

	LoanDisbursal disburse = new LoanDisbursal();

	@Override
	public List<LoanDisbursal> getApproveLoans(ResponseEntity<LoanRequests[]> approves) {

		LoanRequests[] body = approves.getBody();
		for (int p = 0; p < body.length; p++) {
			LoanRequests l = body[p];
			if ((l.getCreditScore() >= 670) && (!(dao.existsById(l.getLoanId())))) {
				disburse.setAccountId(l.getAccountId());
				disburse.setCreditScore(l.getCreditScore());
				disburse.setLoanAmount(l.getLoanAmount());
				disburse.setLoanId(l.getLoanId());
				disburse.setLoanRoi(l.getLoanRoi());
				disburse.setLoanStatus("Accepted");
				disburse.setLoanTenure(l.getLoanTenure());
				disburse.setLoanType(l.getLoanType());
				double interest = (l.getLoanAmount() * l.getLoanTenure() * l.getLoanRoi() / (100 * 12));
				double emi = ((l.getLoanAmount() + interest) / l.getLoanTenure());
				emi = Math.round(emi * 100) / 100;
				disburse.setEmi(emi);

				dao.save(disburse);
			}
		}

		return dao.findAllAccepted();

	}
}
