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
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/interface/TeacherService.js"></script>
<title>文件管理</title>
</head>
<body>
<div>
	<button type="button" class="btn btn-info" id="tdsubmit" onclick="showUserForm();">添加老师</button>
</div> 
<div> 
<form>
	<table class="table table-striped">
		<thead>
			<th>账号:</th>
			<th>姓名:</th>
			<th>电话:</th>
			<th>邮箱:</th>
		</thead>
		<tbody id="trteacher">
		
		</tbody>
	</table>
</form>
</div>
</body>
	<script type="text/javascript">
	$(document).ready(function(){
		queryMenuList();
	//	alert((String)session.getAttribute("username"));
	})
		function queryMenuList(){
			
			var fileobj = new Object();
			var pageSize=100;
			var pageIndex=1;
			var orderName="teacher_name";
			var orderRule="desc";
			TeacherService.getTeacherListByPage(fileobj,pageSize,pageIndex,orderName,orderRule,function(msg){
				var trFile;			
				for(i=0;i<msg.length;i++){
					var teacher=msg[i];
                   trFile+=('<tr><td>'+teacher.teacher_number+'</td>');
                   trFile+=('<td>'+teacher.teacher_name+'</td>');
                   trFile+=('<td>'+teacher.teacher_phone+'</td>');
                   trFile+=('<td>'+teacher.teacher_email+'</td>');
                   trFile+=('</tr>'); 
					$("#trteacher").html(trFile);
				//	alert(trFile);	           	
				}
				
			})
			
		}
	function showUserForm(){
		document.location="http://127.0.0.1:8080/File_Manage/jsp/Teacher/AddTeacher.jsp";
	}
	</script>
</html>