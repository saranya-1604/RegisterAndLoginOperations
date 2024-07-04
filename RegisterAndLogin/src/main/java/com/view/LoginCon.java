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
import javax.servlet.http.HttpSession;

@WebServlet("/LoginCont")
public class LoginCon extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        List<String> errors = new ArrayList<>();

        if (email.isEmpty()) {
            errors.add("Please add a valid email");
        }
        if (password.length() < 6) {
            errors.add("Password must be of 6 or more character length");
        }
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            RequestDispatcher rd = request.getRequestDispatcher("/LoginForm");
            rd.forward(request, response);
            return;
        }

        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByEmailAndPassword(email, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect("Profile");
        } else {
            request.setAttribute("errorMessage", "Invalid email or password. Please create an account first.");
            RequestDispatcher rd = request.getRequestDispatcher("/RegisterForm");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
