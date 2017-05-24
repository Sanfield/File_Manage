<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  src="<%=request.getContextPath() %>/jquery/jquery.js"></script>
<script  src="<%=request.getContextPath()%>/bootstrap3.3.7/js/bootstrap.js"></script>
<link href="<%=request.getContextPath()%>/bootstrap3.3.7/css/bootstrap.min.css" rel="stylesheet">
<title>后台管理</title>
<link href="<%=request.getContextPath()%>/css/ajax.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="page-header">
   <h1>"互联网+"工作室
      <small>文档管理系统(后台)</small>
   </h1>
</div>
<div style="height:20%;width:20%;float:left">
<div class="container">
    <div class="row">
        <div class="col-xs-3" id="myScrollspy">
            <ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="125">
                <li><a href="#" onclick="reloadMain('jsp/file/FileManage.jsp');">文件</a></li>
                <li><a href="#" onclick="reloadMain('jsp/student/StudentManage.jsp');">学生</a></li>
                <li><a href="#" onclick="reloadMain('jsp/Teacher/TeacherManage.jsp');">老师</a></li>
                <li><a href="#" onclick="reloadMain('jsp/Manager/Managers.jsp');">管理员</a></li>                
            </ul>
        </div>
    </div>
</div>
	</div>
	<div style="width:80%;float:left" ><!-- 主页面展示页面 动态变化  -->
     <iframe id="mainFrame" src="<%=request.getContextPath()%>/jsp/file/FileManage.jsp" frameborder="0" name="main" style="width:100%;height:500px;background-color:#ffffff" border="0"></iframe>
    </div>
    <script type="text/javascript">

		jQuery(document).ready(function() {    
//		alert(session.getAttribute("username"));
		});
		//重新加载Main区域的URL 
		function reloadMain(url){
			var mainIframe=document.getElementById('mainFrame');
			
			if(mainIframe){
				mainIframe.src="<%=request.getContextPath()%>/"+url;
			}
		}
	</script>
</body>
</html>