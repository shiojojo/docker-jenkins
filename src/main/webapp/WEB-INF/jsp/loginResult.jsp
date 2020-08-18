<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.sample.model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<html>
<body>
<% if(loginUser != null { %>
<h2>ログイン成功</h2>
<p><%= loginUser.getName() %></p>
<form action="/docker-jenkins/Logout" method="get">
<input type="submit" value="ログアウト">
<% } else { %>
<h2>ログイン失敗</h2>
<form action="/docker-jenkins/" method="get">
<input type="submit" value="TOPへ">
<% } %>

</form>
</body>
</html>
