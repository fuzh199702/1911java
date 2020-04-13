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
		
		<form action="login_system" method='post'>
			<input type="text" name="phoneNo" placeholder="请输入手机号">
			<input type="password" name="userpass" placeholder="请输入密码">
			<!-- <button>提交</button> -->
			<div class="forgot">
	    	<a href="#">forgot Password</a>
	    	<input type="submit" value="Login" >
	    </div>
	    </form>
	    
	</div>
	<div class="login-bottom">
		<h3>New User &nbsp;<a href="register">Register</a>&nbsp Here</h3>
	</div>
</div>
	<script type="text/javascript" src="./js/jquery-3.4.1.min.js" ></script>
	<script src="./layui/layui.all.js" charset="utf-8" ></script>
	<script type="text/javascript" charset="utf-8">
	var layer=layui.layer;
	var $=layui.jquery;
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