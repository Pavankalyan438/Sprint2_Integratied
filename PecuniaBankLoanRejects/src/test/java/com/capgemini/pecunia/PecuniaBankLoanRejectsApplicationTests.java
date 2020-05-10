package com.capgemini.pecunia;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.capgemini.pecunia.dao.LoanRejectsDao;

@SpringBootTest
@RunWith(SpringRunner.class)


public class PecuniaBankLoanRejectsApplicationTests {
	@Autowired
	LoanRejectsDao dao;
	@Test
	public void rejectsTest() {
		assertNotEquals(5, dao.findAllRejected().size());
	}
		
	@Test
	@SuppressWarnings("rawtypes")
	public void allRejectsTestFail() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:1003/loan/allreqrejects";
		URI uri = new URI(baseUrl);
		ResponseEntity<List> result = restTemplate.exchange(uri, HttpMethod.GET, null, List.class);
		assertEquals(500, result.getStatusCodeValue());
	}
	@Test
	@SuppressWarnings("rawtypes")
	public void allRejectsTestPass() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:1003/loan/allreqrejects";
		URI uri = new URI(baseUrl);		
		ResponseEntity<List> result = restTemplate.exchange(uri, HttpMethod.GET, null, List.class);
		assertEquals(200, result.getStatusCodeValue());
	}
	

}
