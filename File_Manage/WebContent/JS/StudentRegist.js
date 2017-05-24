$(document).ready(function(){
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