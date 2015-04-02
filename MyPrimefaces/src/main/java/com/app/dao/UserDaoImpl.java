package com.app.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.app.model.User;

@Repository
public class UserDaoImpl extends BasisDaoImpl<User> implements UserDao {
	
	@SuppressWarnings("rawtypes")
	public User getUserByLoginname(final String userName) {
		Query query = this.entityManager
                .createQuery("select u FROM User u where u.userName= :userName");
        query.setParameter("userName", userName);
        List users = query.getResultList();
        if (users != null && users.size() == 1) {
            return (User) users.get(0);
        }
        return null;
	}
	
	public User getUserByLoginnamePassword(final String userName, final String password) {
		return null;
	}
	
	public List<User> getUsers(final String userName){
		return null;
	}

}
