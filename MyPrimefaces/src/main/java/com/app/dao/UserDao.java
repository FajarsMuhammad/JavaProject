package com.app.dao;

import java.util.List;

import com.app.model.User;

public interface UserDao extends BasisDao<User> {
	
	public User getUserByLoginname(final String userName);
	
	public User getUserByLoginnamePassword(final String userName, final String password);

	public List<User> getUsers(final String userName);
}
