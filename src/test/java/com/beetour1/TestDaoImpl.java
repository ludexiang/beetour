package com.beetour1;


import org.springframework.stereotype.Repository;

import com.beetour.base.BaseDaoImpl;

@Repository(value = "testDao")
public class TestDaoImpl extends BaseDaoImpl<Customer> implements TestDao {

	
}
