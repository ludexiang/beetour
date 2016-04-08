package com.beetour.controller;

import java.util.ArrayList;
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
import com.beetour.util.Page;

@Controller
public class CustomerController {
	protected final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = {"hello","index","index.html",""}, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String hello() {
		LOGGER.info("hello!");
		return "hello!";
	}

	@RequestMapping(value = "/say/{msg}", produces = "application/json;charset=UTF-8")
	public @ResponseBody String say(@PathVariable(value = "msg") String msg) {
		return "{\"msg\":\"you say:'" + msg + "'\"}";
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



	@RequestMapping(value =  "list/{lists}" )
	public String getList(Customer customer, @RequestParam(required = false, defaultValue = "1") int page, 
			@PathVariable(value = "lists") String lists,
			Model model) {
		Page pages = null;
		int totalCount = customerService.findAll().size();
		List<Customer> list = new ArrayList<Customer>();

		if (page != 1) {
			pages = new Page(totalCount, page, 10);
			list = customerService.selectByPage(customer, pages.getPageSize(), page);
		} else {
			pages = new Page(totalCount, 1, 10);
			list = customerService.selectByPage(customer, pages.getPageSize(), page);
		}
		model.addAttribute("customer", list);
		model.addAttribute("page", page);
		model.addAttribute("totalCount", totalCount);
		if(lists.equals("list2")){			
			return "list2";
		} else {
			return "list";
		}
	}
	
	@RequestMapping(value =  "getJson" )
	@ResponseBody
	public List<Customer> getJson(Customer customer, @RequestParam(required = false, defaultValue = "1") int page, 
			Model model) {
		
		Page pages = null;
		int totalCount = customerService.findAll().size();
			List<Customer> list = new ArrayList<Customer>();
			if (page != 1) {
				pages = new Page(totalCount, page, 10);
				list = customerService.selectByPage(customer, pages.getPageSize(), page);
			} else {
				pages = new Page(totalCount, 1, 10);
				list = customerService.selectByPage(customer, pages.getPageSize(), page);
			}
		return list;
	}
	
	
	@RequestMapping(value =  "upload" )
	public String upload(){
		return "upload";
	}
}
