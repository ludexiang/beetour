package com.beetour1;



import com.beetour.base.BaseServiceImpl;


public class TestServiceImpl extends BaseServiceImpl<Customer> implements TestService {

	@Override
	protected Class<Customer> getEntityClass() {
		// TODO Auto-generated method stub
		return Customer.class;
	}

}
