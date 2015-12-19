<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,jp.co.sgkr.bean.Cart,jp.co.sgkr.dao.*"%>
    
    <%
    ArrayList<Cart> cart = null;
    int total_amount=0;
    String product_id="";
    String product_qua="";
    if(session.getAttribute("Cart") != null){
        cart = (ArrayList<Cart>)session.getAttribute("Cart");
    }
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>カート</title>
</head>
<body>


	<table border = "1">
	<tr><th>ID</th><th>商品名</th><th>値段</th><th>購入数</th><th>削除</th></tr>
	<%for(Cart c:cart){
	total_amount=total_amount+c.getU_price();
	product_id +=","+String.valueOf(c.getP_id());
	product_qua +=","+String.valueOf(c.getP_quantity());%>
	<tr><td><%=c.getP_id() %></td><td><%=c.getP_name() %></td><td><%=c.getU_price() %></td><td><%=c.getP_quantity() %></td><td><form action="CartDeleteServlet" method="post"><input type = "hidden" value = "<%=c.getP_id() %>" name = "p_id"/><input type = "submit" value = "カートから削除"/></form></td></tr>
	<%}%>
	</table>
	<form action = "HistoryServlet" method="post">
	<input type="hidden"  name="product_id" value="<%=product_id %>"/>
	<input type="hidden"  name="product_qua" value="<%=product_qua %>"/>
	<input type="hidden" name="customer_id" value="<%=session.getAttribute("ID") %>"/>
	<input type="hidden" name="total_amount" value="<%=total_amount %>"/>
	<input type="submit" value="購入する"/>
	</form>
	<br/>
	<a href="Index.jsp">トップへ戻る</a>
</body>
</html>