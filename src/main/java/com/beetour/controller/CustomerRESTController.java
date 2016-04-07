package com.beetour.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.beetour.domain.Customer;
import com.beetour.service.CustomerService;
import com.wordnik.swagger.annotations.ApiOperation;

@SuppressWarnings({ "unchecked", "rawtypes" })
@RestController
@RequestMapping("customer")
public class CustomerRESTController {
	
	/**
	 说明：
		其中@ApiOperation和@ApiParam为添加的API相关注解，个参数说明如下：
		@ApiOperation(value = “接口说明”, httpMethod = “接口请求方式”, response = “接口返回参数类型”, notes = “接口发布说明”；其他参数可参考源码；
		@ApiParam(required = “是否必须参数”, name = “参数名称”, value = “参数具体描述”
	 */
	
	
	
	protected final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService customerService;

	// select all
	@RequestMapping(value = "all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(hidden = true, value = "")
	public ResponseEntity<List<Customer>> selectAll() {
		List<Customer> all = customerService.findAll();
		if (all == null || all.isEmpty()) {
			LOGGER.info("Fetching with All is not found!");
			return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Customer>>(all, HttpStatus.OK);
	}
	
	
	// select one
	@RequestMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(hidden = true, value = "")
	public ResponseEntity<Customer> selectOne(@PathVariable("id") String id) {
		Customer c = new Customer();
		c.setId(id);
		Customer customer = customerService.selectByKey(c);
		if (customer == null) {
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	// create
	@RequestMapping(value = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(hidden = true, value = "")
	public ResponseEntity<Void> create(@RequestBody Customer customer,UriComponentsBuilder ucBuilder) {
		if (customer.getId() != null){
			Customer c = customerService.selectByKey(customer);
			if(c != null){
				LOGGER.info("Customer " + c.getId() + " already exist!");
				return new ResponseEntity("-1", HttpStatus.CONFLICT);
			}
			customerService.save(customer);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/customer/" + "{id}").buildAndExpand(customer.getId()).toUri());
			return new ResponseEntity("1", headers, HttpStatus.CREATED);
		} else {
			LOGGER.info("Exception==Creating one: RequestBody may be is null!");
			return new ResponseEntity("-2", HttpStatus.EXPECTATION_FAILED);
		}
	}

	//update
	@RequestMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(hidden = true, value = "")
	public ResponseEntity<Customer> update(@PathVariable("id") String id,@RequestBody Customer customer) {
		LOGGER.info("Fetching&Updating One with id:" + id);
		Customer c = customerService.selectByKey(customer);
		if (c == null) {
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		customerService.update(customer);
		return new ResponseEntity("1", HttpStatus.OK);
	}
	
	// delete
	@RequestMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(hidden = true, value = "")
	public ResponseEntity<Customer> delete(@PathVariable("id") String id) {
		LOGGER.info("Fetching&Deleting One with id:" + id);
	 	Customer customer = new Customer();
		customer.setId(id);
		Customer c = customerService.selectByKey(customer);
			
		if (c == null) {
			LOGGER.info("Fetching One with id:" + id + " is not found!");
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		customerService.delete(customer);
		return new ResponseEntity("1", HttpStatus.OK);
	}

}
