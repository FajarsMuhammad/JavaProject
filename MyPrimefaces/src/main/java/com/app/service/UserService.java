package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.UserDao;
import com.app.model.User;

@Component("userService")
public class UserService{
	
	@Autowired
	UserDao userDao;

	
	public User getUserByLoginname(String userName) {
		return userDao.getUserByLoginname(userName);
	}
	
	
	public User getUserByLoginnamePassword(String userName, String password) {
		return userDao.getUserByLoginnamePassword(userName, password);
	}
	
	public List<User> getUsers(final String userName){
		return userDao.getUsers(userName);
	}
	

}
