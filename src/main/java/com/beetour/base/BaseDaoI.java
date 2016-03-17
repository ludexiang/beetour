package com.beetour.base;

import java.util.List;


public interface BaseDaoI<T> {
	
	void insert(T t);

	void delete(T t);
	
	void deleteAll(Class<T> t);
	
	void update(T t);	

	T selectById(T t);
	
	List<T> selectByExample(Class<T> t);

	/**
	 * 分页查询
	 * @param t 查询对象
	 * @param limit 每页显示数量
	 * @param skip	页数
	 * @return
	 */
	List<T> selectByPage(T t,int limit,int skip);
}
