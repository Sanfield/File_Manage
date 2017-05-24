<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部</title>
<link href="<%=request.getContextPath()%>/css/ajax.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div style="height: 20%">
	<jsp:include page="../part/head.jsp"></jsp:include>
	</div>
<div style="height:20%;width:20%;float:left">
<div class="container">
    <div class="row">
        <div class="col-xs-3" id="myScrollspy">
            <ul class="nav nav-tabs nav-stacked" data-spy="affix" data-offset-top="125">
                <li class="active"><a href="#" onclick="reloadMain('/jsp/other/All.jsp');">全部</a></li>
                <li><a href="#" onclick="reloadMain('jsp/other/CFile.jsp');">C/C++</a></li>
                <li><a href="#" onclick="reloadMain('jsp/other/JavaFile.jsp');">Java</a></li>
                <li><a href="#" onclick="reloadMain('jsp/other/WebFile.jsp');">Web</a></li>
                <li><a href="#" onclick="reloadMain('jsp/other/PythonFile.jsp');">Python</a></li>                
                <li><a href="#" onclick="reloadMain('jsp/other/DsFile.jsp');">数据结构与算法</a></li>
            </ul>
        </div>
    </div>
</div>
	</div>
	<div style="width:80%;float:left" ><!-- 主页面展示页面 动态变化  -->
     <iframe id="mainFrame" src="<%=request.getContextPath()%>/jsp/other/All.jsp" frameborder="0" name="main" style="width:100%;height:500px;background-color:#ffffff" border="0"></iframe>
    </div>
    <script type="text/javascript">

		jQuery(document).ready(function() {    
		alert(session.getAttribute("username"));
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