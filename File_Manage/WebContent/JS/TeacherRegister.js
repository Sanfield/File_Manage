$(document).ready(function(){
	$("#tnumber").blur(function(){
		$("#stnumber_alert").remove();
		var  user_id = $("#tnumber").val().trim();
		if(user_id=="") return;
		$("#tnumber").after("");
		TeacherService.getTeacherById(user_id,function(data){
			if(data.result== undefined){
			$("#tnumber").after("<font color='green' id='snumber_alert'>恭喜你，此账号可用</font>");
			}else{
				$("#tnumber").after("<font color='red' id='snumber_alert'>此账号已经被注册</font>");
				$("#tnumber").focus();
			}
		})
	}) 	
	/**
	*校验密码长度
	*/
	$("#tpassword1").blur(function(){
		$("#tpassword_alert").remove();
		if(($("#tpassword1").val().length)<6){
			$("#tpassword1").after("<font color='red' id='tpassword_alert'>密码长度不能小于6</font>");
			$("#tpassword1").focus();
		} 		
	})
	/**
	*校验密码两次是否一致
	*/
	$("#tpassword2").blur(function(){
		$("#tpassword2_alert").remove();
		if($("#tpassword2").val() != $("#tpassword1").val()){
			$("#tpassword2").after("<font color='red' id='tpassword2_alert'>两次密码不一致</font>");
			$("#tpassword2").focus();
		}
	})
	/***
	*验证邮箱
	*/
	$("#temail").blur(function(){
		$("#temail_alert").remove();
		var str=$("#temail").val();
		var re = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/
		    if(!re.test(str)){
		    	$("#temail").after("<font color='red' id='temail_alert'>请输入正确邮箱</font>");
		    	$("#temail").focus();
		    }
	})
	/***
	 * 验证电话
	 * */
	$("#tphone").blur(function(){
			$("#tphone_alert").remove();
			if(($("#tphone").val().length)<11){
				$("#tphone").after("<font color='red' id='tphone_alert'>请输入正确电话</font>");
				$("#tphone").focus();
			} 		
		})
	 	    
})

