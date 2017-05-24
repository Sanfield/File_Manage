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
<title>文件管理</title>
</head>
<body>
<div>
	<button type="button" class="btn btn-info" id="tdsubmit" onclick="showUserForm();">添加管理员</button>
</div> 
<div> 
<form>
	<table class="table table-striped">
		<thead>
			<th>管理员账号</th>
			<th>密码</th>
		</thead>
		<tbody id="trManager">
		
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
			

		//	alert("haha");
			var ManageObj = new Object();
			var pageSize=100;
			var pageIndex=1;
			var orderName="manager_number";
			var orderRule="desc";
			ManagerService.getManagerListByPage(ManageObj,pageSize,pageIndex,orderName,orderRule,function(msg){
				//alert(msg);
			//	alert(msg.length);
				var trFile;
				
				for(i=0;i<msg.length;i++){
					var manager=msg[i];
	               trFile+=("<tr><td>"+manager.manager_number+"</td>");
                  // alert(menu.menu_parent_id);
                   trFile+=('<td>'+manager.manager_password+'</td>');
                   trFile+=('</tr>'); 
					$("#trManager").html(trFile);
				//	alert(trFile);	           	
				}
				
			})
			
		}
	function showUserForm(){
		document.location="http://127.0.0.1:8080/File_Manage/jsp/Manager/AddStudent.jsp";
	}
	</script>
</html>