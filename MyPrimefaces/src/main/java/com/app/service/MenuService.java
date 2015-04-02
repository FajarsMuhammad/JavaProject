package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.MenuDao;
import com.app.model.Menu;

@Component("menuService")
public class MenuService{
	
	@Autowired
	private MenuDao menuDao;


	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	
	public List<Menu> getMenuByParent(String parent){
		return menuDao.getMenuByParent(parent);
	}
	
	
	public List<Menu> getMenuByUser(String user){
		return menuDao.getMenuByUser(user);
	}
	

}
