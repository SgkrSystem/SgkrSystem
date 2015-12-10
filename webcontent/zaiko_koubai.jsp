<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.ArrayList,jp.co.sgkr.bean.Product,jp.co.sgkr.dao.*"%>
    <%
    ArrayList<Product> products = (ArrayList<Product>)request.getAttribute("products");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>在庫管理・購買</title>
</head>
<body>
<form id="searchbox" action="SyouhinServlet" method="post">
    <input id="searchwd" type="text" name="searchwd"><input id="searchbtn" type="image" name="search" alt="検索" src="images/searchbtn.png">
  </form>
  <table style="border:solid 1px">
  <tr>
  <th>商品id</th>
  <th>商品名</th>
  <th>価格</th>
  <th>カテゴリ名</th>
  <th>メーカー名</th>
  <th>在庫管理</th>
  <th>購買</th>
  </tr>
<%for(Product p:products){%>
	<tr>
		<td><%=p.getP_id() %></td>
        <td><%=p.getP_name() %></td>
        <td><%=p.getU_price() %>円</td>
		<td><%=p.getC_name() %><br/></td>
		<td><%=p.getM_name() %><br/></td>
		<td><form action="ZaikoServlet"><input type="hidden" value="<%=p.getP_id() %>" name="P_id"></form></td>
		<td><form action="KoubaiServlet"><input type="hidden" value="<%=p.getP_id() %>" name="P_id"></form></td>
     </tr>
<%}%>
</table>
</body>
</html>