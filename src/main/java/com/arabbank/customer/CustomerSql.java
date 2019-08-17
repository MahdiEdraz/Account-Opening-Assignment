package com.arabbank.customer;

public enum CustomerSql {
	
	INSERT("INSERT INTO CUSTOMERS (firstName,lastName,nationalNumber,nationality,tel1,tel2,gender)"
			+" VALUES (?,?,?,?,?,?,?) "),
	SELECT("SELECT * FROM CUSTOMERS WHERE id = (?) ");
	
	private String sql; 
	
	CustomerSql(String sql){
		
		this.sql = sql ;
		
		
	}
	
	public String getVal() {
		return sql;
	}

}
