<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  src="<%=request.getContextPath() %>/jquery/jquery.js"></script>
<script  src="<%=request.getContextPath()%>/bootstrap3.3.7/js/bootstrap.js"></script>
<link href="<%=request.getContextPath()%>/bootstrap3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/engine.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/util.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/interface/ManagerService.js"></script>
<title>Insert title here</title>
</head>
<body>
<div align="center" style="width: 40%" class="container">
	<form>
		<table  class="table table-striped">
			<thead><h2>添加管理员</h2></thead>
			<tbody>
				<tr><td>账号:</td><td><input type="text" id="number"/></td><td></td></tr>
				<tr><td>密码:</td><td><input type="password" id="password1"/></td><td id="password_alert"></td></tr>
				<tr><td>确认密码:</td><td><input type="password" id="password2"/></td><td></td></tr>
				<tr><td colspan="2"><input class="btn btn-primary btn-lg btn-block" type="button" id="submit" value="添加"/></td></tr>
			</tbody>
		</table>
	</form>
</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
//	check();
$("#submit").bind("click",insertManager);
/**
*校验密码长度
*/
$("#password1").blur(function(){
	$("#password_alert").remove();
	if(($("#password1").val().length)<6){
		$("#password1").after("<font color='red' id='password_alert'>密码长度不能小于6</font>");
		$("#password1").focus();
	}
})

/**
*校验密码两次是否一致
*/
$("#password2").blur(function(){
	$("#password2_alert").remove();
	if($("#password2").val() != $("#password1").val()){
		$("#password2").after("<font color='red' id='password2_alert'>两次密码不一致</font>");
		//$("#spassword2").focus();
	}
})
$("#number").blur(function(){
		$("#number_alert").remove();
		var  user_id = $("#number").val().trim();
		if(user_id=="") return;
		$("#number").after("");
		ManagerService.getManagerById(user_id,function(data){
			if(data.result== undefined){
			$("#number").after("<font color='green' id='number_alert'>恭喜你，此账号可用</font>");
			}else{
				$("#number").after("<font color='red' id='number_alert'>此账号已经被注册</font>");
				$("#number").focus();
			}
		})
	})
})
function insertManager(){
		alert("haha");
		manager= new Object();
		manager.manager_number=$("#number").val();
		manager.manager_password=$("#password1").val();
		
		ManagerService.register(manager,function(msg){
			if(msg.result>0){
			//	alert("操作成功");
				document.location="Managers.jsp";
			}
		})
	}
</script>
</html>