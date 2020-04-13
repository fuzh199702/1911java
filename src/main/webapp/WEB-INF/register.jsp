<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	%>
<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>小布丁CRM管理系统</title>
<!-- Custom Theme files -->
<link href="login/style.css" rel="stylesheet" type="text/css" media="all"/>
<!-- Custom Theme files -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
<meta name="keywords" content="Login form web template, Sign up Web Templates, Flat Web Templates, Login signup Responsive web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<!--Google Fonts-->
<link href='http://fonts.useso.com/css?family=Roboto:500,900italic,900,400italic,100,700italic,300,700,500italic,100italic,300italic,400' rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
<!--Google Fonts-->
</head>
<body>
<div class="login">
	<h2>Acced Form</h2>
	<div class="login-top">
		<h1>LOGIN FORM</h1>
		
		<form action="" method=''>
			<input type="text" name="phoneNo" placeholder="请输入手机号">
			<!-- <input type="password" name="userpass" placeholder="请输入密码"> -->
			<!-- <button>提交</button> -->
			<div class="forgot" onclick='register()'>
	    	<!-- <a href="#">forgot Password</a> -->
	    	
	    	</div>
	    </form>
	    <input type="submit" value="Register" onclick='register()'>
	</div>
	<div class="login-bottom">
		<h3>&nbsp;<a href="login">Login</a>&nbsp Here</h3>
	</div>
</div>
	<!-- +++++++++++++++发送邮件 -->
	<!-- 弹出层 -->
	<div hidden class="layui-form" id='ggg'>
	<form class="layui-form" action="" lay-filter="sendEmail">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">邮箱</label>
				<div class="layui-input-inline" style="width:415px;margin-top:10px;">
					<input type="text" autocomplete="off" class="layui-input">
				</div>
			</div>
		  </div>
	</form>
	</div>
	<script type="text/javascript" src="./js/jquery-3.4.1.min.js" ></script>
	<script src="./layui/layui.all.js" charset="utf-8" ></script>
	<script type="text/javascript" charset="utf-8">
	var layer=layui.layer;
	var $=layui.jquery;
	function register(){
		alert("进来了");
		layer.open({
			title:"信息",
			type:1,
			content:$("#ggg"),
			btn:["确定","取消"],
			btn1:function(){
				alert("在这----");
				/* $.post("deleteCus",{"customer_id":adminArray},
						function(){
					//关闭窗口
					layer.closeAll();
					//列表刷新,重新加载列表
					layer.msg("删除成功!!")
					table.reload("userlist_p");
				}); */
			}
		});
	}
	/* layer.msg(${msg }); */
	</script>
</body>
</html>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body>
	${msg }
<form action="login_system" method='post'>
	<input name="userName">
	<input name="userpass" type="password">
	<button>提交</button>
</form>
</body>
</html> --%>