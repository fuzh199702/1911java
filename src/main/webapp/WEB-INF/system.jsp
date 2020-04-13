<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>十</title>
<link rel="stylesheet" href="./layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">CRM</div>
    <!-- 头部区域（可配合layui已有的水平导航） -->
    <ul class="layui-nav layui-layout-left">
      <!-- <li class="layui-nav-item"><a href="#">控制台</a></li>
      <li class="layui-nav-item"><a href="#">商品管理</a></li>
      <li class="layui-nav-item"><a href="#">用户</a></li>
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a> -->
        <dl class="layui-nav-child">
          <dd><a href="#">邮件管理</a></dd>
          <dd><a href="#">消息管理</a></dd>
          <dd><a href="#">授权管理</a></dd>
        </dl>
      </li>
      <!-- <li class="layui-nav-item"><a href="#">在线人数:</a></li> -->
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item" style="margin-right:10px;">
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          石头
        </a>
        <dl class="layui-nav-child">
          <!-- <dd><a href="#">基本资料</a></dd>
          <dd><a href="#">安全设置</a></dd> -->
          <dd onclick='user_update()'><a href="#">修改密码</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item" onclick='quit()' style="margin-right:30px;"><a href="#">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <!-- <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">商品管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;" page="goodsType_behind" >商品分类</a></dd>
            <dd><a href="javascript:;" page="earphone_behind" >商品管理</a></dd>
            <dd><a href="javascript:;">123</a></dd>
            <dd><a href="#">超链接</a></dd>
          </dl>
        </li> -->
        <li class="layui-nav-item">
          <a href="javascript:;">权限管理</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;" page="sys/role_page">角色管理</a></dd>
            <dd><a href="javascript:;" page="sys/user_page">用户管理</a></dd>
            <dd><a href="javascript:;" page="sys/dapa_page">部门管理</a></dd>
            <dd><a href="javascript:;" page="sys/cus_page">客户管理</a></dd>
            <dd><a href="javascript:;" page="sys/pubCus_page">公共客户管理</a></dd>
            <dd><a href="javascript:;" page="sys/priCus_page">个人客户管理</a></dd>
            <dd><a href="javascript:;" page="sys/returnRe">回访记录</a></dd>
          </dl>
        </li>
        <!-- <li class="layui-nav-item"><a href="javascript:;" page="Con_behind" ></a></li> -->
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
   <iframe style="height:98%;width:98%;" src="" id="admin" ></iframe>
  </div>
  
  <!-- <div class="layui-body">
   <iframe style="height:98%;width:98%;" src="" id="consumer" ></iframe>
  </div>
  
  <div class="layui-body">
   <iframe style="height:98%;width:98%;" src="" id="goodsType" ></iframe>
  </div> -->
  
  <!-- <div class="layui-body">
   <iframe style="height:98%;width:98%;" src="" id="earphone" ></iframe>
  </div> -->
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
    © layui.com - 底部固定区域
  </div>
</div>

<!-- +++++++++++++++修改 -->
	<!-- 弹出层 -->
	<div hidden id='update_user_div'>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">当前密码</label>
				<div class="layui-input-inline">
					<input type="password" id='update_nowpass' name="passWord" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!-- +++++++++++++++ -->
			<div class="layui-inline">
				<label class="layui-form-label">新密码</label>
				<div class="layui-input-inline">
					<input type="password" id='update_pass' name="newPassWord" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			<div class="layui-inline">
				<label class="layui-form-label">确认密码</label>
				<div class="layui-input-inline">
					<input type="password" id='update_confpass' name="confPassWord" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
	</div>

<!-- +++++++++++退出++++++++++++++++ -->
	<div hidden id='quit'>
		<div class="layui-form-item">
			<div class="layui-inline"  >
				<label class="layui-form-label" style="width:100px;padding-right:50px;" >是否退出</label>
			</div>
		</div>
	</div>
	
	<script type="text/javascript" src="./js/jquery-3.4.1.min.js" ></script>
	<script src="./layui/layui.all.js"></script>
	<script type="text/javascript">
	var layer=layui.layer;
	/* 点击一个含有page属性的标签,让iframe标签的显示的页面发生变化,变成当前被点击的标签的属性 */
	 $("[page]").click(function() {
		$("#admin").attr("src",$(this).attr("page"));
		$("#consumer").attr("src","");
		$("#goodsType").attr("src","");
		$("#earphone").attr("src","");
	}); 
	
	$("[page]").click(function() {
		$("#consumer").attr("src",$(this).attr("page"));
		$("#admin").attr("src","");
		$("#goodsType").attr("src","");
		$("#earphone").attr("src","");
	});
	
	 $("[page]").click(function() {
		$("#goodsType").attr("src",$(this).attr("page"));
		$("#admin").attr("src","");
		$("#consumer").attr("src","");
		$("#earphone").attr("src","");
	}); 
	 $("[page]").click(function() {
		$("#earphone").attr("src",$(this).attr("page"));
		$("#admin").attr("src","");
		$("#consumer").attr("src","");
		$("#goodsType").attr("src","");
	}); 
	
	 
	 function quit(){
		 layer.open({
				type:1,
				content:$("#quit"),
				btn:["是","否"],
				btn1:function(){
					 window.location.href="quit"
				}
			});
	 }
	
	
	/* +++++++++++++++++++++修改 */
	function user_update() {
			//弹出对话框
			$("#update_nowpass").val("");
			$("#update_pass").val("");
			$("#update_confpass").val("");
			layer.open({
				title:"修改信息",
				type:1,
				content:$("#update_user_div"),
				btn:["保存","关闭"],
				btn1:function(){
					$.post("updateUser_p_admin",{"passWord":$("#update_nowpass").val(),"newPassWord":$("#update_pass").val(),"confPassWord":$("#update_confpass").val()},
							function(d){
						var newPassWord=$("#update_pass").val();
						var confPassWord=$("#update_confpass").val();
						if(d==1){
							layer.msg("当前密码错误!");
						}else if(d==2){
							//alert("新密码与确认密码不一致,保存失败");
							layer.msg("新密码与确认密码不一致,保存失败");
						}else{
							//关闭窗口
							layer.closeAll();
							//列表刷新
							layer.msg("修改成功");
							window.location.href="login";
						}
					});
				}
			});
		
	}
	</script>
	
</body>
</html>