package com.app.dao;

import java.util.List;

public interface BasisDao<T> {

	// public T findById( long id );
	public List<T> findAll();

	public void save(T entity);

	public T update(T entity);

	public void delete(T entity);

	public void deleteById(long entityId);

	T findById(Object arg0);

}