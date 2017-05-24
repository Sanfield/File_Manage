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
<script type="text/javascript" src="<%=request.getContextPath() %>/dwr/interface/KlfileService.js"></script>
<title>全部</title>
</head>
<body>
<form>
	<table class="table table-striped">
		<thead>
			<th>文件名称</th>
			<th>更新时间</th>
			<th>文件描述</th>
			<th>大小</th>
			<th>上传者</th>
			<th>下载次数</th>
		</thead>
		<tbody id="trFile">
		
		</tbody>
	</table>
</form>
</body>
	<script type="text/javascript">
	$(document).ready(function(){
		queryMenuList();
	//	alert((String)session.getAttribute("username"));
	})
		function queryMenuList(){
			

		//	alert("haha");
			var fileobj = new Object();
			var pageSize=20;
			var pageIndex=1;
			var file_class="AND klfile_fileType LIKE'%g%'";
			var orderName="klfile_uploadingTime";
			var orderRule="desc";
			KlfileService.getFileListByPageC(fileobj,file_class,pageSize,pageIndex,orderName,orderRule,function(msg){
				//alert(msg);
			//	alert(msg.length);
				var trFile;
				
				for(i=0;i<msg.length;i++){
					var file=msg[i];
					url="<%=request.getContextPath()%>/DownServlet?filename="+file.klfile_uuid;
	                   trFile+=("<tr><td><a href='"+url+"'>"+file.klfile_fileName+"</a></td>");
                  // alert(menu.menu_parent_id);
                   trFile+=('<td>'+file.klfile_uploadingTime+'</td>');
                   trFile+=('<td>'+file.klfile_describtion+'</td>');
                   trFile+=('<td>'+(file.klfile_fileSize/(1048576)).toPrecision(2)+'M</td>');
                   trFile+=('<td>'+file.klfile_author+'</td>');
                   trFile+=('<td>'+file.klfile_downloads+'</td>');
                   trFile+=('</tr>'); 
					$("#trFile").html(trFile);
				//	alert(trFile);	           	
				}
				
			})
			
		}

	</script>
</html>