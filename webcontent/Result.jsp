<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String msg=(String)(request.getAttribute("msg")); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=msg %></title>
</head>
<body>
<%=msg %>
<a href="Index.jsp">トップへ戻る</a>
</body>
</html>