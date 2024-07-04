package com.view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.view.User;
//import com.view.UserDAO;

/**
 * Servlet implementation class FormController
 */
@WebServlet("/RegisterCon")
public class RegisterCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String name=request.getParameter("name").trim();
	String a=request.getParameter("age").trim();
	String email=request.getParameter("email").trim();
	String password=request.getParameter("password").trim();
	int age=0;
	age=Integer.parseInt(a);
	List list=new ArrayList();
	if(name.length()==0)
		list.add("Name field can't left blank.");
	if(age < 18)
		list.add("You are under age");
	if(email.length()== 0)
		list.add("Please add a valid email");
	if(password.length() < 6)
		list.add("Password must be of 6 or more charcater length");
	
	if(!list.isEmpty()) {
		request.setAttribute("errors", list);
		RequestDispatcher rd=request.getRequestDispatcher("/RegisterForm");
		rd.forward(request, response);
		return;
	}
	//store form data in DB
	User u=new User(name, age, email, password);
	UserDAO ud=new UserDAO();
	ud.saveData(u);
	request.setAttribute("nm", name);
	RequestDispatcher rd1=request.getRequestDispatcher("/Profile");
	rd1.forward(request, response);
	}

}
