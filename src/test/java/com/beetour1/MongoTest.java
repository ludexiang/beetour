package com.beetour1;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.data.mongodb.UncategorizedMongoDbException;
import org.springframework.data.mongodb.core.MongoOptionsFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mongodb.ConnectionString;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:spring-jdbc.xml" })
public class MongoTest {



	@Autowired
	protected MongoTemplate mongo;

	@Test
	public void test() {
		for (int i = 0; i < 200; i++) {
			Customer c = new Customer();
			c.setFirstName(String.valueOf(i));
			c.setLastName(String.valueOf(i + i));
			mongo.insert(c);
		}
//		mongo.dropCollection(Customer.class);
//		List<Customer> selectByPage = service.selectByPage(new Customer(), 10, 5);
//		for (Customer customer : selectByPage) {
//			System.out.println(customer);
//		}
//		dao.deleteAll(Customer.class);
		List<Customer> findAll = mongo.findAll(Customer.class);
		for (Customer customer : findAll) {
			System.out.println(customer);
		}
	}

}
