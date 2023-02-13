package com.madhu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
static {
	System.out.println("Test servlet.class file is loading....");
}
public TestServlet() {
	System.out.println("Test servlet object id Instantiated....");
}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		out.println("<html><head><title>Output</title></head></html>");
		out.println("<body>");
		out.println("<center>");
		out.println("<h1 style='color:green;'>Context paramter information</h1>");
		out.println("<table>");
		out.println("<tr><th>Context parameter name</th><th>Context parameter value</th></tr>");
		
		ServletContext context=getServletContext();
		Enumeration<String> parameterNames=context.getInitParameterNames();
		while (parameterNames.hasMoreElements()) {
			String parameterName = (String) parameterNames.nextElement();
			String parameterValue=context.getInitParameter(parameterName);
			out.println("<tr><td>"+parameterName+"</td><td>"+parameterValue+"</td></tr>");
			
		}
		
		
		out.println("</table>");
		out.println("</center>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

}
