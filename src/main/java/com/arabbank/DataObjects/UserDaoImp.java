package com.arabbank.DataObjects;
import com.arabbank.DataBase.MySqlConnectionPool;
import java.sql.*;


public class UserDaoImp implements UserDao {
	
	private User user ; 
	/*to verfiy the user after executeing select statment*/
	private User userResult;
	
	
	public UserDaoImp(User user) {
		this.user = user;
		userResult = new User();
	}

	@Override
	public void createUser() throws SQLException {
		Connection connection = MySqlConnectionPool.getConnectoin();
		PreparedStatement pstmt = connection.prepareStatement(UserSql.INSERT.getVal());
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPassword());
		
		int affectedRows = pstmt.executeUpdate();
		
		System.out.print(affectedRows);

		MySqlConnectionPool.releaseConnection(connection);
		
		
	}

	@Override
	public void readUser() throws SQLException {
		
		Connection connection = MySqlConnectionPool.getConnectoin();
		PreparedStatement pstmt = connection.prepareStatement(UserSql.SELECT.getVal());
		pstmt.setString(1, user.getUserName());
		ResultSet rs= pstmt.executeQuery();
		
		while(rs.next()) {
			userResult.setPassword(rs.getString("password"));
			userResult.setUserName(rs.getString("userName"));
		}

		MySqlConnectionPool.releaseConnection(connection);
		
	}

	public User getUser() {
		return userResult;
	}

	@Override
	public void updateUser()  throws SQLException  {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser()  throws SQLException  {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[]) throws Exception{
		
		User user = new User();
		
		user.setPassword("1111");
		user.setUserName("mahdi");
		
		UserDaoImp dao = new UserDaoImp(user);
		
		dao.readUser();
		
		
	  
	}
	
	

}
