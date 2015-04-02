package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

public abstract class BasisDaoImpl<T> implements BasisDao<T> {

	private Class<T> clazz;

	@PersistenceContext
	EntityManager entityManager;

	public final void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	
	public T findById(Object arg0){
		return entityManager.find(clazz, arg0);
		
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName())
				.getResultList();
	}

	@Transactional
	public void save(T entity) {
		entityManager.persist(entity);
	}

	public T update(T entity) {
		return entityManager.merge(entity);
	}

	@Transactional
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Transactional
	public void deleteById(long entityId) {
		T entity = findById(entityId);
		delete(entity);
	}
}
