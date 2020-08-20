<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.sample.model.User" %>
<%@ page import="com.sample.model.Mutter" %>
<%@ page import="java.util.List" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>
<%
List<Mutter> mutterList = (List<Mutter>) application.getAttribute("mutterList");
%>
<html>
<body>
<h2>投稿画面</h2>
<form action="/docker-jenkins/Main" method="post">
つぶやき：<input type="text" name="text"><br>
<input type="submit" value="投稿">
</form>
</body>
</html>
