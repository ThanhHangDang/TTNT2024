package com.testjavaweb.services.impl;

import javax.inject.Inject;

import com.testjavaweb.dao.IUserDAO;
import com.testjavaweb.model.UserModel;
import com.testjavaweb.services.IUserService;

public class UserService implements IUserService{
	
	@Inject
	private IUserDAO userDAO;
	
	@Override
	public UserModel findByUserNameAndPasswordAndStatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndStatus(userName, password, status);
	}
}
