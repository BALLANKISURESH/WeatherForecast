package com.virtusa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CredentialsDao {
	public boolean register(String uname,String pass) {
		/**
		 * 
		 * @author Suresh
		 * This Dao class is used for the setting new user  credentials 
		 *in the data base.
		 */
		String url="jdbc:mysql://localhost:3306/weather?autoReconnect=true&useSSL=false";
		String username="root";
		String password="0000";
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con=DriverManager.getConnection(url,username,password);
				Statement st=con.createStatement();

				String q="insert into credentials values('"+uname+"',md5('"+pass+"'))";
				st.executeUpdate(q);//This will update the data base with new user.
				return true;
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return false;
		
		}
	
	/**
	 * 
	 * @author Suresh
	 *this Dao class will be used for fetching data
	 * from the data base for verifying login credentials.
	 * 
	 */
	public boolean loginVerify(String uname,String pass) {
		String url="jdbc:mysql://localhost:3306/weather?autoReconnect=true&useSSL=false";
		String username="root";
		String password="0000";
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			Connection con=DriverManager.getConnection(url,username,password); 
			Statement st=con.createStatement();
			String q="select * from credentials where uname='"+uname+"' and upass=md5('"+pass+"')";
			
			ResultSet rs=st.executeQuery(q); //this result set will stored the fetch data to verify.
			if(rs.next()) {
				return true;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return false;
	}

}
