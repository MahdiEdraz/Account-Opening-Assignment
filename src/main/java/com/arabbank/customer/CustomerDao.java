package com.arabbank.customer;

import java.sql.SQLException;

public interface CustomerDao {
	
	
	public void createCustomer() throws SQLException;
	public Customer readCustomer()   throws SQLException;
	public void updateCustomer() throws SQLException;
	public void deleteCustomer() throws SQLException;

}
