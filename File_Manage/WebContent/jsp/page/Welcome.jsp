<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body>
	<div  style="height: 20%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div> 
	<div class="page-header">
   <h1>"互联网+"工作室
      <small>文档管理系统</small>
   </h1>
</div>
	<marquee direction="left" scrollamount="5" scrolldelay="5" id="scroll">
		<p class="txt" style="font-size: 4; color: #FFFFFF">
			<font class="txt" style="font-size: 4; color: black;">公告◄)：
			请同学们按要求使用文件，共同维护我们的工作室。&nbsp;&nbsp;</font>
		</p>
	</marquee>
<div id="myCarousel" class="carousel slide">
<ol class="carousel-indicators">
<li data-target="#myCarousel" data-slide-to="0" class="active">
<li data-target="#myCarousel" data-slide-to="1">
<li data-target="#myCarousel" data-slide-to="2">
</ol>
<div class="carousel-inner">
<div class="item active">
<img src="http://127.0.0.1:8080/File_Manage/Image/4.jpg" alt="First slide" style="width:100%">
</div>
<div class="item">
<img src="http://127.0.0.1:8080/File_Manage/Image/6.jpg" alt="Second slide" style="width:100%">
</div>
<div class="item">
<img src="http://127.0.0.1:8080/File_Manage/Image/7.jpg" alt="Third slide" style="width:100%">
</div>
</div>
<a class="carousel-control left" href="/demo/bootstrap3-plugin-carousal-simple.htm#myCarousel" data-slide="prev">‹</a>
<a class="carousel-control right" href="/demo/bootstrap3-plugin-carousal-simple.htm#myCarousel" data-slide="next">›</a>
</div>
	<div  style="height: 20%">
		<jsp:include page="../part/tail.jsp"></jsp:include>
	</div> 
</body>
</html>