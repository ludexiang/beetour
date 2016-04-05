

package com.beetour.base;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BaseDao<T> dao;

	@Override
	public void save(T entity) {
		dao.insert(entity);
	}

	@Override
	public void delete(T t) {
		dao.delete(t);
	}

	@Override
	public void update(T t) {
		dao.update(t);
	}

	@Override
	public T selectByKey(T t) {
		return dao.selectById(t);
	}

	@Override
	public List<T> findAll() {
		return dao.findAll(getEntityClass());
	}

	@Override
	public List<T> selectByPage(T t, int pageSize, int page) {
		return dao.selectByPage(t, pageSize, (page - 1) * pageSize);
	}
	
	protected abstract Class<T> getEntityClass();

}
