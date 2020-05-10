package com.capgemini.pecunia.service;

import java.sql.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.pecunia.dao.AccountDao;
import com.capgemini.pecunia.dao.TransactionsDao;
import com.capgemini.pecunia.dao.UpdateBalanceDao;
import com.capgemini.pecunia.entity.AccountDetails;
import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.entity.Transactions;

@Service
public class UpdateBalanceServiceImp implements UpdateBalanceService {
	@Autowired
	UpdateBalanceDao dao;
	@Autowired
	private TransactionsDao transac;
	@Autowired
	private AccountDao account;

	AccountDetails accountDetails = new AccountDetails();
	Transactions transaction = new Transactions();
	Random rand = new Random();
	long millis = System.currentTimeMillis();
	Date date = new Date(millis);

	@Override
	public String updateBalance(LoanDisbursal loandis) {
		
		if (((loandis.getLoanAmount() - loandis.getEmi()) > 0)) {
			loandis.setLoanId(loandis.getLoanId());
			loandis.setAccountId(loandis.getAccountId());
			loandis.setCreditScore(loandis.getCreditScore());
			loandis.setEmi(loandis.getEmi());
			double amount = loandis.getLoanAmount() - loandis.getEmi();
			amount = Math.round(amount * 100) / 100;
			loandis.setLoanAmount(amount);
			loandis.setLoanRoi(loandis.getLoanRoi());
			loandis.setLoanStatus(loandis.getLoanStatus());
			loandis.setLoanTenure(loandis.getLoanTenure() - 1);
			loandis.setLoanType(loandis.getLoanType());

			transaction.setAccountId(loandis.getAccountId());
			transaction.setTransAmount(loandis.getEmi());
			transaction.setTransDate(date);
			transaction.setTransFrom(loandis.getAccountId());
			transaction.setTransId(rand.nextInt(1000));
			transaction.setTransTo("Pecunia Bank");
			transaction.setTransType("EMI");
			transac.save(transaction);

			AccountDetails details = account.selectById(loandis.getAccountId());
			details.setAmount(details.getAmount() - loandis.getEmi());
			account.save(details);

			dao.save(loandis);

			return "This month Emi amount " + loandis.getEmi() + " of " + loandis.getAccountId() + " accoount for "
					+ loandis.getLoanType() + " is paid" + " due loan is "
					+ (loandis.getLoanTenure() * loandis.getEmi());
		} else {
			return "Sufficient Account Balance is not found to pay EMI, deposit money in your account to pay month emi";
		}
	}

}
