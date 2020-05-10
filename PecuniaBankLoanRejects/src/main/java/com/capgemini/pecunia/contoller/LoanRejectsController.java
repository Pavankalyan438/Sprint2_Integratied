package com.capgemini.pecunia.contoller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.service.LoanRejectsService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/loan")
@CrossOrigin("http://localhost:4200")
public class LoanRejectsController {
	String str = null;
	@Autowired
	RestTemplate rest;
	@Autowired
	LoanRejectsService service;
	LoanRequests loanrequ = new LoanRequests();
	LoanDisbursal loandis = new LoanDisbursal();

	@GetMapping("/allreqrejects")
	@HystrixCommand(fallbackMethod="allRejectsFallback")
	public ArrayList<LoanDisbursal> allRejects() {
	ResponseEntity<LoanRequests[]> requests = rest.getForEntity("http://localhost:1005/loan/getAllRequests",
				LoanRequests[].class);

		return (ArrayList<LoanDisbursal>) service.loanRejects(requests);

	}
	@SuppressWarnings("unused")
	private ArrayList<LoanDisbursal> allRejectsFallback() {
		LoanDisbursal loandis=new LoanDisbursal("SERVER disDOWN",0 , 0, 0, 0, "SERVER DOWN", "SERVER DOWN", 0, 0);
				ArrayList<LoanDisbursal> al= new ArrayList<>();
		al.add(loandis);
		return al;
		
	}
}
