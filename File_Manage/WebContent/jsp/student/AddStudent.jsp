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
<title>添加学生</title>
</head>
<body>
		<div align="center" style="width: 80%" class="container">
		  <form action="<%=request.getContextPath() %>/StudentRegist" method="POST">
			<table class="table table-hover">
			<thead><h2 align="left">添加学生</h2></thead>
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
		    <input class="btn btn_lg btn-primary" type="button" id="submit" value="提交"/>
					</td><td>
					<input class="btn btn_lg btn-warning" type="reset" value="重置" />
			</td></tr>	
		  </tbody>
		</table>
	</form>
  </div>
</body>
<script type="text/javascript">
$(document).ready(function(){
	
	$("#submit").bind("click",insertStudent);
	
	$("#snumber").blur(function(){
		$("#snumber_alert").remove();
		var  user_id = $("#snumber").val().trim();
		if(user_id=="") return;
		$("#snumber").after("");
		StudentService.getStudentById(user_id,function(data){
			if(data.result== undefined){
			$("#snumber").after("<font color='green' id='snumber_alert'>恭喜你，此账号可用</font>");
			}else{
				$("#snumber").after("<font color='red' id='snumber_alert'>此账号已经被注册</font>");
				$("#snumber").focus();
			}
		})
	}) 
	/**
	*校验密码长度
	*/
	$("#spassword1").blur(function(){
		$("#spassword_alert").remove();
		if(($("#spassword1").val().length)<6){
			$("#spassword1").after("<font color='red' id='spassword_alert'>密码长度不能小于6</font>");
			$("#spassword1").focus();
		} 		
	})
	/**
	*校验密码两次是否一致
	*/
	$("#spassword2").blur(function(){
		$("#spassword2_alert").remove();
		if($("#spassword2").val() != $("#spassword1").val()){
			$("#spassword2").after("<font color='red' id='spassword2_alert'>两次密码不一致</font>");
			//$("#spassword2").focus();
		}
	})
	/***
	*验证邮箱
	*/
	$("#semail").blur(function(){
		$("#semail_alert").remove();
		var str=$("#semail").val();
		var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/
		    if(!re.test(str)){
		    	$("#semail").after("<font color='red' id='semail_alert'>请输入正确邮箱</font>");
		    	$("#semail").focus();
		    }
	})
	/***
	 * 验证电话
	 * */
	$("#sphone").blur(function(){
			$("#sphone_alert").remove();
			if(($("#sphone").val().length)<11){
				$("#sphone").after("<font color='red' id='sphone_alert'>请输入正确电话</font>");
				$("#sphone").focus();
			} 		
		})
	 	    
})
function insertStudent(){
		alert("haha");
		student= new Object();
		student.student_number=$("#snumber").val();
		student.student_name=$("#sname").val();
		student.student_password=$("#spassword1").val();
		student.student_phone=$("#sphone").val();
		student.student_email=$("#semail").val();
		student.student_QQ=$("#sqq").val();
		student.student_wechat=$("#swechat").val();
		student.student_academy=$("#sacademy").val();
		student.student_brithday=$("#sbrithday").val();
		var obj=document.getElementsByName('studentlike'); 
		var s='';    
		  for(var i=0; i<obj.length; i++){    
		    if(obj[i].checked) s+=obj[i].value+',';  //如果选中，将value添加到变量s中    
		  }
		student.student_strongPoint=s;
		StudentService.addStudent(student,function(msg){
			if(msg.result>0){
			//	alert("操作成功");
				document.location="StudentManage.jsp";
			}
		})
	}
</script>
</html>