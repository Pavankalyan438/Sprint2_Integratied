package com.capgemini.pecunia.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.entity.LoanRequests;

public interface LoanRejectsService {

public List<LoanDisbursal> loanRejects(ResponseEntity<LoanRequests[]> requests);

}
