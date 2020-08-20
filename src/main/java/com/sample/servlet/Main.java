package com.sample.servlet;

import com.sample.model.LoginLogic;
import com.sample.model.Mutter;
import com.sample.model.PostMutterLogic;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Main")
public class Main extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        リクエストパラメータの取得
        request.setCharacterEncoding("UTF-8");
        String text = request.getParameter("text");

        //      つぶやきリストをアプリケーションスコープから取得
        ServletContext application = this.getServletContext();
        List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");

//        セッションを取得
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        if (text != null && text.length() != 0) {
            Mutter mutter = new Mutter(loginUser.getName(), text);
            PostMutterLogic postMutterLogic = new PostMutterLogic();
            postMutterLogic.execute(mutter, mutterList);
        } else {
            request.setAttribute("errorMsg", "つぶやきが入力されていません。");
        }

        application.setAttribute("mutterList", mutterList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //      つぶやきリストをアプリケーションスコープから取得
        ServletContext application = this.getServletContext();
        List<Mutter> mutterList = (List<Mutter>)application.getAttribute("mutterList");

        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");


//        つぶやきリスト新規作成
        if (mutterList == null) {
            mutterList = new ArrayList<>();
            application.setAttribute("mutterList", mutterList);
        }

        if(loginUser != null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/");
            dispatcher.forward(request, response);
        }
    }
}
