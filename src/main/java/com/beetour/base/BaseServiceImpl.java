

package com.beetour.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public  class BaseServiceImpl<T> implements BaseServiceI<T> {

	@Autowired
	private BaseDaoI<T> dao;

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
	public List<T> selectByExample(Class<T> t) {
		return dao.selectByExample(t);
	}

	@Override
	public List<T> selectByPage(T t, int pageSize, int page) {
		return dao.selectByPage(t, pageSize, (page * pageSize) - 1);
	}
	

}
