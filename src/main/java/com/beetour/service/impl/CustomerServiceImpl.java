package com.beetour.service.impl;

import org.springframework.stereotype.Service;


import com.beetour.domain.Customer;
import com.beetour.base.BaseServiceImpl;
import com.beetour.service.CustomerService;

@Service
public class CustomerServiceImpl extends BaseServiceImpl<Customer> implements CustomerService {

	@Override
	protected Class<Customer> getEntityClass() {
		return Customer.class;
	}



}
