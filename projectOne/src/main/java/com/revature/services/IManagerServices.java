package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.Types;

public interface IManagerServices {
	
	public void acceptReimbursementRequest(Reimbursement reimbursement) throws UserNotFoundException, InternalErrorException, SQLException;
	public void rejectReimbursementRequest(Reimbursement reimbursement)throws UserNotFoundException, InternalErrorException;
	public List<Reimbursement> viewFilteredList(Types type) throws InternalErrorException;
	public List<Reimbursement> viewAll() throws InternalErrorException;

}
