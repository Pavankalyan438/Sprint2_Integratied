package com.capgemini.pecunia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.pecunia.entity.LoanDisbursal;

public interface LoanDisbursalDao extends JpaRepository<LoanDisbursal, Integer> {

	@Query("select r from LoanDisbursal r where loanStatus='Accepted'")
	List<LoanDisbursal> findAllAccepted();

}
