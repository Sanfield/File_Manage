<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
<style type="text/css">
	td{width:200px;height:30px}
</style>
<script type="text/javascript" >
	function CheckForm(){
		var userId = document.getElementById("userId").value;
		var password=document.getElementById("password").value;
		if(userId ==""){
			alert("账号不能为空");
			document.getElementById("userId").focus();
			return false;
		}
		if(password ==""){
			alert("密码不能为空");
			document.getElementById("password").focus();
			return false;
		}
		return true;
	}

</script>
</head>
<body>
	<div style="height: 20%">
	<jsp:include page="../part/head.jsp"></jsp:include>
	</div>
	<div align="center">
	<font color="red">
	${message }
	</font>
	</div>
	<div align="center" style="width: 56%" class="container">                            
    <form action= "<%=request.getContextPath() %>/LoginServlet" method="POST" >
	<table class="table table-hover">
		<tr><td colspan='2' rowspan='5'><img src="<%=request.getContextPath() %>/Image/Login.jpg" class="img-rounded"/></td><td colspan='2' align="center">"互联网+工作室"用户登录</td></tr>
		<tr><td align="center">登陆账号：</td><td align="center"><input type="text" id="userId" name="userId"></td></tr>
		<tr><td align="center">登陆密码：</td><td align="center"><input type="password" id="password" name="password"></td></tr>
		<tr><td align="center" colspan='2'>老师:<input type="radio" id="teacherridio" name="job" value="2">
							 学生:<input type="radio" id="studentridio"  name="job" value="1">
							管理员:<input type="radio" id="managerridio"  name="job" value="0"></td></tr>
		<tr><td colspan="2" align="center"><input  class="btn btn_lg btn-primary" type="submit" value="登陆">&nbsp;&nbsp;&nbsp;
		<input class="btn btn_lg btn-warning" type="reset" value="重置">
					&nbsp;&nbsp;&nbsp;</td></tr>
	</table>
	</form>
	</div>
</body>
</html>
