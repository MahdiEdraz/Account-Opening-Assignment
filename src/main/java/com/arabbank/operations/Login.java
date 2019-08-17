package com.arabbank.operations;
import java.sql.SQLException;

import com.arabbank.DataObjects.User;
import com.arabbank.DataObjects.UserDaoImp;

public class Login {
	
	private User user ;
	private UserDaoImp userOperations;
	

	
	public Login() {
		
		this.user = new User();
	}
	
	
	public void setUserNameAndPassword(String userName ,String password) {
		
		this.user.setUserName(userName);
		this.user.setPassword(password);
		initUserOperations();
		
	}
	
	private void initUserOperations() {
		userOperations = new UserDaoImp(user);
		
	}


	public void CreateUser() throws SQLException {
		userOperations.createUser();
	}
	
	
	
	public boolean verifyUser() throws SQLException {
		userOperations.readUser();
		return this.user.equals(userOperations.getUser());
		

	}
	

}
