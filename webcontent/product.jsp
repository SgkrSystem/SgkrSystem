<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,jp.co.sgkr.bean.Product,jp.co.sgkr.dao.*"%>
    <%
    ArrayList<Product> products = (ArrayList<Product>)request.getAttribute("products");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta charset="utf-8">
<title>SgkrSystem</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="copyright" content="Template Party">
<meta name="description" content="ここにサイト説明を入れます">
<meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">
<link rel="stylesheet" href="css/style.css">
<link href="css/lightbox.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script type="text/javascript" src="js/openclose.js"></script>
</head>

<body>

<div id="container">

<header>
<p id="logo"><a href="index.html"><img src="images/logo.png" width="304" height="48" alt="Photo Gallery"></a></p>
<h1><a href="index.html">h1テキスト入力場所です。<br>
titleタグの次に重要なので念入りに考えてワードを盛り込みましょう。</a></h1>
<aside id="header-img"><img src="images/header_img.png" alt=""></aside>
</header>

<nav id="menubar">
<ul>
<li><a href="index.html">HOME</a></li>
<li><a href="about.html">ABOUT</a></li>
<li><a href="gallery1.html">GALLERY1</a></li>
<li><a href="gallery2.html">GALLERY2</a></li>
<li><a href="link.html">LINK</a></li>
<li><a href="contact.html">CONTACT</a></li>
</ul>
</nav>

<div id="contents">

<div id="main">

<section>

<h2>商品詳細ページ</h2>

<%for(Product p:products){%>
        <section class="list">
        <figure><img src="<%=p.getImg_url() %>>" alt=""></figure>
        </section>
<br/> 
<section>
<table class="ta1">
<tr>
<th colspan="2" class="tamidashi">詳細</th>
</tr>
<tr>
<th>商品名</th>
<td><%=p.getP_name() %></td>
</tr>

<tr>
<th>値段</th>
<td><%=p.getU_price() %>円</td>
</tr>

<tr>
<th>カテゴリ名</th>
<td><%=p.getC_name() %></td>
</tr>

<tr>
<th>メーカー名</th>
<td><%=p.getM_name() %></td>
</tr>

<tr>
<th>説明</th>
<td><%=p.getP_detail() %></td>
</tr>

</table>		
		<form action="CartServlet.jsp" method="post">
			<input type="submit" value="カートに入れる">
			<input type="hidden" name="ID" value=<%=p.getP_id() %>>
		</form>
</section>
<%}%>
</section>

</div>
<!--/main-->

<p id="pagetop"><a href="#">↑ PAGE TOP</a></p>

</div>
<!--/contents-->

</div>
<!--/container-->

<footer>
<small>Copyright&copy; 2015 <a href="index.html">Photo Gallery</a> All Rights Reserved.</small>
<span class="pr"><a href="http://template-party.com/" target="_blank">Web Design:Template-Party</a></span>
</footer>

<!--スマホ用メニューバー-->
<img src="images/icon_bar.png" width="20" height="16" alt="" id="menubar_hdr" class="close">
<script type="text/javascript">
if (OCwindowWidth() < 480) {
	open_close("menubar_hdr", "menubar");
}
</script>

<script src="js/lightbox-plus-jquery.min.js"></script>
</body>
</html>