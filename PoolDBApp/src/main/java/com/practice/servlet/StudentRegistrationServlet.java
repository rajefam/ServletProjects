package com.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.naming.InitialContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;



public class StudentRegistrationServlet extends HttpServlet {
	
private  static final String STUDENT_INSERT_QUERY="INSERT INTO STUDENT VALUES(SNO_SEQ.NEXTVAL,?,?,?)";

   public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	   
	   PrintWriter pw= res.getWriter();
	   
	   res.setContentType("text/html");
	   
	   String name = req.getParameter("sname");
	   String addrs = req.getParameter("sadd");
	   float avg = Float.parseFloat(req.getParameter("avg"));
	   
	   try(Connection con = getPooledJdbcConnection();
		PreparedStatement ps= con.prepareStatement(STUDENT_INSERT_QUERY);) {
		   ps.setString(1,name);
		   ps.setString(2, addrs);
		   ps.setFloat(3, avg);
		   
		   int result =ps.executeUpdate();
		   
		   if(result==0) {
			   pw.println("<h1 style='color:red;text-align:center'>Problem in student registration</h1>");
			   
		   }
		   else {
			   pw.println("<h1 style='color:red;text-align:center'>student registered sucessfully</h1>");
		   }
	   
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
		pw.println("<h1 style='color:red;text-align:center'>DBProblem in student registration</h1>");
	   
	   }
	   
	   catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		pw.println("<h1 style='color:red;text-align:center'>Unknown Problem in student registration</h1>");
	}
	    
	  pw.println("<br><a href='Student_form.html'>home</a>");
	  pw.close();
	  
   }
   
   public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
	   
	   doGet(req,res);
   }
    
   //helper method
 private Connection getPooledJdbcConnection()throws Exception {
	
	 InitialContext ic= new InitialContext();
	 
	 DataSource ds= (DataSource)ic.lookup("java:/comp/env/DsJndi");//only in tomcat server we need to add java:/comp/env prefix for jndi registry
	 
	Connection con = ds.getConnection();
	
	return con; 
	 
	 
 }

}
