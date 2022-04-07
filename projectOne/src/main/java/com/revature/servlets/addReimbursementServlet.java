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
import com.revature.services.EmployeeServiceImplementation;
import com.revature.services.IEmployeeServices;


public class addReimbursementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	IEmployeeServices ies = new EmployeeServiceImplementation();
	IReimbursementDAO  reimbursementDAO = new ReimbursementDAO();
	ObjectMapper om = new ObjectMapper();


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Reimbursement reimb = om.readValue(request.getInputStream(), Reimbursement.class);
		try {
			ies.addReimbursementRequest(reimb);
			
		} catch (SQLException | UserNotFoundException | InternalErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(reimb);
	}


}