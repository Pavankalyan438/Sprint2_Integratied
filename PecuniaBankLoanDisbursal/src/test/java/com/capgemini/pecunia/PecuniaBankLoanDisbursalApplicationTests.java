package com.capgemini.pecunia;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.dao.LoanDisbursalDao;
import com.capgemini.pecunia.entity.LoanDisbursal;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PecuniaBankLoanDisbursalApplicationTests {
	@SuppressWarnings("unused")
	@Autowired
	private LoanDisbursalDao dao;


	@Test
	public void allApprovedTest() {

	
		Mockito.when(dao.findAllAccepted())
				.thenReturn(Stream.of(new LoanDisbursal("111111111111", 0, 15, 400, 6, "rejected", "gold", 0, 44))
						.collect(Collectors.toList()));
		assertEquals(1, dao.findAllAccepted().size());

	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void allApprovedTest1() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:1001/loan/approvedrequests";
		URI uri = new URI(baseUrl);
		ResponseEntity<ArrayList> result = restTemplate.exchange(uri, HttpMethod.GET, null, ArrayList.class);
		assertEquals(200, result.getStatusCodeValue());
	}
	@Test
	public void rejectsTest() {
		assertNotEquals(5, dao.findAllAccepted().size());
	}
}