package com.ERS.main;

import com.ERS.Controler.EmployeeController;
import com.ERS.Controler.ReimbursementController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class Main {
	public static void main(String[] args) {
		
		 Javalin app = Javalin.create(ctx->{
		     	ctx.enableCorsForAllOrigins();
		     	ctx.addStaticFiles("web", Location.CLASSPATH);
		     }).start(7000);
		 
	       //adding employee
		 
		 app.post("/employee", EmployeeController.addEmployee);
		 app.get("/employee", EmployeeController.getAllUsers);
		 
		 
		app.post("/login", EmployeeController.employeeLogin);
		app.post("/newReimbursement", ReimbursementController.addReimbursement);
		
		app.get("/oneReimbursement", ReimbursementController.getOneEmployeeReimbursement);
		
		app.get("/reimbursement", ReimbursementController.getAllEmployeeReimbursement);
		
		app.get("/getPendingReimbursement", ReimbursementController.getPendingReimbursement);
		app.get("/getResolvedReimbursement", ReimbursementController.getResolvedReimbursement);
		
		
		
		app.post("/selectReimbursement", ReimbursementController.selectReimbursement);
		app.get("/selectReimbursement", ReimbursementController.selectReimbursement);
		
		app.post("/approveDeny", ReimbursementController.approveDeny);

}
}