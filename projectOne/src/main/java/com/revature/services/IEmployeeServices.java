package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;

public interface IEmployeeServices {

	public Reimbursement addReimbursementRequest(Reimbursement reimbursement) throws SQLException, UserNotFoundException, InternalErrorException;
	public List<Reimbursement> viewAllReimbursement(Reimbursement reimbursement) throws SQLException, UserNotFoundException, InternalErrorException;
}
