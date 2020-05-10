package com.capgemini.pecunia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.service.LoanRequestService;

@RestController
@RequestMapping("/loan")
@CrossOrigin("http://localhost:4200")
public class LoanReqControllerClass {
	@Autowired
	LoanRequestService service;

	@PostMapping("/request")
	public ResponseEntity<String> loanRequest(@RequestBody LoanRequests loanreq) {
		String request = service.loanRequest(loanreq);
		return new ResponseEntity<String>(request, new HttpHeaders(), HttpStatus.OK);
	}

}
