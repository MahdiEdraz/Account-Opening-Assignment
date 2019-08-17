package com.arabbank;


import java.sql.*;
public class Main {
	
	
	 public static void main(String args[]) {
		// TODO Auto-generated method stub

		
		try{  
			System.out.print("started");
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/VR_BANk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","1234Prog");   
			  
			}catch(Exception e){ System.out.println(e);}  
		 System.out.print("ended");
	}
	
	 

}
