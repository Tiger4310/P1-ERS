package com.ERS.Controler;

import io.javalin.http.Handler;
import com.ERS.model.Reimbursement;
import com.ERS.model.User;
import com.ERS.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ReimbursementController {
static int approveDenyId = 0;
	
	public static Handler reimbursementController = ctx->{
		ctx.result("from Reimbursement controller");
	};
	
	public static Handler getAllReimbursement = ctx -> {
		 ArrayList<User> users=new ArrayList<>();
	     Connection  conn=ConnectionUtil.getConnection();
	       PreparedStatement pstmt=conn.prepareStatement("select * from Reimbursement");
	       ResultSet rs=pstmt.executeQuery();
	       while(rs.next()) {
	    	   User user=new User(rs.getString(1), rs.getString(2),
	    			   rs.getString(3),rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
	    	   users.add(user);  
	       }
	       ctx.json(users);
	};
	    
	    
    public static Handler addReimbursement = ctx -> {
    	Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        String submit_time1 = formatter.format(date);
    
    	
    	Connection conn=ConnectionUtil.getConnection();
    	
		try {
			PreparedStatement pstmt=conn.prepareStatement(
					"insert into Reimbursement(author_id, resolver_id, type, amount, description, submit_time, resolve_time, status, accepted) values (?,?,?,?,?,?,?,?,?)");
			
			int author_id= EmployeeController.author;
			int resolver_id= 0;
			String type=ctx.formParam("type");
			String amount=ctx.formParam("amount");
			String description=ctx.formParam("description");
			String submit_time=submit_time1;
			String resolve_time="      --------  ";
			String status= "pending";
			String accepted="      --------  ";
			

			pstmt.setInt(1, author_id);
			pstmt.setInt(2, resolver_id);
			pstmt.setString(3, type);
			pstmt.setString(4, amount);
			pstmt.setString(5, description);
			pstmt.setString(6, submit_time);
			pstmt.setString(7, resolve_time);
			pstmt.setString(8, status);
			pstmt.setString(9, accepted);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ctx.redirect("/employeeHome.html");
			
    };
    
    public static Handler getAllEmployeeReimbursement = ctx -> {
		 ArrayList<Reimbursement> reimbursements=new ArrayList<>();
	     Connection  conn=ConnectionUtil.getConnection();
	       PreparedStatement pstmt=conn.prepareStatement("select * from Reimbursement");
	       ResultSet rs=pstmt.executeQuery();
	       while(rs.next()) {
	    	  
	    	   Reimbursement r=new Reimbursement(rs.getInt("id"), rs.getInt("author_id"), rs.getInt("resolver_id"), rs.getString("type"),
	    			   rs.getString("amount"), rs.getString("description"), rs.getString("submit_time"),  rs.getString("resolve_time"),rs.getString("status"), rs.getString("accepted"));

	    	
	    	   reimbursements.add(r);  
	       }
	       ctx.json(reimbursements);
    };
	
    
    
    public static Handler getOneEmployeeReimbursement = ctx -> {
		 ArrayList<Reimbursement> reimbursements=new ArrayList<>();
		 Connection  conn=ConnectionUtil.getConnection();
	       PreparedStatement pstmt=conn.prepareStatement("select * from Reimbursement where author_id=? ");
	       pstmt.setInt(1, EmployeeController.author);
	       ResultSet rs=pstmt.executeQuery();
	       while(rs.next()) {
	    	   System.out.println("getEmployeeReimbursement "+ rs + "\n");
	    	   
	    	   Reimbursement r=new Reimbursement(rs.getInt("id"), rs.getInt("author_id"), rs.getInt("resolver_id"), rs.getString("type"),
	    			   rs.getString("amount"), rs.getString("description"), rs.getString("submit_time"),  rs.getString("resolve_time"),rs.getString("status"), rs.getString("accepted"));

	    	   System.out.println("r "+ r);
	    	   System.out.println("accepted "+ rs.getString("accepted") + "\n");
	    	   
	    	   reimbursements.add(r);  
	    	   
	       }
	       ctx.json(reimbursements);
    };
		    
		    
	public static Handler getPendingReimbursement = ctx -> {
		 ArrayList<Reimbursement> reimbursements=new ArrayList<>();
		 Connection  conn=ConnectionUtil.getConnection();
	       PreparedStatement pstmt=conn.prepareStatement("select * from Reimbursement where status=? ");
	       
	       pstmt.setString(1, "pending");
	       ResultSet rs=pstmt.executeQuery();
	       while(rs.next()) {
	    	   
	    	   Reimbursement r=new Reimbursement(rs.getInt("id"), rs.getInt("author_id"), rs.getInt("resolver_id"), rs.getString("type"),
	    			   rs.getString("amount"), rs.getString("description"), rs.getString("submit_time"),  rs.getString("resolve_time"),rs.getString("status"), rs.getString("accepted"));

	    	   reimbursements.add(r);  
	       }
	       ctx.json(reimbursements);
	};
			    
	public static Handler getResolvedReimbursement = ctx -> {
		 ArrayList<Reimbursement> reimbursements=new ArrayList<>();
		 Connection  conn=ConnectionUtil.getConnection();
	       PreparedStatement pstmt=conn.prepareStatement("select * from Reimbursement where status=? ");
	       pstmt.setString(1, "resolved");
	     
	       ResultSet rs=pstmt.executeQuery();
	       while(rs.next()) {
	    	   
	    	   Reimbursement r=new Reimbursement(rs.getInt("id"), rs.getInt("author_id"), rs.getInt("resolver_id"), rs.getString("type"),
	    			   rs.getString("amount"), rs.getString("description"), rs.getString("submit_time"),  rs.getString("resolve_time"),rs.getString("status"), rs.getString("accepted"));
	
	    	
	    	   reimbursements.add(r);  
	       }
	       ctx.json(reimbursements);
	};
	       
	
	public static Handler selectReimbursement = ctx -> {
		int id = 0;
		 ArrayList<Reimbursement> reimbursements=new ArrayList<>();
		 Connection  conn=ConnectionUtil.getConnection();
	      PreparedStatement pstmt=conn.prepareStatement("select * from Reimbursement where id=? ");
	       
	       if((ctx.formParam("id") != null)){
	    	   approveDenyId =Integer.parseInt(ctx.formParam("id")); 
	       }
	      
	       pstmt.setInt(1, approveDenyId);
	       ResultSet rs=pstmt.executeQuery();
	       while(rs.next()) {
	    	 
	    	   Reimbursement r=new Reimbursement(rs.getInt("id"), rs.getInt("author_id"), rs.getInt("resolver_id"), rs.getString("type"),
	    			   rs.getString("amount"), rs.getString("description"), rs.getString("submit_time"),  rs.getString("resolve_time"),rs.getString("status"), rs.getString("accepted"));
	
	    	  
	    	   reimbursements.add(r);  
	       }
	       
	       ctx.json(reimbursements);
	       
	       System.out.println("approveDenyId: "+ approveDenyId + "\n");
	       
	       if((ctx.formParam("id") != null)){
	    	   ctx.redirect("/approveDeny.html");
	    	   
	       }
	 
	};
	
	
	public static Handler approveDeny = ctx -> {
		
		Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        String resolve_time = formatter.format(date);
        String accepted= "";
        
        Connection  conn=ConnectionUtil.getConnection();
	   PreparedStatement pstmt=conn.prepareStatement("update Reimbursement set status=?, resolve_time=?, accepted=? where status=? and id=?");
	      
	    String status = ctx.formParam("status");
	    if(status.equals("approved")) {
	    	accepted = "yes";
	    }else {
	    	accepted = "no";
	    }
	    pstmt.setString(1, status);
	    pstmt.setString(2, resolve_time);
	    pstmt.setString(3, accepted);
	 	pstmt.setString(4, "pending");
	 	pstmt.setInt(5, approveDenyId);
	 	    
	 	pstmt.executeUpdate();
	 	ctx.redirect("/approveDeny.html");
	  
    };
				    
	public static Handler getName = ctx -> {
		ctx.json(EmployeeController.employeeName);
		ctx.redirect("/pastTickets.html");
	};
}


