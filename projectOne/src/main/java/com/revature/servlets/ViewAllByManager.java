package com.revature.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.InternalErrorException;
import com.revature.models.Reimbursement;

import com.revature.services.IManagerServices;
import com.revature.services.ManagerServiceImplementation;


@WebServlet("/ViewAllByManager")

public class ViewAllByManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ObjectMapper om = new ObjectMapper();
	IManagerServices ims = new ManagerServiceImplementation();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sess = request.getSession(false);

		List<Reimbursement> reimbursement = null;

			try {
				reimbursement = ims.viewAll();
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
