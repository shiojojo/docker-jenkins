package com.sample.servlet;

import com.sample.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login extends HttpServlet {
        private static final long serialVersionUID = 1L;
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            request.setCharacterEncoding("utf-8");
            String name = request.getParameter("name");
            String pass = request.getParameter("pass");

            User loginUser = (User) new User(name, pass);

            request.setAttribute("loginUser", loginUser);


            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
            dispatcher.forward(request, response);
        }
    }
