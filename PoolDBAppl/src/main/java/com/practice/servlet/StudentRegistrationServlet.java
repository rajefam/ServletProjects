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
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
			   
			   if(result == 0) {
				   pw.println("<h1>Problem in student registration</h1>");
			   }
			   else {
				   pw.println("<h1>Student registration successfully</h1>");
			   }
			   
			   
		   } catch (SQLException se) {
			// TODO Auto-generated catch block
			se.printStackTrace();
			pw.println("<h1>DB problem in student registration </h1>");
		}
		   catch(Exception e) {
			 e.printStackTrace();
			 pw.println("<h1>unknow problem in student registration </h1>");
			 
		   }
		   
		   pw.println("<a href='student_form.html'>Home</a>");
		   pw.close();
	   }
	   
	   public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		   
		   doGet(req,res);
	   }

	private Connection getPooledJdbcConnection()throws Exception {
		// TODO Auto-generated method stub
		
		InitialContext ic= new InitialContext();
		
		DataSource ds= (DataSource) ic.lookup("java:/comp/env/DsJndi");
		
		Connection con = ds.getConnection();
			
		return con;
	}

}
