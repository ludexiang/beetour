
package com.beetour.base;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.beetour.util.ClassUtil;
import com.beetour.util.CriteriaUtil;


@SuppressWarnings("unchecked")
public abstract class BaseDaoImpl<T> implements BaseDaoI<T> {

	@Autowired
	protected MongoTemplate mongo;

	@Override
	public void insert(T t) {
		mongo.insert(t);
	}

	@Override
	public void delete(T t) {
		mongo.remove(t);
	}

	@Override
	public void deleteAll(Class<T> t) {
		mongo.dropCollection(t);
	}
	
	@Override
	public void update(T t) {
		mongo.save(t);
	}


	@Override
	public T selectById(T t) {
		Object idValue = null;
		try {
			idValue = ClassUtil.getIdValue(t);
		} catch (Exception e) {
			try {
				throw new Exception(t.getClass() + "  idValue  获取失败！");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(idValue == null){
			return null;
		}
		return (T) mongo.findById(idValue, t.getClass());
	}

	@Override
	public List<T> selectByExample(Class<T> t) {
		return (List<T>) mongo.findAll(t);
	}

	@Override
	public List<T> selectByPage(T t, int limit, int skip) {
		Query query = null;
		Map<String, Object> nameAndValue = null;
		try {
			nameAndValue = ClassUtil.getFieldsNameAndValue(t);
		} catch (Exception e) {
			try {
				throw new Exception(t.getClass() + "  FieldsNameAndValue  获取失败！");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		Criteria criteria = CriteriaUtil.getCriteriaOfIs(nameAndValue);

		if (criteria != null) {
			query = new Query(criteria);
		} else {
			query = new Query();
		}
		query.limit(limit);
		query.skip(skip);
		List<? extends Object> find = mongo.find(query, t.getClass());
		return (List<T>) find;
	}



}
