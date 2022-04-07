package com.revature.repositories;

import java.sql.SQLException; 

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;

public interface IReimbursementDAO {
	
	public Reimbursement addReimburesementRequest(Reimbursement reimbursement) throws UserNotFoundException, InternalErrorException, SQLException;
	public Reimbursement rejectReimburesementRequest(Reimbursement reimbursement) throws UserNotFoundException, InternalErrorException, SQLException;
	public Reimbursement approveReimburesementRequest(Reimbursement reimbursement) throws UserNotFoundException, InternalErrorException, SQLException;
}
