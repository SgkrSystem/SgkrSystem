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
  <table style="border-collapse: collapse">
  <tr>
  <th style="border:solid 1px">商品id</th>
  <th style="border:solid 1px">商品名</th>
  <th style="border:solid 1px">価格</th>
  <th style="border:solid 1px">カテゴリ名</th>
  <th style="border:solid 1px">メーカー名</th>
  <th style="border:solid 1px">在庫数量</th>
  <th style="border:solid 1px">売掛数量</th>
  <th style="border:solid 1px">買掛数量</th>
  <th style="border:solid 1px">在庫管理</th>
  </tr>
<%for(Product p:products){%>
	<tr>
		<td style="border:solid 1px"><%=p.getP_id() %></td>
        <td style="border:solid 1px"><%=p.getP_name() %></td>
        <td style="border:solid 1px"><%=p.getU_price() %>円</td>
		<td style="border:solid 1px"><%=p.getC_name() %><br/></td>
		<td style="border:solid 1px"><%=p.getM_name() %><br/></td>
		<td style="border:solid 1px"><%=p.getStock() %><br/></td>
		<td style="border:solid 1px"><%=p.getBuy_q() %><br/></td>
		<td style="border:solid 1px"><%=p.getSell_q() %><br/></td>
		<td style="border:solid 1px"><form action="ZaikoServlet" method="post"><input type="hidden" value="<%=p.getP_id() %>" name="P_id"><input type="submit" value="商品詳細確認・変更"></form></td>
     </tr>
<%}%>
</table>
</body>
</html>