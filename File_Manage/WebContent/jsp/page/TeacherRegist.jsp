<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>老师注册</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/engine.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/util.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/interface/TeacherService.js"></script>
<script  src="<%=request.getContextPath() %>/jquery/jquery.js"></script>
<script  src="<%=request.getContextPath() %>/JS/TeacherRegister.js"></script>
<style type="text/css">
.requiredField {
	padding-right: 3px;
	color: #ff6d6d;
	font-size: 15px;
}
</style>
</head>
<body>
<body>
	<div style="height: 20%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div> 
	<div align="center" style="width: 40%" class="container">
		<form action="<%=request.getContextPath() %>/TeacherRegist" method="POST">
			<table class="table table-hover">
				<thead><h2>老师注册</h2></thead>
				<tbody>
					<tr><td><font color='red'>*&nbsp;</font>姓名:</td><td><input type="text"  id="tname" name="tname"></td></tr>
					<tr><td><font color='red'>*&nbsp;</font>账号:</td><td><input type="text" id="tnumber" name="tnumber"></td></tr>
					<tr><td><font color='red'>*&nbsp;</font>密码:</td><td><input type="password" id="tpassword1" name="tpassword1"></td></tr>
					<tr><td><font color='red'>*&nbsp;</font>确认密码:</td><td><input type="password" id="tpassword2" name="tpassword2"></td></tr>
					<tr><td><font color='red'>*&nbsp;</font>电话:</td><td><input type="text" id="tphone" name="tphone"></td></tr>
					<tr><td>学院:</td><td><input type="text" id="tacademy" name="tacademy"></td></tr>
					<tr><td>办公室:</td><td><input type="text" id="toffice" name="toffice"></td></tr>
					<tr><td>办公司电话:</td><td><input type="text" id="ttelephone" name="ttelephone"></td></tr>
					<tr><td><font color='red'>*&nbsp;</font>邮箱:</td><td><input type="text" id="temail" name="temail"></td></tr>
					<tr><td>职称:</td><td><select name="ttitle" id="ttitle">
					<option value="teacher">讲师</option>
					<option value="aprofessor">副教授</option>
					<option value="professor">教授</option>
					</select></td></tr>
					<tr><td>部门:</td><td><input type="text" id="tdepartment" name="tdepartment"></td></tr>	
					<tr><td align="center"><input class="btn btn_lg btn-primary" type="submit" value="提交"/>
					</td><td>
					<input class="btn btn_lg btn-warning" type="reset" value="重置" />
					</td></tr>								
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>