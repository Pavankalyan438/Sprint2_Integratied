package com.capgemini.pecunia.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.dao.AccountDao;
import com.capgemini.pecunia.dao.LoanRequestDao;
import com.capgemini.pecunia.entity.AccountDetails;
import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.exception.BankAccountNotFound;

@Service
public class LoanRequestServiceImp implements LoanRequestService {
	@Autowired
	LoanRequestDao dao;
	@Autowired
	AccountDao account;
	@Override
	public String loanRequest(LoanRequests loanreq) {
		String s1 = loanreq.getAccountId();
		Optional<AccountDetails> details = account.findById(s1);

		if (details.isPresent()) {
			dao.save(loanreq);

			return "Your Loan Request is successful";
		} else {

			throw new BankAccountNotFound("No BankAccount found with " + loanreq.getAccountId()
					+ "\n You need to have an Bank Account to applay Loan");
		}

	}

}
