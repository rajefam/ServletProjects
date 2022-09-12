package com.nt.servlet;

import jakarta.servlet.*;
import java.io.*;
import java.util.*;

public class DateServlet extends GenericServlet{

public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException{

PrintWriter pw = res.getWriter();

res.setContentType("text/html");

Date dt=  new Date();

pw.println("<h1 style=color:red;text-align:center>"+dt+"</h1>");

pw.println("<br><b> req obj hash code : "+req.hashCode()+"</b>");
pw.println("<br><b> res obj hash code : "+res.hashCode()+"</b>");
pw.println("<br><b> Our Servlet class obj hash code : "+this.hashCode()+"</b>");
pw.println("<br><b> current req - thread hash code : "+Thread.currentThread().hashCode()+"</b>");



pw.close();
}
}