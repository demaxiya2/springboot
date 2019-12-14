<%--
  Created by IntelliJ IDEA.
  User: 40651
  Date: 2019/12/4
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%
	String laPath = application.getContextPath() + "/layui/";
	String jspath = application.getContextPath() + "/js/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>树组件</title>
	<link rel="stylesheet" href="<%=laPath%>css/layui.css">
	<script src=<%=jspath + "jquery-3.4.1.js"%>></script>
	<script src="<%=laPath%>layui.js"></script>
</head>
<body>
<div>
	<label>请选择角色：</label>
<select name="" id="sName" style="width: 200px">
	<option value="zhang" name="1" id="121">请选择</option>
	<option value="公司领导" name="2">公司领导</option>
	<option value="小秘" name="3">小秘</option>
</select>
</div>
<div class="demo-tree" id="test5"></div>
<button class="layui-btn layui-btn-sm" type="button" lay-demo="getChecked">确认分配</button>
<script>
	var relValue = null;
	var menuList = null;
		layui.use(['tree', 'util'], function () {
			var tree = layui.tree
				, layer = layui.layer
				, util = layui.util
			//模拟数据
			//基本演示
			$.ajax({
				type: "post",
				url: "http://localhost:8080/springboot/tansferAll.action",
				datatype: "text",
				async: true,
				success: function (res) {
				var ob= JSON.parse(res);
					tree.render({
						elem: '#test5'
						, data: ob
						, showCheckbox: true  //是否显示复选框
						, id: 'demoId1'
						, isJump: false //是否允许点击节点时弹出新窗口跳转
						,click:function (obj) {
							var data = obj.data; //得到当前节点的数据
							var id = data.id; //得到节点索引
							console.log(id)
						}

						// ,click: function(obj){
						// 	var data = obj.data;  //获取当前点击的节点数据
						// 	layer.msg('状态：'+ obj.state + '<br>节点数据：' + JSON.stringify(data));
						// }
					});
				}
			});
			$("#sName").change(function () {
				relValue = $("#sName").val();
				if (relValue != null&&relValue!="zhang") {
					$.ajax({
						type: "post",
						url: "http://localhost:8080/springboot/tansferAll.action",
						data: "msg=" + relValue,
						datatype: "text",
						async: true,
						success: function (data) {
							var ob= JSON.parse(data);
							tree.reload('demoId1',{

							});
							tree.setChecked('demoId1',ob);
						},

						error: function () {
							layer.msg("服务器繁忙")
						}
					})
				} else if (relValue.length < 2) {
					layer.msg("请选择需要操作的角色")
				}
			});


			//按钮事件
			util.event('lay-demo', {
				getChecked: function (othis) {
					var checkedData = tree.getChecked('demoId1'); //获取选中节点的数据
					console.log(checkedData);
					$.ajax({
						type: "post",
						url: "http://localhost:8080/springboot/addMenu.action",
						data: "msg=" + JSON.stringify(checkedData),
						datatype: "json",
						async: true,
						success:function (data) {
							if (data.msg==="insert") {
								layer.msg("分配成功")
							}else if (data.msg==="contion") {
								layer.msg("未新增和修改、删除等数据")
							}else if (data.msg==="del"){
								layer.msg("删除成功")
							}else if (data.msg ==="insertFail") {
								layer.msg("分配失败，请稍后再试")
							}else if (data.msg==="delFail") {
								layer.msg("修改失败")
							}
						},
						error:function () {
							layer.msg("服务器繁忙，请稍后再试")
						}

					})
				}

				, reload: function () {
					//重载实例
					tree.reload('demoId1', {

					});

				}
			});




			/*//仅节点左侧图标控制收缩
			tree.render({
				elem: '#test2'
				, data: data1
				, onlyIconControl: true  //是否仅允许节点左侧图标控制展开收缩
				, click: function (obj) {
					layer.msg(JSON.stringify(obj.data));
				}
			});*/



		})

</script>
</body>
</html>
