package com.app.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.app.model.Menu;
import com.app.service.MenuService;

@ManagedBean(name="menubarBean")
@SessionScoped
@Component
public class MenubarBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4325507928309748916L;

	private MenuModel model;

	@Autowired
	private MenuService menuService;

	public MenubarBean() {
		 

	}

	public void init(ComponentSystemEvent event) {

		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		UserDetails userDetails = null;
		if (principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}
		String user = userDetails.getUsername();

		//String user = "admin";

		model = new DefaultMenuModel();
		buildMenu(user);

		FacesContext ctx = FacesContext.getCurrentInstance();
		String path = ctx.getExternalContext().getRequestContextPath();

		DefaultMenuItem menuItemQuit = new DefaultMenuItem();
		menuItemQuit.setValue("Quit");
		menuItemQuit.setIcon("ui-icon ui-icon-close");
		menuItemQuit.setUrl(path + "/j_spring_security_logout");
		model.addElement(menuItemQuit);

	}

	public MenuModel getModel() {
		return model;
	}

	private void buildMenu(String user) {
		try {

			List<Menu> menuList = menuService.getMenuByUser(user);
			for (Menu m : menuList) {
				if (m.getMenuLevel() == 1) {
					DefaultSubMenu parent = new DefaultSubMenu();
					 parent.setLabel(m.getMenuName());
					 parent.setIcon("ui-icon-contact");
					model.addElement(parent);
					buildMenuRecursive(parent, m, user);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void buildMenuRecursive(DefaultSubMenu parent, Menu menu,
			String user) {
		try {
			String menuCode = "";
			if(menu!=null)
				menuCode = menu.getMenuCode();
			List<Menu> menus = menuService.getMenuByParent(menuCode);
			for (Menu m : menus) {
				if (m.getMenuUrl() == null 	&& m.getMenuLevel() == 2) {
					DefaultSubMenu subsub = new DefaultSubMenu();
					subsub.setLabel(m.getMenuName());
					subsub.setIcon("ui-icon-contact");
					parent.addElement(subsub);
					//model.addElement(parent);
					buildMenuRecursive(subsub, m, user);
				} else {
					DefaultMenuItem menuItem = new DefaultMenuItem();
					menuItem.setValue(m.getMenuName());
					menuItem.setUrl(m.getMenuUrl());
					menuItem.setIcon("ui-icon ui-icon-document");
					parent.addElement(menuItem);
					//model.addElement(parent);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
