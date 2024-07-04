package com.view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Profile")
public class Profilelogin extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute("user");
            if (user != null) {
                response.getWriter().println("<html><body>");
                response.getWriter().println("<h1>User Profile</h1>");
                response.getWriter().println("<p>Name: " + user.getName() + "</p>");
                response.getWriter().println("<p>Age: " + user.getAge() + "</p>");
                response.getWriter().println("<p>Email: " + user.getEmail() + "</p>");
                response.getWriter().println("</body></html>");
                return;
            }
        }
        response.sendRedirect("LoginForm");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
