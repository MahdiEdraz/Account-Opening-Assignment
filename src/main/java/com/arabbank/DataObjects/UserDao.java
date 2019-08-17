package com.arabbank.DataObjects;

import java.sql.SQLException;

public interface UserDao {
	
	public void createUser() throws SQLException;
	public void readUser()   throws SQLException;
	public void updateUser() throws SQLException;
	public void deleteUser() throws SQLException;

}
