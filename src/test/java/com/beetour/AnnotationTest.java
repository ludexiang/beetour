package com.beetour;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-jdbc.xml" })
public class AnnotationTest {
	@Autowired
	private MongoTemplate mongo;

	public void teat() {
		Customer c = new Customer();
		c.setId("56e68304f5c2b611ec3ed180");
		c.setFirstName("lu");
		c.setLastName("xander");
		mongo.save(c);
	}


}
