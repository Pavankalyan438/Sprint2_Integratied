package com.capgemini.pecunia;

import static org.junit.Assert.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.dao.UpdateBalanceDao;
import com.capgemini.pecunia.entity.LoanDisbursal;
import com.capgemini.pecunia.service.UpdateBalanceService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PecuniaBankUpdateBalanceApplicationTests {
	@Autowired
	UpdateBalanceService service;
	@MockBean
	UpdateBalanceDao dao;
	String expected="Sufficient Account Balance is not found to pay EMI, deposit money in your account to pay month emi";
	
	@Test
	public void updateBalanceTest() {
		
		LoanDisbursal loandis=new LoanDisbursal("111111111111", 100, 5, 988, 6, "accepted", "study", 150, 55);		
		assertEquals(expected,service.updateBalance(loandis));
	}

	@Test
	public void updateBalanceTestFail() {
		
		LoanDisbursal loandis=new LoanDisbursal("111111111111", 1000, 5, 988, 6, "accepted", "study", 150, 55);		
		assertEquals(expected,service.updateBalance(loandis));
	}
	@Test
	public void updateBalanceTestUp() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:1004/update/updateBal";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		LoanDisbursal loandis=new LoanDisbursal("111111111111", 1000, 5, 988, 6, "accepted", "study", 150, 55);		
		HttpEntity<LoanDisbursal> request = new HttpEntity<>(loandis, headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}
	
	}


