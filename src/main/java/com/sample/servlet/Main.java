package com.sample.servlet;

import com.sample.model.LoginLogic;
import com.sample.model.Mutter;
import com.sample.model.User;
import org.jetbrains.annotations.NotNull;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");

        HttpSession session = request.getSession();
        session.getAttribute(loginUser);


        //      つぶやきリストをアプリケーションスコープから取得
        ServletContext application = this.getServletContext();
        List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");



        application.setAttribute("mutterList", mutterList);




        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
        dispatcher.forward(request, response);
    }
}
