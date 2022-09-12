package com.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;


public class VoterServlet extends HttpServlet{
	
	
//	@Override
//	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		
//		System.out.println("voterservlet doGet or doPost anything will execute");
//		PrintWriter pw = res.getWriter();
//		
//		res.setContentType("text/html");
//		
//		String name = req.getParameter("pname");
//		String tage = req.getParameter("page");
//		
//		int age=Integer.parseInt(tage);
//		
//		if(age>=18) {
//			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name +" "+ "you r eligible for voting</h1>");
//		}
//		else {
//			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name +" "+"you r not eligible for voting</h1>");
//			
//		}
//		
//		pw.println("<a href ='http://localhost:3031/VoterApp/details_form.html'><img src='images/home.jpg' width='100' height='200'></a> ");;
//		pw.close();
//		
//	
//
//	}
	
	@Override
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		
		System.out.println("voterservlet doGet");
		PrintWriter pw = res.getWriter();
		
		res.setContentType("text/html");
		
		String name = req.getParameter("pname");
		String tage = req.getParameter("page");
		
		int age=Integer.parseInt(tage);
		
		if(age>=18) {
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name +" "+ "you r eligible for voting</h1>");
		}
		else {
			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name +" "+"you r not eligible for voting</h1>");
			
		}
		
		pw.println("<a href ='http://localhost:3031/VoterApp/details_form.html'><img src='images/home.jpg' width='100' height='200'></a> ");;
		pw.close();
		
	}

//	@Override
//	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		System.out.println("voterservlet : doPost ");
//		doGet(req,res);
//		
//	
		
//		PrintWriter pw = res.getWriter();
//		
//		res.setContentType("text/html");
//		
//		String name = req.getParameter("pname");
//		String tage = req.getParameter("page");
//		
//		int age=Integer.parseInt(tage);
//		
//		if(age>=18) {
//			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name +" "+ "you r eligible for voting</h1>");
//		}
//		else {
//			pw.println("<h1 style='color:green;text-align:center'>Mr/Miss/Mrs."+name +" "+"you r not eligible for voting</h1>");
//			
//		}
//		
//		pw.println("<a href ='http://localhost:3031/VoterApp/details_form.html'><img src='images/home.jpg' width='100' height='200'></a> ");
//		pw.close();
//		
		}
	
	
	


