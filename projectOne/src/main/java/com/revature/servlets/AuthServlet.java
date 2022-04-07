package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.services.IUserService;
import com.revature.services.UserServiceImplementation;


public class AuthServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	IUserService us = new UserServiceImplementation();
	
	static ArrayList<User> allUsers = new ArrayList<User>();
	ObjectMapper om = new ObjectMapper();

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession sess = request.getSession(false);
	System.out.println(sess);

	// object mapper takes in json and turns to specified object or vice versa
	Credentials cred = om.readValue(request.getInputStream(), Credentials.class);
	User u = null;
	try {
		u = us.verifyLogin(cred.getUsername(), cred.getPassword());
	} catch (UserNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InternalErrorException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println(cred);
			response.setStatus(200);
			response.getWriter().write(om.writeValueAsString(u));
			response.setHeader("Content-Type", "application/json");
	
	
}
}