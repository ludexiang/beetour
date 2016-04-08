package com.beetour1;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.beetour.domain.item.Item;
import com.beetour.domain.item.Itemgp;
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
//			com.beetour1.Order o = new com.beetour1.Order();
//			List<String> s = new ArrayList<String>();
//			s.add("1");
//			s.add("2");
//			o.setList(s);
//			mongo.insert(o);
			//		mongo.dropCollection(Customer.class);
//		List<Customer> selectByPage = service.selectByPage(new Customer(), 10, 5);
//		for (Customer customer : selectByPage) {
//			System.out.println(customer);
//		}
//		dao.deleteAll(Customer.class);
//		com.beetour1.Order find = mongo.findById("57061b3c41b1ab1e202f9c66", com.beetour1.Order.class);
//			for (String s : find.getList()) {
//				System.out.println(s);
//			}
//			
//			for(int i = 0; i < find.getList().size(); i++)  
//	        {  
//				String s = find.getList().get(i);   
//				System.out.println(s);
//	        }  

//		Set<String> collectionNames = mongo.getCollectionNames();
//		for (String string : collectionNames) {
//			System.out.println(string);
//		}
		mongo.dropCollection(Itemgp.class);
		mongo.dropCollection(Item.class);
//		Sort sort = new Sort(Direction.DESC, "firstName");
//		Query query = new Query();
//		query.with(sort);
//		List<Customer> find = mongo.find(query , Customer.class);
//		for (Customer customer : find) {
//			System.out.println(customer);
//		}
//			List<String> l = new ArrayList<String>();
//			l.add("3");
//			Query query = new Query(Criteria.where("id").is("57061b3c41b1ab1e202f9c66") );
//			Update update = new Update().set("list", l);
//			mongo.updateFirst(query, update, com.beetour1.Order.class);
//			com.beetour1.Order find1 = mongo.findById("57061b3c41b1ab1e202f9c66", com.beetour1.Order.class);
//			System.out.println(find1);
	}

}
