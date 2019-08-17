package com.arabbank.customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.arabbank.DataBase.MySqlConnectionPool;
import com.arabbank.DataObjects.UserSql;

public class CustomerDaoImp implements CustomerDao{
	
	
	private Customer customer;

	
	 CustomerDaoImp(Customer customer){
		 this.customer = customer;
	}
	 
	 
	
	@Override
	public void createCustomer() throws SQLException {
		
		
		Connection connection = MySqlConnectionPool.getConnectoin();
		PreparedStatement pstmt = connection.prepareStatement(CustomerSql.INSERT.getVal());
		pstmt.setString(1, customer.getFirstName());
		pstmt.setString(2, customer.getLastName());
		pstmt.setInt(3, customer.getNationalNumber());
		pstmt.setString(4, customer.getNationality());
		pstmt.setString(5, customer.getTel1());
		pstmt.setString(6, customer.getTel2());
		pstmt.setString(7, String.valueOf(customer.getGender()));
		
		int affectedRows = pstmt.executeUpdate();
		
		System.out.print(affectedRows);

		MySqlConnectionPool.releaseConnection(connection);
		
	}

	@Override
	public Customer readCustomer() throws SQLException {
		Customer customerResult = new Customer();
		Connection connection = MySqlConnectionPool.getConnectoin();
		PreparedStatement pstmt = connection.prepareStatement(UserSql.SELECT.getVal());
		pstmt.setInt(1, customer.getId());
		ResultSet rs= pstmt.executeQuery();
		
		while(rs.next()) {
			
			customerResult.setFirstName(rs.getString("firstName"));
			customerResult.setLastName(rs.getString("lastName"));
			customerResult.setGender(rs.getString("gender").charAt(0));
			customerResult.setNationality(rs.getString("nationality"));
			customerResult.setNationalNumber(rs.getInt("nationalNumber"));
			
			
		}

		MySqlConnectionPool.releaseConnection(connection);
		
		return customerResult;
		
	}

	@Override
	public void updateCustomer() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer() throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[]) throws SQLException{
		
	
	
		
		
	
	}
	
	

}
