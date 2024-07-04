package com.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginForm")
public class LoginForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ServletConfig cnf=getServletConfig();
	String num=cnf.getInitParameter("num");
	
	ServletContext ctx=getServletContext();
	String str=ctx.getInitParameter("driver");
	PrintWriter out=response.getWriter();
	response.setContentType("text/html");
	List li= (List)request.getAttribute("errors");
	
	out.println("<html>");
	out.println("<body>");
	if(li!=null) {
		Iterator itr=li.iterator();
		out.println("<ul>");
		while(itr.hasNext()) {
			String err=(String)itr.next();
			out.println("<li>"+ err + "</li>");	
		}
		out.println("</ul>");
	}
	out.println("<center><h2> Login Form </h2>");
	out.println("<form action='LoginCont' method='post'>");
//	out.println("Name <input type='text' name='name'> <br> <br>");
//	out.println("Age <input type='text' name='age' value='0'> <br> <br>");
	out.println("Email<input type='text' name='email'> <br> <br>");
	out.println("Password<input type='password' name='password'> <br> <br>");
	out.println("<input type='submit' value='Login'>");
	out.println("</form> </center>");
	out.println("</body> </html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
