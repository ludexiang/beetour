package com.beetour.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.beetour.domain.Customer;
import com.beetour.service.CustomerService;

@Controller
public class CustomerController {
	protected final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/hello", produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String hello() {
		LOGGER.info("hello!");
		return "hello!";
	}
	
	@RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")
	public @ResponseBody String say(@PathVariable(value = "msg") String msg) {
		return "{\"msg\":\"you say:'" + msg + "'\"}";
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Customer getCustomer(@PathVariable("id") String id) {
		LOGGER.info("获取国家id=" + id);
		Customer c = new Customer();
		c.setId(id);
		Customer customer = customerService.selectByKey(c);
		
		return customer;
	}
	
	@RequestMapping("/customers")
	@ResponseBody
	public List<Customer> selectAll() {
		 return customerService.findAll();
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(Customer customer) {
		if (customer.getId() != null) 
			customerService.save(customer);
		return "list";
	}
	
	@RequestMapping("delete")
	public String delete(Customer customer) {
		customerService.delete(customer);
		return "list";
	}

	@RequestMapping(value = { "list", "index", "index.html", "" })
	public String getList(Customer customer, @RequestParam(required = false, defaultValue = "2") int page,
			@RequestParam(required = false, defaultValue = "10") int rows,
			Model model) {
		List<Customer> list = customerService.selectByPage(customer, rows, page);
		model.addAttribute("customer", list);
		model.addAttribute("page", page);
		model.addAttribute("rows", rows);
		return "list";
	}
}
