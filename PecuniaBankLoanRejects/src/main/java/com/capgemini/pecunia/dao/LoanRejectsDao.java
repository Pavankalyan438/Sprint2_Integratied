package com.capgemini.pecunia.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.pecunia.entity.LoanDisbursal;
@Repository
public interface LoanRejectsDao extends JpaRepository<LoanDisbursal, Integer> {
	@Query("select r from LoanDisbursal r where loanStatus='Rejected'")
	List<LoanDisbursal> findAllRejected();

}
