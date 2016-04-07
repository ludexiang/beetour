package com.beetour1;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

public class TestCustomerRESTController {
	public static final String REST_SERVICE_URI = "http://127.0.0.1:8080/springmvc-mongo";

	@Test
	public void testRead() {
		System.out.println("Testing GetOne API,using ResponseEntity()-----------");
		HttpHeaders headers = new HttpHeaders();
		RestTemplate restTemplate = new RestTemplate();
		RequestEntity<Customer> requestEntity = new RequestEntity<Customer>(headers, HttpMethod.GET,
				URI.create(REST_SERVICE_URI + "/customer/56ef6c679c25491fa07bec51"));
		ResponseEntity<Customer> responseEntity = restTemplate.exchange(requestEntity, Customer.class);
		System.out.println(responseEntity.getBody());
	}

	/* GET */
	@SuppressWarnings({ "unchecked" })
	@Test
	public  void listAll() {
		System.out.println("Testing GetAll API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> map = restTemplate.getForObject(REST_SERVICE_URI + "/customer/all",
				List.class);
		String json = JSON.toJSONString(map);
		System.out.println(json);
	}

	/* GET */
	@Test
	public void getOne() {
		System.out.println("Testing GetOne API----------");
		RestTemplate restTemplate = new RestTemplate();
		Customer c = restTemplate.getForObject(REST_SERVICE_URI + "/customer/123456789", Customer.class);
		System.out.println(c);
	}

	/* POST */
	@Test
	public void createOne() {
		System.out.println("Testing createOne API----------");
		RestTemplate restTemplate = new RestTemplate();
		String requestBody = "{\"id\":\"123456789\",\"firstName\":\"zou\",\"lastName\":\"xiaobin\"}";
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/customer/", requestBody, Customer.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

	/* PUT */
	@Test
	public void updateOne() {
		System.out.println("Testing updateOne API----------");
		RestTemplate restTemplate = new RestTemplate();

		// MultiValueMap<String, Object> headers = new
		// LinkedMultiValueMap<String, Object>();
		// headers.add("Accept", "application/json");
		// headers.add("Content-Type", "application/json");

		String requestBody = "{\"id\":123456789,\"firstName\":\"lu\",\"lastName\":\"dx\"}";
		restTemplate.put(REST_SERVICE_URI + "/customer/123456789", requestBody);
		System.out.println(requestBody);
	}

	/* DELETE */
	@SuppressWarnings("unused")
	private static void deleteOne() {
		System.out.println("Testing deleteOne API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/customer/123456");
	}


}
