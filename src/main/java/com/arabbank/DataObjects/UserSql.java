package com.arabbank.DataObjects;

public enum UserSql {
	
	SELECT(" SELECT * FROM USERS WHERE userName = (?) ")
	,INSERT("INSERT INTO USERS (userName,password) VALUES(?,?)")
	,UPDATE(""),
	DELETE("");
	
	private String sql;
	
	UserSql(String sql){
		this.sql=sql;
	}
	
	
	public String getVal() {
		return sql;
	}

}
