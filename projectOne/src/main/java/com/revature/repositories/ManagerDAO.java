package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.InternalErrorException;
import com.revature.models.Reimbursement;
import com.revature.models.Types;
import com.revature.util.ConnectionFactory;

public class ManagerDAO implements IManagerDAO{
	private Connection cf = ConnectionFactory.getConnection();

	public List<Reimbursement> filterList(Types type) throws InternalErrorException {
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		Connection conn = null;
		try {
			conn = ((Statement) cf).getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String sql = "select * from projectOne.ers_reimbursement where \"reimb_status\" = ?;";
			PreparedStatement getReimbursement = conn.prepareStatement(sql);
			getReimbursement.setString(1, type.getFilter());
			ResultSet res = getReimbursement.executeQuery();
			System.out.println(type.getFilter());
			
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
	
	
public List<Reimbursement> viewAll() throws InternalErrorException {
		List<Reimbursement> reimbursementList = new ArrayList<Reimbursement>();
		Connection conn = null;
		try {
			conn = ((Statement) cf).getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String sql = "select * from projectOne.ers_reimbursement;";
			PreparedStatement getReimbursement = conn.prepareStatement(sql);
		
			ResultSet res = getReimbursement.executeQuery();
			
			while(res.next()){
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
