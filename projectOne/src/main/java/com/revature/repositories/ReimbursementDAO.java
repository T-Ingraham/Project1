package com.revature.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.exceptions.InternalErrorException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Reimbursement;
import com.revature.util.ConnectionFactory;

public class ReimbursementDAO implements IReimbursementDAO {

	Connection cf = ConnectionFactory.getConnection();

	public Reimbursement addReimburesementRequest(Reimbursement reimbursement)
			throws UserNotFoundException, InternalErrorException, SQLException {

		try {
			String sql = "insert into projectOne.ers_reimbursement(reimb_amount, reimb_submitted, reimb_description, reimb_author, reimb_status, reimb_type)  "
					+ "values (?,?,?,?,?,?) returning reimb_id; ";
			PreparedStatement addReimbursementReq = cf.prepareStatement(sql);
			final java.util.Date today = new java.util.Date();
			final java.sql.Timestamp todaySQL = new java.sql.Timestamp(today.getTime());

			addReimbursementReq.setDouble(1, reimbursement.getAmount());
			addReimbursementReq.setTimestamp(2, todaySQL);
			addReimbursementReq.setString(3, reimbursement.getDescription());
			addReimbursementReq.setString(4, reimbursement.getAuthor());
			addReimbursementReq.setString(5, "pending");
			addReimbursementReq.setString(6, reimbursement.getType());

			ResultSet res = addReimbursementReq.executeQuery();
			res.next();
			reimbursement.setId(res.getInt("reimb_id"));

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException();

		} // finally {
			// cf.releaseConnection(conn);
//}		
		return reimbursement;
	}

	public Reimbursement approveReimburesementRequest(Reimbursement reimbursement)
			throws UserNotFoundException, InternalErrorException {
		System.out.println("new oneee + " + reimbursement);
		try {
			((Statement) cf).getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String sql = "update projectOne.ers_reimbursement "
					+ "set reimb_resolved = ?, reimb_resolver = ?, reimb_status = ? " + "Where reimb_id = ? ";
			PreparedStatement approveReimburesementReq = cf.prepareStatement(sql);
			final java.util.Date today = new java.util.Date();
			final java.sql.Timestamp todaySQL = new java.sql.Timestamp(today.getTime());

			approveReimburesementReq.setTimestamp(1, todaySQL);
			approveReimburesementReq.setString(2, reimbursement.getResolver());
			approveReimburesementReq.setString(3, "approved");
			approveReimburesementReq.setInt(4, reimbursement.getId());

			approveReimburesementReq.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException();

		} // finally {
//cf.releaseConnection(conn);
//}		
		return null;
	}

	public Reimbursement rejectReimburesementRequest(Reimbursement reimbursement)
			throws UserNotFoundException, InternalErrorException {

		try {
			((Statement) cf).getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			String sql = "update projectOne.ers_reimbursement "
					+ "set reimb_resolved = ?, reimb_resolver = ?, reimb_status = ?" + "Where reimb_id = ? ";
			PreparedStatement approveReimburesementReq = cf.prepareStatement(sql);
			final java.util.Date today = new java.util.Date();
			final java.sql.Timestamp todaySQL = new java.sql.Timestamp(today.getTime());

			approveReimburesementReq.setTimestamp(1, todaySQL);
			approveReimburesementReq.setString(2, reimbursement.getResolver());
			approveReimburesementReq.setString(3, "denied");
			approveReimburesementReq.setInt(4, reimbursement.getId());

			approveReimburesementReq.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new InternalErrorException();

		} // finally {
//cf.releaseConnection(conn);
//}		
		return null;
	}

}
