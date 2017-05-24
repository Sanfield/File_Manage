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
<title>文件管理</title>
</head>
<body>
<div>
	<button type="button" class="btn btn-info" id="tdsubmit" onclick="showUserForm();">添加学生</button>
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
		<tbody id="trStudent">
		
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
			var orderName="student_name";
			var orderRule="desc";
			StudentService.getStudentListByPage(fileobj,pageSize,pageIndex,orderName,orderRule,function(msg){
				var trFile;			
				for(i=0;i<msg.length;i++){
					var student=msg[i];
                   trFile+=('<tr><td>'+student.student_number+'</td>');
                   trFile+=('<td>'+student.student_name+'</td>');
                   trFile+=('<td>'+student.student_phone+'</td>');
                   trFile+=('<td>'+student.student_email+'</td>');
                   trFile+=('</tr>'); 
					$("#trStudent").html(trFile);
				//	alert(trFile);	           	
				}
				
			})
			
		}
	function showUserForm(){
		document.location="http://127.0.0.1:8080/File_Manage/jsp/student/AddStudent.jsp";
	}
	</script>
</html>