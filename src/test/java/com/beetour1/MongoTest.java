package com.beetour1;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.parsing.FailFastProblemReporter;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.UncategorizedMongoDbException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
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
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class MongoTest {



	@Autowired
	protected MongoTemplate mongo;
	
	
	@Test
	public void test() {

//		for (int i = 0; i < 135; i++) {
//			Customer c = new Customer();
//			c.setFirstName(i);
//			c.setLastName(i + i);
//			mongo.insert(c);
//		}
//		mongo.dropCollection(Customer.class);
//		List<Customer> selectByPage = service.selectByPage(new Customer(), 10, 5);
//		for (Customer customer : selectByPage) {
//			System.out.println(customer);
//		}
//		dao.deleteAll(Customer.class);
//		List<Customer> findAll = mongo.findAll(Customer.class);
//		for (Customer customer : findAll) {
//			System.out.println(customer);
//		}
//		Sort sort = new Sort(Direction.DESC, "firstName");
//		Query query = new Query();
//		query.with(sort);
//		List<Customer> find = mongo.find(query , Customer.class);
//		for (Customer customer : find) {
//			System.out.println(customer);
//		}
	}

}
