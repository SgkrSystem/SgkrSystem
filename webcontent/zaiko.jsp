<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,jp.co.sgkr.bean.Product,jp.co.sgkr.bean.Category,jp.co.sgkr.bean.Maker,jp.co.sgkr.dao.*"%>
    <%
    ArrayList<Product> products = (ArrayList<Product>)request.getAttribute("products");
    ArrayList<Category> categories = (ArrayList<Category>)request.getAttribute("categories");
    ArrayList<Maker> makers = (ArrayList<Maker>)request.getAttribute("makers");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在庫管理・商品情報編集</title>
</head>
<body>
<%if(request.getHeader("Referer").split("/")[request.getHeader("Referer").split("/").length - 1].equals("ZaikoServlet")||
		request.getHeader("Referer").split("/")[request.getHeader("Referer").split("/").length - 1].equals("ZaikoUpdateServlet")){%>
<%="更新完了"%>
<%}%>
<form action="ZaikoUpdateServlet" method="post">
<input type="hidden" value="<%=products.get(0).getP_id()%>" name="P_id">
商品名:<input type="text" value="<%=products.get(0).getP_name()%>" name="P_name"><br/>
価格:<input type="text" value="<%=products.get(0).getU_price()%>" name="U_price"><br/>
カテゴリ名：<select name="C_id">
<% for(Category c : categories){%>
<option value="<%=c.getC_id() %>" <%if(c.getC_id()==products.get(0).getC_id()){%><%="selected"%><%} %>><%=c.getC_name() %></option>
<%} %>
</select>
メーカー名：<select name="M_id">
<% for(Maker m : makers){%>
<option value="<%=m.getM_id() %>" <%if(m.getM_id()==products.get(0).getM_id()){%><%="selected"%><%} %>><%=m.getM_name() %></option>
<%} %>
</select><br/>
買掛数量：<input type="text" value="<%=products.get(0).getBuy_q()%>" name="Buy_q"><br/>
売掛数量：<input type="text" value="<%=products.get(0).getSell_q()%>" name="Sell_q"><br/>
発注点：<input type="text" value="<%=products.get(0).getOrder_point()%>" name="Order_point"><br/>
在庫数量:<input type="text" value="<%=products.get(0).getStock()%>" name="Stock"><br/>
<input type="submit" value="商品情報更新">
</form>
<a href="sgkradmin.jsp">戻る</a>
</body>
</html>