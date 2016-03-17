package com.beetour;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.UncategorizedMongoDbException;
import org.springframework.data.mongodb.core.MongoFactoryBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml","classpath:spring-jdbc.xml" })
public class MongoTest {

	@Autowired
	private TestService testService;

	@Test
	public void test() {
//		for (int i = 0; i < 100; i++) {
//			Customer c = new Customer();
//			c.setFirstName(String.valueOf(i));
//			c.setLastName(String.valueOf(i + i));
//			dao.insert(c);
//		}
		List<Customer> selectByPage = testService.selectByPage(new Customer(), 10, 5);
		for (Customer customer : selectByPage) {
			System.out.println(customer);
		}
//		dao.deleteAll(Customer.class);
	}

}
