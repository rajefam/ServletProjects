package com.practice.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SeasonServlet extends HttpServlet {
	

public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{

res.setContentType("text/html");

PrintWriter pw = res.getWriter();

LocalDate ldt = LocalDate.now();//static factory method

int month = ldt.getMonthValue(); // gives between 1 - 12

if(month>=3 && month <=6) {
	
	pw.println("<h1 style='color:red;text-align:center'>Season name : Summer Season</h1>");
}
else if(month>=7 && month<=10) {
	pw.println("<h1 style='color:green;text-align:center'>Season name : Rainy Season</h1>");
}
else 
	pw.println("<h1 style='color:pink;text-align:center'>Season name : winter Season</h1>");


pw.println("<br> <a href='http://localhost:3030/SeasonApp/page.html'>home</a>");

pw.close();
}
}





