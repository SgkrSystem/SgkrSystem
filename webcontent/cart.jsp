<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,jp.co.sgkr.bean.Cart,jp.co.sgkr.dao.*"%>
    
    <%
    ArrayList<Cart> cart = (ArrayList<Cart>)session.getAttribute("cart");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>カート</title>
</head>
<body>


	<table border = 1>
	<%for(Cart c:cart){%>
	<tr><th>ID</th><th>商品名</th><th>値段</th><th>購入数</th><th>削除</th></tr>
	<tr><td><%=c.getP_id() %></td><td><%=c.getP_name() %></td><td><%=c.getU_price() %></td><td><%=c.getP_quantity() %></td><td><form action="CartDeleteServlet"><input type = "hidden" value = "<%=c.getP_id() %>" name = "p_id"/><input type = "submit" name = "カートから削除"/></form></td></tr>
	<%} %>
	</table>
</body>
</html>