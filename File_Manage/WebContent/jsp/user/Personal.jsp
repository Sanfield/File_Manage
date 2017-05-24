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
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/interface/StudentService.js"></script>
<title>个人中心</title>
</head>
<body>
<div align="center" style="width: 35%" class="container">
	<form >
		<table class="table table-hover">
			<thead><h2>个人信息</h2></thead>
			<tbody id ="message">
			
			</tbody>
		</table>
	</form>
</div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	getmessage();
	//$("#tdsubmit").on("click",updateStudent);
	})
function getmessage(){
	
		var user_id="<%=session.getAttribute("username")%>";
		var trStudent;
		//alert(user_id);
		StudentService.getStudentById(user_id,function(msg){
		//	alert(msg);
			trStudent +=('<tr><td>账号:</td><td><input type="text" value="'+msg.result+'"readonly= "true" id="number"></td></tr>');
			trStudent +=('<tr><td>姓名:</td><td><input type="text" value="'+msg.student_name+'" id="name"></td></tr>');
			trStudent +=('<tr><td>邮箱:</td><td><input type="text" value="'+msg.student_email+'" id="email"></td></tr>');
			trStudent +=('<tr><td>密码:</td><td><input type="text" value="'+msg.student_password+'" id="password"></td></tr>');
			trStudent +=('<tr><td>联系方式:</td><td><input type="text" value="'+msg.student_phone+'" id="phone"></td></tr>');
			trStudent +=('<tr><td align="center" colspan="2"><input class="btn btn_lg btn-primary" type="button" value="保存" id="tdsubmit" onclick="updateStudent()"/></td></tr>');
		//	alert(trStudent);
			$("#message").html(trStudent);
		})
	
}
function updateStudent(){
	student= new Object();
	student.student_number=$("#number").val();
	student.student_name=$("#name").val();
	student.student_email=$("#email").val();
	student.student_password=$("#password").val();
	student.student_phone=$("#phone").val();
	StudentService.updateStudent(student,function(msg){
		if((msg.result)>0){
			alert("操作成功");
		}
	})
	
}
	
</script>
</html>