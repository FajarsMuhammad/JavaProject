package com.app.dao;

import java.util.List;

import com.app.model.Menu;

public interface MenuDao extends BasisDao<Menu> {

	
	public List<Menu> getMenuByParent(String parent);
	
	
	public List<Menu> getMenuByUser(String user);
	
	

}