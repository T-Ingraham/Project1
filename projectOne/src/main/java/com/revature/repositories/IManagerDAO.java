package com.revature.repositories;

import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.models.Reimbursement;
import com.revature.models.Types;

public interface IManagerDAO {

	public List<Reimbursement> filterList(Types type)throws InternalErrorException;
	public List<Reimbursement> viewAll() throws InternalErrorException;


	
}
