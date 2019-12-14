<%--
  Created by IntelliJ IDEA.
  User: 40651
  Date: 2019/11/17
  Time: 19:40
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
	<title>注册界面</title>
<%--	<link rel="stylesheet" href="<%=csspath+"LoginCss.css"%>">--%>
	<link rel="stylesheet" href="<%=laPath+"css/layui.css"%>">
	<script src="<%=laPath+"layui.js"%>"></script>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<script src=<%=jspath+"util.js"%>></script>
	<script src=<%=jspath+"jquery-3.4.1.js"%>></script>
	<script src=<%=jspath+"userMangerJs.js"%>></script>
	<link rel="stylesheet" href="<%=laPath+"menuCss.css"%>>">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
	<div class="layui-header">
		<div class="layui-logo">文档后台管理</div>
		<!-- 头部区域（可配合layui已有的水平导航） -->

		<ul class="layui-nav layui-layout-right">

			<li class="layui-nav-item">
				<a href="javascript:;">
					<img src="http://t.cn/RCzsdCq" class="layui-nav-img">
					贤心
				</a>
				<dl class="layui-nav-child">
					<dd><a href="">基本资料</a></dd>
					<dd><a href="">安全设置</a></dd>
				</dl>
			</li>
			<li class="layui-nav-item"><a href="">退了</a></li>
		</ul>
	</div>

	<div class="layui-side layui-bg-black">
		<div class="layui-side-scroll">
			<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
			<ul class="layui-nav layui-nav-tree"  lay-filter="test">
				<c:if test="${requestScope.map!=null}">
				<c:forEach items="${requestScope.map}" begin="0" step="1" var="entry">
					<li class="layui-nav-item " id="goto1">
										<a class="">${entry.key}</a>
										<dl class="layui-nav-child">

											<c:forEach items="${entry.value}"  begin="0" step="1" var="j">
												<dd><a title="${j.MENUURL}" href="javascript:void(0)" onclick="changgeURL(this)">${j.MENUNAME}</a></dd>
											</c:forEach>
										</dl>
									</li>
									</c:forEach>
									</c:if>
			</ul>
		</div>
	</div>

	<div class="layui-body">
		<!-- 内容主体区域 -->

		<iframe src="" frameborder="0" name="select-view" id="myiframe" style="width: 100%;height: 100%"></iframe>
	</div>
</div>
<script>
	//JavaScript代码区域
	layui.use('element', function(){
		var element = layui.element;

	});


</script>

</body>
</html>
