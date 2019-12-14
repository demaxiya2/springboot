<%--
  Created by IntelliJ IDEA.
  User: 40651
  Date: 2019/11/18
  Time: 10:39
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
	<meta charset="utf-8">
	<title>table模块快速使用</title>
	<link rel="stylesheet" href="<%=laPath%>css/layui.css" media="all">
	<script src="<%=laPath%>layui.js"></script>
	<script src=<%=jspath+"jquery-3.4.1.js"%>></script>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<style type="text/css" >
		.layui-table-page{text-align: center;}
	</style>
	<meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
</head>
<body>
<table align="center" style="margin-left: 300px;margin-top:20px">
	<tr align="center">
		<td>
			<label class="layui-form-label">注册时间</label>
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
			<label class="layui-form-label">用户名：</label>
			<div class="layui-input-inline">
				<input name="userName" class="layui-input" id="userName" type="text"  autocomplete="off">
			</div>

		</td>
		<td style="margin-left: 50px;padding-left: 120px">
			<script language="JavaScript">
				function gotoDb() {
					var userDate= $("#date").val();
					var userDate1= $("#date1").val();
					var userName  =$("#userName").val();
					var msg1;
					if (userName!=null) {
						msg = userName
					}
					if (userDate>userDate1){
						alert("起始时间不能大于截至时间且如果有填一个日期那么必须两个日期同时存在")
					}else {

							$.ajax({
							type:"post",
							data:"msg="+userName+"="+userDate+"="+userDate1,
							datatype: "text",
							async: true,
							success:function (data) {
								var ob= JSON.parse(data);
								alert(ob)
								if (ob ==="success") {
									alert("搜索成功")
									window.location.reload();
								}else {
									alert("并无此人")
								}
							},
							error:function () {
								alert("网络故障")
							}
						})
					}
				}
			</script>
			<input class="layui-btn layui-btn-primary layui-btn-lg" type="button" value="搜索" onclick="gotoDb()">
			<input class="layui-btn layui-btn-warm" type="button" value="添加用户" onclick="onAddBtn()">

		</td>
	</tr>

</table>

<script language="JavaScript">
	var readLoad = null;

	function dialogInsertUser(node) {

		var userNmae= $("#name").val();
		var userPs = $("#type").val();
		var phoneNum = $("#value").val();
		$.ajax({
			type:"post",
			url:"http://localhost:8080/springboot/insertUser.action",
			data:"msg="+userNmae+"="+userPs+"="+phoneNum,
			datatype: "json",
			async: true,
			success:function (date) {

				if (date.msg==="success"){
					alert("添加成功")
					var table = layui.table;
					layer.close(layer.index);
					table.reload('demo', {
						url: 'http://localhost:8080/springboot/allUser.action'
						,page:{
							curr:1
						}
						,where: {

						} //设定异步数据接口的额外参数

						//,height: 300
					});
				} else {
					alert("添加失败")
				}
			},
			error:function () {
				alert("数据异常请重试")
			}
		})
	}
</script>
<div id="add-main" style="display: none;">
		<div class="layui-form-item center" style="margin-top: 20px">
			<label class="layui-form-label" style="width: 100px" >用户名：</label>
			<div class="layui-input-block">
				<input type="text" name="name" id="name" required value="" style="width: 240px" lay-verify="required" placeholder="用户名" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 100px">密码：</label>
			<div class="layui-input-block">
				<input type="password" name="type" id="type" required style="width: 240px" lay-verify="required" placeholder="密码" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label" style="width: 100px">手机号码： </label>
			<div class="layui-input-block">
				<input type="text" name="value" id="value" required style="width: 240px" lay-verify="required" placeholder="手机号码" autocomplete="off" class="layui-input">
			<input type="hidden" name="id" style="width: 240px" autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit lay-filter="save" onclick="dialogInsertUser(this)">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary" id="closeBtn" >重置</button>
			</div>
		</div>
</div>


<table id="demo" lay-filter="test" style="margin-top: 10px"></table>
<button class="layui-btn" name="test3" id="test3" type="button"><i class="layui-icon"></i>上传文件</button>
<script id="barDemo" type="text/html">
	<a class="layui-btn layui-btn-xs" lay-event="edit" onclick="updateUser()" >启用</a>
	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" >删除</a>
</script>
<%--<script type="text/javascript">
	function delOrStratUser(node) {
		var buttonName = node.text;
		alert(buttonName)
	}

</script>--%>
<div id="add1-main" style="display: none;">

	<div class="layui-form-item">
		<label class="layui-form-label" style="width: 100px">原手机号：</label>
		<div class="layui-input-block">
			<input type="text" name="value" id="username1" required style="width: 240px" lay-verify="required" placeholder="手机号码" autocomplete="off" class="layui-input">
			<input type="hidden" name="id" style="width: 240px" autocomplete="off" class="layui-input">
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label" style="width: 100px">手机号码： </label>
		<div class="layui-input-block">
			<input type="text" name="value" id="phone" required style="width: 240px" lay-verify="required" placeholder="手机号码" autocomplete="off" class="layui-input">
			<input type="hidden" name="id" style="width: 240px" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit lay-filter="save" >立即提交</button>
			<button type="reset" class="layui-btn layui-btn-primary" id="closeSome" >重置</button>
		</div>
	</div>
</div>

<script>
	layui.use('table', function(){
		var table = layui.table;
		//第一个实例
		table.render({
			elem: '#demo'
			,height: 312
			,url: 'http://localhost:8080/springboot/allUser.action' //数据接口
			,cellMinWidth: 80
			,page: true
			,cols: [[ //表头
				{field: 'username', title: '用户名', align:"center"}
				,{field: 'userdate', title: '注册时间', align:"center"}
				,{field: 'userpoint', title: '积分', align:"center"}
				,{field: 'usergodown', title: '上传文档数', align:"center"}
				,{field: 'userdown', title: '下载文档数', align:"center"}
				,{field: 'userstate', title: '用户状态', align:"center"}
				,{fixed: 'right', title:'操作', toolbar: '#barDemo',align:"center"}
			]]
			,skin: 'row' //表格风格
			,even: true
			,limits: [1,5,10]
			,limit: 1 //每页默认显示的数量

		});
		//监听行工具事件
		table.on('tool(test)', function(obj){
			var data = obj.data;
			var kk = data['username'];

			if(obj.event === 'del'){
				layer.confirm('真的删除行么', function(index){

					$.ajax({
						type:"post",
						url:"http://localhost:8080/springboot/deleteUser.action",
						data:"msg="+kk,
						dataType:"json",
						async:true,
						success:function (msg) {
							if (msg.msg==="success"){
								alert("删除成功")
							}
							if (msg.msg === "fail") {
								alert("删除失败")
							}
						},
						error:function () {
							alert("数据操作异常，请拨打110告知维护")
						}
					});
					layer.close(index);
					obj.del();
					/*table.reload('demo', {
						url: 'http://localhost:8080/springboot/allUser.action',
						page:1
					});*/
				});
			} else if(obj.event === 'edit'){
				alert(123)
		}
	});


	});
	function onAddBtn(){
		//页面层-自定义
		layer.open({
			type: 1,
			title:"新建配置",
			closeBtn: false,
			shift: 2,
			area: ['400px', '300px'],
			shadeClose: true,
			// btn: ['新增', '取消'],
			// btnAlign: 'c',
			content: $("#add-main"),
			success: function(layero, index){},
			yes:function(){
			}
		});
	}

	function updateUser(){
		//页面层-自定义
		layer.open({
			type: 1,
			title:"新建配置",
			closeBtn: false,
			shift: 2,
			area: ['400px', '300px'],
			shadeClose: true,
			// btn: ['新增', '取消'],
			// btnAlign: 'c',
			content: $("#add1-main"),
			success: function(layero, index){},
			yes:function(){
			}
		});
	}

	layui.use('upload', function() {
		var $ = layui.jquery
			, upload = layui.upload;
		//指定允许上传的文件类型
		upload.render({
			elem: '#test3'
			,url: 'http://localhost:8080/springboot/uploadFile.action'
			,accept: 'file' //普通文件
			,done: function(msg){
				if (msg.msg==="success") {
					alert("上传成功")
				}else {
					alert("上传失败")
				}
			}
		});

	});
</script>
</body>
</html>
