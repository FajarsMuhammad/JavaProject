package com.app.service;


public interface AuthenticationService {
	
	boolean login(String username, String password);

	//@RolesAllowed({"ROLE_ADMIN","ROLE_USER"})
	//void logout();
}
