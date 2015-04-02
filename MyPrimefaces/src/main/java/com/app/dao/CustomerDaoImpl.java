package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.app.model.Customer;

@Repository
public class CustomerDaoImpl extends BasisDaoImpl<Customer> implements
		CustomerDao {

	@PersistenceContext
	private EntityManager entityManager;


	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> search(List<Object> columnList,
			List<Object> valueList, int startingAt, int maxPerPage) {
		List<Customer> customers = null;
		try {
			String query = "from Customer c order by c.customerCode desc";
			Query eQuery = entityManager.createQuery(query);
			eQuery.setFirstResult(startingAt);
			eQuery.setMaxResults(maxPerPage);
			customers = (List<Customer>) eQuery.getResultList();
		} catch (Exception e) {
			e.printStackTrace();;
		}
		return customers;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> generateCode(String code) {
		String query = "FROM Customer WHERE customerCode LIKE '" + code
				+ "%' ORDER BY customerCode DESC";
		Query eQuery = entityManager.createQuery(query);
		return eQuery.getResultList();
	}


}