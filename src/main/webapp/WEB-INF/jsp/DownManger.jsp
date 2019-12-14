<%--
  Created by IntelliJ IDEA.
  User: 40651
  Date: 2019/12/12
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page  isELIgnored = "false" %>
<%
	String path = application.getContextPath();
	String laPath = application.getContextPath()+"/layui/";
	String csspath = application.getContextPath()+"/css/";
	String viewPath = application.getContextPath()+"/jsp/";
	String jspath = application.getContextPath()+"/js/";
%>
<html>
<head>
	<title>文档审核</title>
	<link rel="stylesheet" href="<%=laPath%>css/layui.css" media="all">
	<script src="<%=laPath%>layui.js"></script>
	<script src=<%=jspath+"jquery-3.4.1.js"%>></script>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<style type="text/css" >
		.layui-table-page{text-align: center;}
	</style>
</head>
<body>



<table align="center" style="margin-left: 300px;margin-top:20px">
	<tr align="center">
		<td>
			<label class="layui-form-label">上传时间</label>
			<div class="layui-input-inline">
				<input name="date1" class="layui-input" id="date" type="date" placeholder="yyyy-MM-dd" autocomplete="off" lay-verify="date">
			</div>
		</td>
		<td>
			<label class="layui-form-label">至</label>
			<div class="layui-input-inline">
				<input name="date2" class="layui-input" id="date1" type="date" placeholder="yyyy-MM-dd" autocomplete="off" lay-verify="date">
			</div>
		</td>
	</tr>
	<tr>
		<td>
			<label class="layui-form-label">文件标题：</label>
			<div class="layui-input-inline">
				<input name="downname" class="layui-input" id="downName" type="text"  autocomplete="off">
			</div>
		</td>
		<td style="margin-left: 50px;padding-left: 120px">
			<input class="layui-btn layui-btn-primary layui-btn-lg" type="button" value="搜索" onclick="gotoDb()">
		</td>
	</tr>
</table>

<table id="demo" lay-filter="test" style="margin-top: 10px"></table>

<script id="barDemo" type="text/html">
	<a class="layui-btn layui-btn-xs" lay-event="edit" onclick="updateUser()" >启用</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" >删除</a>
</script>
<script>
	layui.use('table', function(){
		var table = layui.table;
		//第一个实例
		table.render({
			elem: '#demo'
			,height: 312
			,url: 'http://localhost:8080/springboot/manger.action' //数据接口
			,cellMinWidth: 80
			,page: true
			,cols: [[ //表头
				{field: 'downname', title: '文件标题', align:"center"}
				,{field: 'username', title: '上传人', align:"center"}
				,{field: 'downdate', title: '上传时间', align:"center"}
				,{field: 'downpoint', title: '下载积分', align:"center"}
				,{field: 'downtype', title: '文档类型', align:"center"}
				,{field: 'downexam', title: '审核状态', align:"center"}
				,{fixed: 'right', title:'操作', toolbar: '#barDemo',align:"center"}
			]]
			,skin: 'row' //表格风格
			,even: true
			,limits: [1,5,10]
			,limit: 1 //每页默认显示的数量

		});

	});
	function gotoDb(){
		var downName  =$("#downName").val();
		var table = layui.table;
		table.reload('demo', {
			url: 'http://localhost:8080/springboot/manger.action'
			,where: {
				"downName" :downName
			}
			,page:{
				curr:1
			}//设定异步数据接口的额外参数
			//,height: 300
		});

	}
</script>
</body>
</html>
