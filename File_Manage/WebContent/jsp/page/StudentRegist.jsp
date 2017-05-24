<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script  src="<%=request.getContextPath() %>/jquery/jquery.js"></script>
<script  src="<%=request.getContextPath() %>/JS/StudentRegist.js"></script> 
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/engine.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/util.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/interface/StudentService.js"></script>
<title>学生注册</title>
</head>
<body>
	<div  style="height: 20%">
		<jsp:include page="../part/head.jsp"></jsp:include>
	</div> 
		<div align="center" style="width: 40%" class="container">
		  <form action="<%=request.getContextPath() %>/StudentRegist" method="POST">
			<table class="table table-hover">
			<thead><h2>学生注册</h2></thead>
			<tbody>
			<tr><td><font color='red'>*&nbsp;</font>姓名:</td><td><input type="text"  id="sname" name="sname"></td></tr>
			<tr><td><font color='red'>*&nbsp;</font>账号:</td><td><input type="text" id="snumber" name="snumber"></td></tr>
			<tr><td><font color='red'>*&nbsp;</font>密码:</td><td><input type="password"  id="spassword1" name="spassword1"></td></tr>
			<tr><td><font color='red'>*&nbsp;</font>确认密码:</td><td><input type="password"  id="spassword2" name="spassword2"></td></tr>
			<tr><td><font color='red'>*&nbsp;</font>移动电话:</td><td><input type="text"  id="sphone" name="sphone"></td></tr>
			<tr><td><font color='red'>*&nbsp;</font>电子邮箱:</td><td><input type="text"  id="semail" name="semail"></td></tr>
			<tr><td>&nbsp;&nbsp;Q Q:</td><td><input type="text"  id="sqq" name="sqq"></td></tr>
			<tr><td>&nbsp;&nbsp;微信:</td><td><input type="text"  id="swechat" name="swechat"></td></tr>
			<tr><td>&nbsp;&nbsp;出生日期:</td><td><input type="date"  value="2017-01-01" style="width:178px;" id="sbrithday" name="sbrithday"></td></tr>
			<tr><td>&nbsp;&nbsp;学院:</td><td><input type="text"  id="sacademy" name="sacademy"></td></tr>
			<tr><td><font color='red'>*</font>特长:</td><td>
				   <input type = 'checkbox' name = "studentlike" value= 'C'/>C
	       		   <input type = 'checkbox' name = "studentlike" value = 'JAVA'/>JAVA
				   <input type = 'checkbox' name = "studentlike" value = 'PHP'/>PHP
				   <input type = 'checkbox' name = "studentlike" value = 'HTML/CSS'/>HTML/CSS<br/>
				   <input type = 'checkbox' name = "studentlike" value = 'JavaScript'/>JavaScript
				   <input type = 'checkbox' name = "studentlike" value = 'Python'/>Python
				   <input type = 'checkbox' name = "studentlike" value= '算法'/>算法
		    </td></tr>
		    <tr><td align="center">
		    <input class="btn btn_lg btn-primary" type="submit" value="提交"/>
					</td><td>
					<input class="btn btn_lg btn-warning" type="reset" value="重置" />
			</td></tr>	
		  </tbody>
		</table>
	</form>
  </div>
</body>
</html>