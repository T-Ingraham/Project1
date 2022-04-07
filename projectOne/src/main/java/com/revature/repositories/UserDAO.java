package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionFactory;

public class UserDAO implements IUserDAO{
	
	Connection cf = ConnectionFactory.getConnection();

	
	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException, InternalErrorException, SQLException{
		
		
		
		try {
			String sql = "select * from projectOne.ers_users where ?,?;";
			PreparedStatement getUser = cf.prepareStatement(sql);
			getUser.setString(1, username);
			getUser.setString(2, password);

			
			ResultSet res = getUser.executeQuery();
			if(res.next()) {
				User u = new User();
				u.setUsers_id(res.getInt("ers_users_id"));
				u.setUsername(res.getString("ers_username"));
				u.setPassword(res.getString("ers_password"));
				u.setFirst_name(res.getString("user_first_name"));
				u.setLast_name(res.getString("user_last_name"));
				u.setEmail(res.getString("user_email"));
				u.setUser_role(res.getString("user_role"));
	
				
				getUser.executeQuery();


				return u;
			
			}else {
				throw new UserNotFoundException();
			}
	
}catch(SQLException e) {
	e.printStackTrace();
	throw new InternalErrorException();
	
}finally {
	//( (Object) cf).releaseConnection(conn);
	//cf.close();
}
	}	
	
	
	
	public List<Reimbursement> getReimbursementByAuthor(Reimbursement reimbursement) throws InternalErrorException {
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		try {
			String sql = "select * from projectOne.ers_reimbursement where \"reimb_author\" = ?;";
			PreparedStatement getReimbursement = cf.prepareStatement(sql);
			getReimbursement.setString(1, reimbursement.getAuthor());
			ResultSet res = getReimbursement.executeQuery();
			System.out.println(reimbursement.getAuthor());
			
			while(res.next()) {
				reimbursementList.add(new Reimbursement(
						res.getInt("reimb_id"),
						res.getDouble("reimb_amount"),
						res.getString("reimb_submitted"),
						res.getString("reimb_resolved"),
						res.getString("reimb_description"),
						res.getString("reimb_author"),
						res.getString("reimb_resolver"),
						res.getString("reimb_type"),
						res.getString("reimb_status")	
						));
			}
	
}catch(SQLException e) {
	e.printStackTrace();
	throw new InternalErrorException();
	
}//finally {
	//cf.releaseConnection(conn);
//}
		return reimbursementList;		
	}	
	
		
}
