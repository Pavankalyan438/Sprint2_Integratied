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

import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.service.UpdateBalanceService;

@RestController
@RequestMapping("/update")
@CrossOrigin("http://localhost:4200")
public class UpdateBalanceController {
	@Autowired
	UpdateBalanceService service;
	
	@PostMapping("/updateBal")
	public ResponseEntity<String> updateBal(@RequestBody LoanDisbursal loandis) {
		
		String update= service.updateBalance(loandis);
		return new ResponseEntity<String>(update, new HttpHeaders(), HttpStatus.OK);
	}
}
