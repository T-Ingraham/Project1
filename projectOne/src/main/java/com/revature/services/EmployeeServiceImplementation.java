package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.repositories.IUserDAO;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.UserDAO;


public class EmployeeServiceImplementation implements IEmployeeServices {
	
	IUserDAO userDAO = new UserDAO();

	ReimbursementDAO reimbursementDAO = new ReimbursementDAO();
	
	public Reimbursement addReimbursementRequest(Reimbursement reimbursement) throws SQLException, UserNotFoundException, InternalErrorException {
		return reimbursementDAO.addReimburesementRequest(reimbursement);
		
	}
	
 public List<Reimbursement> viewAllReimbursement(Reimbursement reimbursement) throws SQLException, UserNotFoundException, InternalErrorException {
		return userDAO.getReimbursementByAuthor(reimbursement);
	}

	
}
