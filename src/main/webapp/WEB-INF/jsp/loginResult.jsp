<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ import com.sample.model.User; %>
<%@ request.getAttribute("loginUser", loginUser); %>
<html>
<body>
<h2>ログイン成功</h2>
<p><%= loginUser.getName() %></p>
<form action="docker-jenkins/login" method="post"></form>
<input type="submit" value="ログイン">
</body>
</html>
