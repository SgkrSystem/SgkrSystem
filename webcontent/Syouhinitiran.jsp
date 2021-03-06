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
<link rel="stylesheet" href="css/styleshohin.css">
<link href="css/lightbox.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]-->
<script type="text/javascript" src="js/openclose.js"></script>
</head>

<body>

<div id="container">

<header>
<p id="logo"><a href="index.html"><img src="images/logo5.png" width="304" height="48" alt="Photo Gallery"></a></p>
<aside id="header-img"><img src="images/header_img1.png" alt=""></aside>
<h1><br><a href="index.html">すぐ★くる！<br>個人法人両方対応文房具販売サイト</a></h1>
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
<form id="searchbox" action="SyouhinServlet" method="post">
    <input id="searchwd" type="text" name="searchwd"><input id="searchbtn" type="image" name="search" alt="検索" src="images/searchbtn.png">
 </form>
<h2>検索結果 <%=products.size()%>件検索されました</h2>

	<h3 class="mb15">1ページ目</h3>
<%for(Product p:products){%>
		<form action="ProductServlet" method="post">
		<input type="hidden" name=ID value=<%=p.getP_id() %>>
        <section class="list">
        <img src="<%="shouhin_img/"+p.getImg_url() %>" alt="">
        <h4><%=p.getP_name() %></h4>
        <p>値段：<%=p.getU_price() %>円<br/>
		カテゴリ名：<%=p.getC_name() %><br/>
		メーカー名：<%=p.getM_name() %><br/>
        </p>
        <input type="submit" value="商品詳細">
        </section>
        </form>
<%}%>   
	<h3 class="mb15">1ページ目</h3>

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