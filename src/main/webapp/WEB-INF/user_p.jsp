<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>

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
<title>用户列表</title>
<link rel="stylesheet" href="./layui/css/layui.css" charset="utf-8" >
</head>
<body>

<%-- <shiro:hasPermission name="user_del">
		<button class="layui-btn" lay-event="add" onclick='user_adddate()'>增加<button>
</shiro:hasPermission> --%>
<script type="text/html" id="toolbarDemo" >
<div class="layui-form-item">
	<div class="layui-inline">
		<div class="layui-input-inline">
			<input class="layui-input" id="checktext">
		</div>
		<button class="layui-btn" lay-event="add">增加<button>
		<button class="layui-btn" lay-event="update">修改<button>
		<button class="layui-btn" lay-event="del" onclick='user_del()'>删除<button>
		<button class="layui-btn" lay-event="checktable" onclick='user_checkdate()'>查询<button>
		<button class="layui-btn" lay-event="role">分配角色<button>
	</div>
</div>
</script>

<script type="text/html" id="rowbar">
<a class="layui-btn layui-btn-sm" lay-event="edit">编辑</a>
<a class="layui-btn layui-btn-sm" lay-event="fenghao">封号</a>
</script>


	<table class="layui-table" lay-filter="test" lay-data="{url:'user_list',method:'post',toolbar:'#toolbarDemo',id:'userlist_p',page:true}" >
		<thead>
			<tr>
				<th lay-data="{type:'checkbox'}" ></th>
				<th lay-data="{field:'user_id',sort:true}">ID</th>
				<th lay-data="{field:'userName'}">用户名</th>
				<th lay-data="{field:'phoneNo'}">手机号</th>
				<th lay-data="{field:'sex'}">性别</th>
				<th lay-data="{width:190,toolbar:'#rowbar'}">操作</th>
			</tr>
		</thead>
	</table>
	<%-- <%@include file="system.jsp" %> --%>
	<!-- +++++++++++++++修改 -->
	<!-- 弹出层 -->
	<form class="layui-form" action="">
	<div hidden id='update_user_div'>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-inline">
					<input type="text" id='update_userN' name="passWord" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!-- +++++++++++++++ -->
			<div class="layui-inline">
				<label class="layui-form-label">手机号</label>
				<div class="layui-input-inline">
					<input type="text" id='update_PhoneN' name="phoneNo" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!-- ++++++++++++++++ -->
			 <div class="layui-form-item">
    			<label class="layui-form-label">性别</label>
    			<div class="layui-input-block" class="selSex">
      				<input type="radio" name="sex" value="男" title="男">
      				<input type="radio" name="sex" value="女" title="女">
    			</div>
  	    	</div>
  	    	
		</div>
	</div>
	</form>
	
	<!-- ++++++++++增加++++++++++++++ -->
	<!-- 弹出层 -->
	<form class="layui-form" action="">
	<div hidden id='add_user_div'>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-inline">
					<input type="text" id='add_userN' name="passWord" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!-- +++++++++++++++ -->
			<div class="layui-inline">
				<label class="layui-form-label">手机号</label>
				<div class="layui-input-inline">
					<input type="text" id='add_PhoneN' name="phoneNo" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!-- ++++++++++++++++ -->
			 <div class="layui-form-item">
    			<label class="layui-form-label">性别</label>
    			<div class="layui-input-block" class="selSex">
      				<input type="radio" name="sex" value="男" title="男">
      				<input type="radio" name="sex" value="女" title="女">
    			</div>
  	    	</div>
		</div>
	</div>
</form>
	
	
	<!-- +++++++++++删除++++++++++++++++ -->
	<div hidden id='admin_del'>
		<div class="layui-form-item">
			<div class="layui-inline"  >
				<label class="layui-form-label" style="width:210px;" >是否对选中管理员进行删除操作</label>
			</div>
		</div>
	</div>
	
	<div class="role" hidden>
	<div id="test3" class="demo-transfer"></div>
	</div>
	<script type="text/javascript" src="./js/jquery-3.4.1.min.js" ></script>
	<script src="./layui/layui.all.js" charset="utf-8" ></script>
	
	<script type="text/javascript" charset="utf-8">
	var table = layui.table;
	var layer=layui.layer;
	var $=layui.jquery;
	var form = layui.form;
	var tree=layui.tree;
	$.ajaxSettings.async = false;
	layui.use(['transfer', 'layer', 'util'], function(){
		  var $ = layui.$
		  ,transfer = layui.transfer
		  ,layer = layui.layer
		  ,util = layui.util;
		  //模拟数据
	table.on("toolbar(test)",function(obj){
		var checkStatus=table.checkStatus(obj.config.id);
		switch(obj.event){
		case 'role':
			if(checkStatus.data.length==1){
				//获取参数
				//分配角色
				var role_data;
				//查询数据库中所有的角色
				$.post("sys/selectRole",function(d){
					role_data=d.data;
				});
				//常规用法
				transfer.render({
					id:"demo1"
					/* showCheckbox:true, */
					,elem:"#test3"//默认是点击节点可进行收缩
					,data:role_data
					,title:['全部角色','已选择的角色']
				});
				layer.open({
					type:1,
					title:['用户角色分配','text-align:center;'],
					content:$(".role"),
					area:['480px','470px'],
					btn:['保存','取消'],
					btn1:function(){
						if(transfer.getData('demo1')==""){
							layer.msg("请先选中角色");
						}else{
							var getData=transfer.getData('demo1');
							var checkdata = table.checkStatus('userlist_p').data;
							var checkid = checkdata[0].user_id;
							var zzz="";
							var ggg="";
							for(var i=0;i<getData.length;i++){
								zzz+=getData[i].value+',';
								ggg+=getData[i].title+',';
							}
						location.href="sys/assignR/"+checkid+"/"+zzz+"/"+ggg;
					}
				},btn2:function(){
						//点击取消
						//关闭弹出框
						layer.closeAll();
					}
				});
			}else if(checkStatus.data.length==0){
				layer.msg("请先选中角色");
			}else{
				layer.msg("一次仅能选中一条数据");
				}
			break;
		case 'add':
			 $("#add_userN").val("");
			 $("#add_PhoneN").val("");
				//弹出对话框
				layer.open({
					title:"增加信息",
					type:1,
					content:$("#add_user_div"),
					btn:["保存","关闭"],
					btn1:function(){
						$.post("addUser",{"userName":$("#add_userN").val(),
							"phoneNo":$("#add_PhoneN").val(),
							"sex":$("[name='sex']:checked").val()},
								function(){
							//关闭窗口
							layer.closeAll();
							//列表刷新
							layer.msg("增加成功");
							table.reload("userlist_p");
						});
					}
				});
			break;
		 case 'update':
			if(checkStatus.data.length==1){
				//获取参数
				var checkdata = table.checkStatus('userlist_p').data;
				var checkid = checkdata[0].user_id;
				 $("#update_userN").val(checkdata[0].userName);
				 $("#update_PhoneN").val(checkdata[0].phoneNo);
				 $('input[name="sex"]:checked').val();
					//弹出对话框
					layer.open({
						title:"修改信息",
						type:1,
						content:$("#update_user_div"),
						btn:["保存","关闭"],
						btn1:function(){
							$.post("updateUser",{"user_id":checkid,"userName":$("#update_userN").val(),"phoneNo":$("#update_PhoneN").val(),"sex":$('input[name="sex"]:checked').val()},
									function(){
								//关闭窗口
								layer.closeAll();
								//列表刷新
								layer.msg("修改成功");
								table.reload("userlist_p");
							});
						}
					});
				}else{
					layer.msg("请先选中用户");
					}
			break;
		 }
	});
});
	

	/* +++++++++查询 */
	function user_checkdate(){
		var checktext =$("#checktext").val();
		//数据表格重载
		table.reload("userlist_p",{
			url : "user_list",
			where : {
				"checktext" : checktext
			}
		});
	}
	
	
	/* +++++++++++删除 */
	function user_del(){
		//点击按钮后获取选中的数据行
		var checkdata=table.checkStatus("userlist_p").data;
		
		if(checkdata.length>0){
			//已选中
			//获取ID值--传到Servlet--删除数据
			var adminArray=new Array();
			for(var i=0;i<checkdata.length;i++){
				adminArray[i]=checkdata[i].user_id;
			}
			layer.open({
				title:"删除",
				type:1,
				content:$("#admin_del"),
				btn:["是","否"],
				btn1:function(){
					$.post("deleteUser",{"user_id":adminArray},
							function(){
						//关闭窗口
						layer.closeAll();
						//列表刷新,重新加载列表
						layer.msg("删除成功!!")
						table.reload("userlist_p");
					});
				}
			});
			//console.log(checkStatus.data[0].user_id);
		}else{
			//未选中
			//提示要选中
			layer.msg("请先选中数据!!")
		}
	}
	
	/* +++++++++++++++++++++修改 */
	function user_update() {
		
		var checkdata = table.checkStatus('userlist_p').data;

		if (checkdata.length == 1 ) {
			//已选中
			//获取ID值--传到Servlet--修改数据
			var checkid = checkdata[0].user_id;
			$("#update_name").val(checkdata[0].phoneNo);
			$("#update_pass").val(checkdata[0].passWord);
			//弹出对话框
			layer.open({
				title:"修改信息",
				type:1,
				content:$("#update_user_div"),
				btn:["保存","关闭"],
				btn1:function(){
					$.post("updateUser_p",{"user_id":checkid,"phoneNo":$("#update_name").val(),"passWord":$("#update_pass").val()},
							function(){
						//关闭窗口
						layer.closeAll();
						//列表刷新
						layer.msg("修改成功");
						table.reload("userlist_p");
					});
				}
				
			});
		}else if(checkdata.length > 1){
			layer.msg("一次仅能修改一条数据!");
		} else {
			//未选中
			//提示要选中
			layer.msg("请先选中数据!!");
		}
		
	}
	
	/* ++++++++++++++++++++增加 */
	function user_adddate() {
		 $("#add_name").val("");
		 $("#add_pass").val("");
			//弹出对话框
			layer.open({
				title:"增加信息",
				type:1,
				content:$("#add_user_div"),
				btn:["保存","关闭"],
				btn1:function(){
					$.post("addUser_p",{"phoneNo":$("#add_name").val(),"passWord":$("#add_pass").val()},
							function(){
						//关闭窗口
						layer.closeAll();
						//列表刷新
						layer.msg("增加成功");
						table.reload("userlist_p");
					});
				}
			});
		}
	
	/* ++++++++++++++++++++++++++查询 */
	
	/* function user_checkdate() {
		
		var tet=$("#check_userid").val();
		console.log(tet);
			//弹出对话框
			layer.open({
				title:"查询信息",
				type:1,
				content:$("#check_user_div"),
				btn:["查询","关闭"],
				btn1:function(){
					
					table.reload("userlist",{
						url:"user",
						where:{"param":"getuser",username:$("#check_userid").val()}
					},function(){
						layer.closeAll();
						layer.msg("查询成功");
					});
				}
			});
		} */
	
	
	</script>
</body>
</html>