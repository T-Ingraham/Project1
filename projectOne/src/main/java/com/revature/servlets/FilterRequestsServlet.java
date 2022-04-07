package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.InternalErrorException;
import com.revature.models.Reimbursement;
import com.revature.models.Types;
import com.revature.models.User;
import com.revature.services.IManagerServices;
import com.revature.services.ManagerServiceImplementation;

public class FilterRequestsServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	static ArrayList<User> allUsers = new ArrayList<User>();
	
	ObjectMapper om = new ObjectMapper();
	IManagerServices ims = new ManagerServiceImplementation();
	Types type = new Types();

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	Types statusFilterTypes = om.readValue(request.getInputStream(), Types.class);
	String filter = statusFilterTypes.toString();
	
	System.out.println("Type is => "+statusFilterTypes);
	System.out.println("Type is => "+ filter);


	HttpSession sess = request.getSession(false);
	System.out.println(sess);

	List<Reimbursement> reimbursement = null;
	try {
		reimbursement = ims.viewFilteredList(statusFilterTypes);
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
