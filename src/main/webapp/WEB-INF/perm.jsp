<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basePath%>">
<title>Insert title here</title>
<link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
	
	<input type="hidden" name="role_id" value="${role_id}">
<div id="test1" class="demo-tree demo-tree-box"></div>
<button class="layui-btn" id="save">保存<button>
<script src="./layui/layui.all.js"></script>
<script type="text/javascript">
var $=layui.jquery;
var upload=layui.upload;
var tree=layui.tree;
var layer=layui.layer;
$.ajaxSettings.async=false;
var testTree;
$.post("treeJson",function(d){
	testTree=d;
});
//常规用法
tree.render({
	id:"perm_tree",
	showCheckbox:true,
	elem:"#test1"//默认是点击节点可进行收缩
	,data:testTree
});
//为保存按钮声明一个事件
$("#save").click(function(){
	var role_id=$("[name='role_id']").val();
	var checkData = tree.getChecked('perm_tree');
	var perms="";
	for(var i=0;i<checkData.length;i++){
		perms+=checkData[i].id+',';
		var children=checkData[i].children;
		for(var j=0;j<children.length;j++){
			perms+=children[j].id+',';
		}
	}
	if(perms==""){
		layer.msg("请先选中角色");
	}else{
		layer.msg("保存成功");
		location.href="sys/role_perm/"+role_id+"/"+perms;
	}
	
});
</script>
</body>
</html>