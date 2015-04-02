package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.app.model.Menu;

@Repository
public class MenuDaoImpl  extends BasisDaoImpl<Menu> implements MenuDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@SuppressWarnings("unchecked")
	public List<Menu> getMenuByUser(String user){
		String query = "from Menu m where m.id in (select distinct m.id " +
				"from UserRole ur, RoleMenu rm, Menu m " +
				"where ur.user.userName = :userName and ur.role.id = rm.role.id and rm.menu.id = m.id) order by m.sequence asc";
		Query eQuery = entityManager.createQuery(query);
		eQuery.setParameter("userName", user);
		return eQuery.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Menu> getMenuByParent(String parent){
		String query = "from Menu m where m.parentCode = :parentCode order by m.sequence asc";
		Query eQuery = entityManager.createQuery(query);
		eQuery.setParameter("parentCode", parent);
		return eQuery.getResultList();
	}
	

}
