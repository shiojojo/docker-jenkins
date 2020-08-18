<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.sample.model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<html>
<body>
<% if(loginUser != null) { %>
<h2>ログイン成功</h2>
<p><%= loginUser.getName() %></p>
<a href="/docker-jenkins/Main">投稿画面へ</a>
<% } else { %>
<h2>ログイン失敗</h2>
<a href="/docker-jenkins/">TOPへ</a>
<% } %>
</body>
</html>
