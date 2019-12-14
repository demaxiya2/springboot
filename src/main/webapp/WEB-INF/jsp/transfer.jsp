<%--
  Created by IntelliJ IDEA.
  User: 40651
  Date: 2019/12/9
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String laPath = application.getContextPath()+"/layui/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>穿梭框组件</title>
	<link rel="stylesheet" href="<%=laPath%>css/layui.css">
</head>
<body>
<div id="test1"></div>
<script src="<%=laPath%>layui.js"></script>
<script>
	layui.use('transfer', function(){
		var transfer = layui.transfer;

		//渲染
		transfer.render({
			elem: '#test1'  //绑定元素
			,data: [
				{"value": "1", "title": "李白", "disabled": "", "checked": ""}
				,{"value": "2", "title": "杜甫", "disabled": "", "checked": ""}
				,{"value": "3", "title": "贤心", "disabled": "", "checked": ""}
			]
			,id: 'demo1' //定义索引
		});
	});
</script>
</body>
</html>
