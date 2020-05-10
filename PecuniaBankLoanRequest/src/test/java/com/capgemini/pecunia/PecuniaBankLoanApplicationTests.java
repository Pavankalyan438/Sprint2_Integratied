package com.capgemini.pecunia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

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

import com.capgemini.pecunia.dao.LoanRequestDao;
import com.capgemini.pecunia.entity.LoanRequests;
import com.capgemini.pecunia.service.LoanRequestService;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PecuniaBankLoanApplicationTests {
	@Autowired
	LoanRequestService service;
	@MockBean
	LoanRequestDao dao;

	@Test
	public void loanRequestTestFail() {
		LoanRequests loanreq = new LoanRequests("888833338888", 10000, 33, 900, 5, "pending", "study loan", 82);
		assertEquals("Your Loan Request is successful", service.loanRequest(loanreq));
	}

	/*
	 * @Test public void loanRequestTest() { LoanRequests loanreq=new
	 * LoanRequests("111111111111", 10000, 33, 900, 5, "pending","house loan",82);
	 * assertEquals("Your Loan Request is successful",service.loanRequest(loanreq));
	 * }
	 */
	@Test
	public void loanRequestTestNotNull() {
		LoanRequests loanreq = new LoanRequests("222222222222", 2000, 33, 788, 5, "pending", "car loan", 82);
		assertNotNull(service.loanRequest(loanreq));
	}

	@Test
	public void loanRequestTestMock() {
		LoanRequests loanreq = new LoanRequests("111111111111", 10000, 33, 900, 5, "pending", "house loan", 82);
		when(dao.save(loanreq)).thenReturn(loanreq);
		assertEquals(loanreq, dao.save(loanreq));
	}

	@Test
	public void loanRequestTestPass() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:1000/loan/request";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		LoanRequests loanRequest = new LoanRequests("222222222222", 10000, 44, 899, 6, "pending", "study", 77);
		HttpEntity<LoanRequests> request = new HttpEntity<>(loanRequest, headers);
		ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
		assertEquals(200, result.getStatusCodeValue());
	}
}
