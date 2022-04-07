package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.services.EmployeeServiceImplementation;
import com.revature.services.IEmployeeServices;


@WebServlet("/ViewAllReimbursementsServlet")
public class ViewAllReimbursementsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	ObjectMapper om = new ObjectMapper();
	IEmployeeServices ies = new EmployeeServiceImplementation();

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Reimbursement reimb = om.readValue(request.getInputStream(), Reimbursement.class);
	HttpSession sess = request.getSession(false);
	System.out.println(sess);

	List<Reimbursement> reimbursement = null;

	try {
		reimbursement = ies.viewAllReimbursement(reimb);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (UserNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InternalErrorException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println(reimbursement);
			response.setStatus(200);
			response.getWriter().write(om.writeValueAsString(reimbursement));
	

			response.setHeader("Content-Type", "application/json");
	
	
}

}
