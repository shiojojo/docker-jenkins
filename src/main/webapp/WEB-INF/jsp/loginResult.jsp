<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.sample.model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<html>
<body>
<h2>ログイン成功</h2>
<p><%= loginUser.getName() %></p>
<form action="/docker-jenkins/Logout" method="post">
<input type="submit" value="ログアウト">
</form>
</body>
</html>
