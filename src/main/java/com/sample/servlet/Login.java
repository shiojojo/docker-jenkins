package com.sample.servlet;

import com.sample.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Login")
public class Login extends HttpServlet {
        private static final long serialVersionUID = 1L;
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            request.setCharacterEncoding("utf-8");
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");

            User user = (User) new User(name, pass);

            HttpSession session = request.getSession();

            session.setAttribute("loginUser", user);




            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
            dispatcher.forward(request, response);
        }
    }

