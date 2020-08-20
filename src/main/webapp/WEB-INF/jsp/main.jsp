<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="com.sample.model.User" %>
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

</body>
</html>
