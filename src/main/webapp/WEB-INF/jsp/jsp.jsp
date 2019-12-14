<%--
  Created by IntelliJ IDEA.
  User: 40651
  Date: 2019/11/15
  Time: 10:36
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
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<title>开始使用layui</title>
	<link rel="stylesheet" href="<%=csspath+"LoginCss.css"%>">
	<link rel="stylesheet" href="../layui/css/layui.css">
	<script src="../layui/layui.js"></script>
	<script src=<%=jspath+"jquery-3.4.1.js"%>></script>
	<script src="<%=jspath+"registerJs.js"%>"></script>


</head>
<body>

<!-- 你的HTML代码 -->

<form class="layui-form" action="<%=path%>/register.action" method="post">
	<div class="layui-form-item">
		<label class="layui-form-label">用户名</label>
		<div class="layui-input-block">
			<input type="text" name="title" id="username" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">输入密码</label>
		<div class="layui-input-inline">
			<input type="password" name="password" id="onePs" required  lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">再次确认</label>
		<div class="layui-input-inline">
			<input type="password" name="password1" id="twoPs" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		</div>
		<div class="layui-form-mid layui-word-aux">两次密码必须相同</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">单选框</label>
		<div class="layui-input-block" id="sex">
			<input type="radio" name="sex" value="男" title="男">
			<input type="radio" name="sex" value="女" title="女" checked>
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">个人信息：</label>
		<div class="layui-input-inline">
			<input type="text" name="information" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
		</div>
		<div class="layui-form-mid layui-word-aux">两次密码必须相同</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">学历</label>
		<div class="layui-input-block">
			<select name="education" lay-verify="required" id="education">
				<option value="请选择"></option>
				<option value="硕士">硕士</option>
				<option value="博士">博士</option>
				<option value="本科">本科</option>
				<option value="专科">专科</option>
				<option value="专科以下">专科以下</option>
			</select>
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">职业</label>
		<div class="layui-input-block">
			<select name="work" lay-verify="required" id="work">
				<option value="请选择"></option>
				<option value="公务员">公务员</option>
				<option value="程序员">自由职业</option>
				<option value="键盘侠">键盘侠</option>
			</select>
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">手机号码</label>
		<div class="layui-input-inline">
			<input type="text" id="phoneNum" name="phoneNum" required  lay-verify="required" placeholder="请输入手机号" autocomplete="off" class="layui-input">
		</div>
	</div>

	<div class="layui-form-item">
		<label class="layui-form-label">email</label>
		<div class="layui-input-inline">
			<input type="text" id="email" name="email" required  lay-verify="required" placeholder="请输入邮箱" autocomplete="off" class="layui-input">
		</div>
	</div>



	<div class="layui-form-item">
		<div class="layui-input-block">
			<input type="submit" value="立即提交" class="layui-btn" lay-submit lay-filter="formDemo" onclick="sumbButton(this)">
			<button type="reset" class="layui-btn layui-btn-primary">重置</button>
		</div>
	</div>
</form>
<input type="hidden" value="${requestScope.success}" id="hid">
<script>
	if ($("#hid").val()==="fail") {
		alert("注册失败，请检查后重试")
	}
	//Demo
	layui.use('form', function(){
		/*var form = layui.form;

		//监听提交
		form.on('submit(formDemo)', function(data){
			layer.msg(JSON.stringify(data.field));
			return false;
		});*/
	});
</script>
</body>
</html>
