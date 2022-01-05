package com.ERS.Controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ERS.model.User;
import com.ERS.util.ConnectionUtil;

import io.javalin.http.Handler;

public class EmployeeController {
	static String employeeName ="";
	static int author = 0;
	
	public static Handler getAllUsers = ctx -> {
		 ArrayList<User> users=new ArrayList<>();
	     Connection  conn=ConnectionUtil.getConnection();
	       PreparedStatement pstmt=conn.prepareStatement("select * from employee");
	       ResultSet rs=pstmt.executeQuery();
	       while(rs.next()) {
	    	   User user=new User(rs.getString(1), rs.getString(2),
	    			   rs.getString(3),rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
	    	   users.add(user);  
	       }
	       ctx.json(users);
	};
	
	
	public static Handler getAllEmployee = ctx -> {
		ArrayList<User> users=new ArrayList<>();
		Connection  conn=ConnectionUtil.getConnection();
	       PreparedStatement pstmt=conn.prepareStatement("select * from employee where userrole=?");
	       pstmt.setString(1, ("employee"));
	       ResultSet rs=pstmt.executeQuery();
	       while(rs.next()) {
	    	   User user=new User(rs.getString(1), rs.getString(2),
	    			   rs.getString(3),rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
	    	   users.add(user);  
	       }
	       ctx.json(users);
	};
	
	    public static Handler addEmployee = ctx -> {
		 	
	    	Connection  conn=ConnectionUtil.getConnection();
	     
			try {
				PreparedStatement pstmt=conn.prepareStatement(
						
						
						"insert into employee(user_id, username, password, first_name, last_name, email, role_id) values (?,?,?,?,?,?,?)");
				String userid=ctx.formParam("user_id");
				String username=ctx.formParam("username");
				String password=ctx.formParam("password");
				String firstname=ctx.formParam("first_name");
				String lastname=ctx.formParam("last_name");
				String email=ctx.formParam("email");
				String userrole=ctx.formParam("role_id");
				
				
				pstmt.setString(1, userid);
				pstmt.setString(2, username);
				pstmt.setString(3, password);
				pstmt.setString(4, firstname);
				pstmt.setString(5, lastname);
				pstmt.setString(6, email);
				pstmt.setString(7, userrole);
				
				pstmt.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ctx.redirect("/displayAllEmployees.html");
	    };
	    
	    
	   
	    public static Handler employeeLogin = ctx -> {
	    	String name ="";
	    	String role ="";
	    	int id = 0;
	    	int author1=0;
	
	    	Connection  conn=ConnectionUtil.getConnection();
		       PreparedStatement pstmt=conn.prepareStatement("select * from employee where username=? and password=?");
		       pstmt.setString(1, ctx.formParam("username"));
		       pstmt.setString(2, ctx.formParam("password"));
		       ResultSet rs=pstmt.executeQuery();

		       
		       
		       while(rs.next()) {
		    	   name=rs.getString("first_name") + " "+rs.getString("last_name");
		    	   role=rs.getString("user_role");
		    	   author1=rs.getInt("user_id");
		    	   author=author1;
		    	   employeeName=name;
		       }
		      
		       
		       if((!(name.equals("")) && (author1 !=0 ))){
		    	   if(role.equals("employee")) {
				       ctx.json(name);
				       ctx.redirect("/employeeHome.html");
		    	   }
		    	   if(role.equals("manager")) {
		    		   
		    		   ctx.redirect("/managerHome.html");
		    	   }
		       }
		    };
}
