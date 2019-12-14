<%--
  Created by IntelliJ IDEA.
  User: 40651
  Date: 2019/11/17
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
	String path = application.getContextPath();
	String laPath = application.getContextPath()+"/layui/";
	String csspath = application.getContextPath()+"//css/";
	String viewPath = application.getContextPath()+"/jsp/";
	String jspath = application.getContextPath()+"/js/";
%>
<html>
<head>
	<title>后台用户登入</title>
	<link rel="stylesheet" href="<%=csspath+"LoginCss.css"%>">
	<script src="<%=laPath+"layui.js"%>"></script>
	<link rel="stylesheet" href="<%=laPath+"css/layui.css"%>">
	<script src=<%=jspath+"jquery-3.4.1.js"%>></script>
	<script src="<%=jspath+"LoginJs.js"%>"></script>

</head>
<body>
<div style="width:100%;text-align:center">
<form action="<%=path+"/wangleai.action"%>" method="post" id="form1" class="layui-form" >
	<div class="layui-input-inline" >
<input type="text" name="USERNAME" required lay-verify="required"
       placeholder="请输入账号" autocomplete="off" class="layui-input" style="width: 200px" value="风无痕">
	</div><br>
	<div class="layui-input-inline" >
		<input name="USERPS" class="layui-input" type="password"
		       placeholder="请输入密码" autocomplete="off" lay-verify="pass" style="width: 200px" value="123456">
	</div><br>
	<div style="width: 216px;margin-left: 660px">
	<input type="submit" class="layui-btn layui-btn-normal"  value="登录" style="width: 100px">
		<button class="layui-btn layui-btn-normal" type="button" style="width: 100px" ><a href="<%=path+"/web/jsp"%>">注册</a></button>
	</div>

</form>
<%--	用来存放登入成功的返回值--%>
	<input type="hidden" value="${requestScope.success}" id="hid">
	<input type="hidden" value="${requestScope.success1}" id="hid2">
</div>
</body>
</html>
