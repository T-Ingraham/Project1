package com.revature.repositories;

import java.sql.SQLException;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;

public class UserDAODebugger {
	
		public static void main(String[] args) throws UserNotFoundException, InternalErrorException {
			
				IUserDAO ud = new UserDAO();
			try {
				System.out.println(ud.findUserByUsernameAndPassword("employee2","password"));
			} catch (UserNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InternalErrorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
		}


}
