package com.revature.repositories;

import java.sql.SQLException;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.User;

public interface IUserDAO {

	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException, InternalErrorException, SQLException;
	
	public List<Reimbursement> getReimbursementByAuthor(Reimbursement reimbursement) throws InternalErrorException ;
	
}
