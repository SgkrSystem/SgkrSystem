<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,jp.co.sgkr.bean.Product,jp.co.sgkr.bean.Category,jp.co.sgkr.dao.*"%>
    <%@page import="java.util.ArrayList,jp.co.sgkr.bean.Product,jp.co.sgkr.bean.Category,jp.co.sgkr.dao.Dao"%>
    <%
    Dao dao= new Dao("tstdsv03", "orcl1", "ora121", "ora121");
    
    ArrayList<Product> products = dao.SelectP();
    ArrayList<Category> category = dao.SelectC();
    
    %>
<!doctype html>
<html lang="ja">
<head>
<meta charset="utf-8">
<title>sgkr_likeら～めん</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="copyright" content="Template Party">
<meta name="description" content="ここにサイト説明を入れます">
<meta name="keywords" content="キーワード１,キーワード２,キーワード３,キーワード４,キーワード５">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="css/top.css">
<link rel="stylesheet" href="css/navi.css">
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
<ul id="all">
<li class="dropmenu"><a href="index.html">CATEGORY</a>
  <ul class="hide">
  <%
  for(Category c: category ){
	  %>
    <li class="hideli"><%=c.getC_name() %></li>
    <%}%>
  </ul>
</li>
<li class="nonflip"><a href="IndividualRegist.html">個人向け新規登録</a></li>
<li class="nonflip"><a href="CorporationRejist.html">法人向け新規登録</a></li>
<li class="search">
  <form id="searchbox" action="" method="get">
    <input id="searchwd" type="text" name="searchwd"><input id="searchbtn" type="image" name="search" alt="検索" src="images/searchbtn.png">
  </form>
</li>
<li class="dropmenu"><a href="contact.html">LOGIN</a>
  <ul class="hide">
    <li>
      <form action="LoginServlet" method="post">
        <table>
          <tr><td>
            <p>ID<input class="login" type="text" name="id"></p>
          </td><td>
            <input type="checkbox" name="rem" value="1" checked="checked">remember
          </td></tr>
          <tr><td>
            <p>PASS<input class="login" type="password" name="passwd"></p>
          </td><td id="button">
            <input type="submit" value="IN">
          </td></tr>
        </table>
      </form>
    </li>
  </ul>
</li>
</nav>

<div id="contents">

<div id="main">

<aside id="mainimg">
<img class="slide_file" src="images/1.jpg" title="index.html">
<img class="slide_file" src="images/2.jpg" title="index.html">
<img class="slide_file" src="images/3.jpg" title="index.html">
<input type="hidden" id="slide_loop" value="0">
<a href="index.html" id="slide_link">
<img id="slide_image" src="images/1.jpg" alt="">
<img id="slide_image2" src="images/1.jpg" alt=""></a>
</aside>

<section>

    <section id="rec_list">
      <h3>おすすめ商品</h3>
      <%for(Product p:products){%>
        <section class="list">
          <a href="<%=p.getImg_url() %>" data-lightbox="group0" data-title="<%=p.getP_name() %>">
          <figure><img src="<%="shouhin_img/"+p.getImg_url() %>" alt=""></figure>
          <h4>商品名:「<%=p.getP_name() %>」</h4>
          </a>
          <div class="des1">
            <h6>メーカー:<%=p.getM_name() %></h6>
            <form action="CartServlet" method="post">
            <input type="image" class="buybtn" src="design_img/buy01.jpg" value="<%=p.getP_id() %>"  name="ID" alt="">
            <input type="hidden"  value="<%=p.getP_name() %>"  name="P_NAME" alt="">
            <input type="hidden"  value="1"  name="P_QUA" alt="">
            <input type="hidden" value="<%=p.getU_price() %>"  name="PRICE" alt="">
            </form>
          </div>
          <div class="des2">
            <h5>価格:￥<%=p.getU_price() %></h5>
            <p><%=p.getP_detail() %></p>
          </div>
        </section>
        <%} %>
<form action="SyouhinServlet" method="GET"><input type="submit" value="商品をもっと見る"></form>
    <section>
    <h3>おすすめブランド</h3>
      <section id="brand">
        <table>
        <td>
          <tr>

          </tr>
        </td>
      </table>
      </section>
</section>

<section id="new">
<h2 id="newinfo_hdr" class="close">更新情報・お知らせ</h2>
<dl id="newinfo">
<dt>2015/00/00</dt>
<dd>ホームページリニューアル<span class="newicon">NEW</span></dd>
<dt>2015/00/00</dt>
<dd>ホームページリニューアル</dd>
<dt>2015/00/00</dt>
<dd>ホームページリニューアル</dd>
<dt>2015/00/00</dt>
<dd>ホームページリニューアル</dd>
<dt>2015/00/00</dt>
<dd>ホームページリニューアル</dd>
<dt>2015/00/00</dt>
<dd>ホームページリニューアル</dd>
<dt>2015/00/00</dt>
<dd>ホームページリニューアル</dd>
</dl>
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

<!--スライドショースクリプト-->
<script type="text/javascript" src="js/slide_simple_pack.js"></script>

<!--スマホ用更新情報-->
<script type="text/javascript">
if (OCwindowWidth() < 480) {
    open_close("newinfo_hdr", "newinfo");
}
</script>

</body>
</html>
