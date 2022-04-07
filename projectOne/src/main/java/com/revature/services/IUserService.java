package com.revature.services;


import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface IUserService {
	
	public User verifyLogin(String username, String password)throws UserNotFoundException, InternalErrorException;

}
