package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.repositories.IReimbursementDAO;
import com.revature.repositories.ReimbursementDAO;
import com.revature.services.IManagerServices;
import com.revature.services.ManagerServiceImplementation;

public class UpdateReimbursementRequest extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IManagerServices ims = new ManagerServiceImplementation();
	IReimbursementDAO  reimbursementDAO = new ReimbursementDAO();
	ObjectMapper om = new ObjectMapper();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reimbursement reimb = om.readValue(request.getInputStream(), Reimbursement.class);
		if(reimb.getStatus().equals("approved")) {
			try {
				System.out.println("came into approve");
				ims.acceptReimbursementRequest(reimb);
			} catch (UserNotFoundException | InternalErrorException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			try {
				System.out.println("came into rejected");

				ims.rejectReimbursementRequest(reimb);
			} catch (UserNotFoundException | InternalErrorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(reimb);
	}

}
