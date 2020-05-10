package com.capgemini.pecunia;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

import com.capgemini.pecunia.dao.GetAllRequestsDao;
import com.capgemini.pecunia.service.GetAllRequestsService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PecuniaBankgetAllLoansApplicationTests {
	@Autowired
	private GetAllRequestsService service;
	
	@Autowired
	private GetAllRequestsDao dao;

	@Test
	public void getAllRequestsTest() {
		assertNotNull(dao.findAll());
	}

	@Test
	public void getAllRequestsTest2() {

		assertNotEquals(5, service.getAllRequests().size());
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void allRequestsTestUrl() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:1005/loan/getAllRequests";
		URI uri = new URI(baseUrl);

		ResponseEntity<List> result = restTemplate.exchange(uri, HttpMethod.GET, null, List.class);
		assertEquals(200, result.getStatusCodeValue());
	}

}
