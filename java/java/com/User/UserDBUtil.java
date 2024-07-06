package com.User;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	public static List <User> validate (String email,String password) {
		
		ArrayList<User> u = new ArrayList<>();
		
		//validate
		
		try {
			
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "select * from user where Email='"+email+"' and Password='"+password+"'";
			
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String email1 = rs.getString(3);
				String password1 = rs.getString(4);
				String Name = rs.getString(2);
				String DOB = rs.getString(5);
				String Gender = rs.getString(6);
				String Country = rs.getString(7);

				User u1 = new User(id,Name,email1,password1,DOB,Gender,Country);
				u.add(u1);
				
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		return u;
		
	}
	
	//Insert part------02
	
		public static boolean insertUser(String name,String email,String password,String dob,String gender,String country) {
			
			
			boolean isSuccess = false;
			
			
			try {
				
				con = DBConnection.getConnection();
				stmt = con.createStatement();
				
				String sql ="insert into user values (0,'"+name+"','"+email+"','"+password+"','"+dob+"','"+gender+"','"+country+"')";
				
				int rs = stmt.executeUpdate(sql);
				
				if(rs > 0) {
					isSuccess = true;
				}else {
					
				    isSuccess = false;
				    
					}
				
		    }
			catch(Exception e) {
				e.printStackTrace();
			}
			
			return isSuccess;
			
			}
		
	
	public static boolean deleleUser(String id) {
		
		int convId = Integer.parseInt(id);
		
		try {
			
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "delete from user where iduser='"+convId+"'";
			
			int r = stmt.executeUpdate(sql);
			
			if(r > 0) {
				return true;
			}else {
				return false;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public static boolean updateUser(String Cid,String name,String email,String password,String dob,String gender,String country){
		boolean isSuccess = false;
		
		int id = Integer.parseInt(Cid);
		
		try {
			
			con = DBConnection.getConnection();
			stmt = con.createStatement();
			
			String sql = "update user set Name='"+name+"', Email='"+email+"',Password='"+password+"',Gender='"+gender+"',Country='"+country+"' where iduser='"+id+"'";
			
            int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				
			    isSuccess = false;
			    
				}
			}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}
	

}
