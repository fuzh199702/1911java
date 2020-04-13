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
<style id="mouse"></style>
</head>
<body>

<%-- <shiro:hasPermission name="user_del">
		<button class="layui-btn" lay-event="add" onclick='user_adddate()'>增加<button>
</shiro:hasPermission> --%>
<!-- <button class="layui-btn" lay-event="del" onclick='user_del()'>删除<button> -->
<script type="text/html" id="toolbarDemo" >
<div class="layui-form-item">
	<div class="layui-inline">
		<div class="layui-input-inline">
			<input class="layui-input" id="checktext">
		</div>
		<button class="layui-btn" lay-event="checktable" onclick='user_checkdate()'>查询<button>
		<button class="layui-btn" lay-event="anno">批注<button>
		<button class="layui-btn" lay-event="annoRe">批注记录<button>
	</div>
</div>
</script>

<script type="text/html" id="rowbar">
<a class="layui-btn layui-btn-sm" lay-event="edit">编辑</a>
<a class="layui-btn layui-btn-sm" lay-event="fenghao">封号</a>
</script>


	<table class="layui-table" lay-filter="test" lay-data="{url:'returnRe',method:'post',toolbar:'#toolbarDemo',id:'userlist_p',page:true}" >
		<thead>
			<tr>
				<th lay-data="{type:'checkbox'}" ></th>
				<th lay-data="{field:'visit_id',sort:true}">回访ID</th>
				<th lay-data="{field:'visitUserPhone'}">业务员手机号</th>
				<th lay-data="{field:'visitTime'}">回访日期</th>
				<th lay-data="{field:'visitInfo'}">回访内容</th>
				<th lay-data="{field:'visitPattern'}">回访方式</th>
				<th lay-data="{field:'visitPay'}">是否下单</th>
				<th lay-data="{field:'visitMoney'}">下单金额</th>
				<th lay-data="{width:190,toolbar:'#rowbar'}">操作</th>
			</tr>
		</thead>
	</table>
	<!-- +++++++++++++++修改 -->
	<!-- 弹出层 -->
	<form class="layui-form" action="">
	<div hidden id='update_user_div'>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">客户名</label>
				<div class="layui-input-inline">
					<input type="text" id='update_CusN' name="passWord" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!-- +++++++++++++++ -->
			<div class="layui-inline">
				<label class="layui-form-label">联系人姓名</label>
				<div class="layui-input-inline">
					<input type="text" id='update_ConcN' name="phoneNo" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">联系人电话</label>
				<div class="layui-input-inline">
					<input type="text" id='update_ConcP' name="passWord" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!-- +++++++++++++++ -->
			<div class="layui-inline">
				<label class="layui-form-label">联系人邮箱</label>
				<div class="layui-input-inline">
					<input type="text" id='update_ConcE' name="phoneNo" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">联系人地址</label>
				<div class="layui-input-inline">
					<input type="text" id='update_ConcA' name="passWord" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!-- +++++++++++++++ -->
			<!-- <div class="layui-inline">
				<label class="layui-form-label">状态</label>
				<div class="layui-input-inline">
					<input type="text" id='update_state' name="phoneNo" autocomplete="off" class="layui-input">
				</div>
			</div> -->
			<div class="layui-inline">
				<label class="layui-form-label">等级</label>
				<div class="layui-input-inline">
					<input type="text" id='update_grade' name="passWord" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!-- +++++++++++++++ -->
			<!-- <div class="layui-inline">
				<label class="layui-form-label">业务员电话</label>
				<div class="layui-input-inline">
					<input type="text" id='update_userP' name="phoneNo" autocomplete="off" class="layui-input">
				</div>
			</div> -->
		</div>
	</div>
	</form>
	
	<!-- ++++++++++增加++++++++++++++ -->
	<!-- 弹出层 -->
	<form class="layui-form" action="">
	<div hidden id='add_user_div'>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">客户名</label>
				<div class="layui-input-inline">
					<input type="text" id='add_CusN' name="passWord" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!-- +++++++++++++++ -->
			<div class="layui-inline">
				<label class="layui-form-label">联系人姓名</label>
				<div class="layui-input-inline">
					<input type="text" id='add_ConcN' name="phoneNo" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">联系人电话</label>
				<div class="layui-input-inline">
					<input type="text" id='add_ConcP' name="passWord" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!-- +++++++++++++++ -->
			<div class="layui-inline">
				<label class="layui-form-label">联系人邮箱</label>
				<div class="layui-input-inline">
					<input type="text" id='add_ConcE' name="phoneNo" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">联系人地址</label>
				<div class="layui-input-inline">
					<input type="text" id='add_ConcA' name="passWord" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!-- +++++++++++++++ -->
			<!-- <div class="layui-inline">
				<label class="layui-form-label">状态</label>
				<div class="layui-input-inline">
					<input type="text" id='add_state' name="phoneNo" autocomplete="off" class="layui-input">
				</div>
			</div> -->
			<div class="layui-inline">
				<label class="layui-form-label">等级</label>
				<div class="layui-input-inline">
					<input type="text" id='add_grade' name="passWord" autocomplete="off" class="layui-input">
				</div>
			</div>
			<!-- +++++++++++++++ -->
			<!-- <div class="layui-inline">
				<label class="layui-form-label">业务员电话</label>
				<div class="layui-input-inline">
					<input type="text" id='add_userP' name="phoneNo" autocomplete="off" class="layui-input">
				</div>
			</div> -->
		</div>
	</div>
</form>
	<!-- ++++++++++批注++++++++++++++ -->
	<!-- 弹出层 -->
	<form class="layui-form" action="" lay-filter="bbb">
	<div hidden id='visit' style="padding-top:20px;margin-left:50px;">
		<div class="layui-form-item" >
			<!-- ++++++++++++ -->
			<div class="layui-form-item layui-form-text">
			    <label class="layui-form-label">批注内容</label>
			    <div class="layui-input-block" style="width:415px;">
			      <textarea name="desc" id="visitInfo" placeholder="请输入内容" class="layui-textarea"></textarea>
			    </div>
			</div>
		</div>
	</div>
</form>
	
	
	<!-- +++++++++++放弃++++++++++++++++ -->
	<div hidden id='admin_abandon'>
		<div class="layui-form-item">
			<div class="layui-inline"  >
				<label class="layui-form-label" style="width:100px;" >是否放弃该顾客</label>
			</div>
		</div>
	</div>
	
	<input type="hidden" class="visitUser_id">
	
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


	form.on('select(visit)', function(data){
		  if(data.value=="考虑中"||data.value=="拒绝下单"){
			  $("#visitMoney").val("");
			  $("#visitMoney").attr("disabled", true);
			  $("#mouse").html("#visitMoney:hover{cursor:not-allowed;}");
			}else{
			$("#visitMoney").attr("disabled", false);
			$("#mouse").html("");
			}
		});   
	
	  var laydate = layui.laydate;
	  //常规用法
	  laydate.render({
	    elem: '#test1'
	  });

	
	layui.use(['transfer', 'layer', 'util'], function(){
		  var $ = layui.$
		  ,transfer = layui.transfer
		  ,layer = layui.layer
		  ,util = layui.util;
		  //模拟数据
		  
	
	table.on("toolbar(test)",function(obj){
		var checkStatus=table.checkStatus(obj.config.id);
		switch(obj.event){
		case 'abandon':
			if(checkStatus.data.length==1){
				//获取参数
				//分配角色
				var checkdata = table.checkStatus('userlist_p').data;
				var checkid = checkdata[0].customer_id;
				layer.open({
					type:1,
					title:"放弃",
					content:$("#admin_abandon"),
					btn:['是','否'],
					btn1:function(){
						$.post("updateAba",{"customer_id":checkid},
								function(){
							//关闭窗口
							layer.closeAll();
							//列表刷新
							layer.msg("放弃成功");
							table.reload("userlist_p");
						});
						/* location.href="sys/assignDoc/"+checkid+"/"+zzz; */
				},btn2:function(){
						//点击取消
						//关闭弹出框
						layer.closeAll();
						table.reload("userlist_p");
					}
				});
			}else{
				layer.msg("请选中客户");
			 	}
			break;
		case 'anno':
			if(checkStatus.data.length==1){
				//获取参数
				//分配角色
				var checkdata = table.checkStatus('userlist_p').data;
				var checkid = checkdata[0].visit_id;
				var visitUserPhone = checkdata[0].visitUserPhone;
				$("#visitInfo").val("");
				layer.open({
					type:1,
					title:"批注",
					content:$("#visit"),
					btn:['保存','取消'],
					area:['700px','260px'],
					btn1:function(){
						if($("#visitInfo").val()==""){
							layer.msg("批注内容不能为空");
						}else{
							$.post("saveAnno",{"annotationVisit_id":checkid,"annotationInfo":$("#visitInfo").val(),"annotationUserPhone":visitUserPhone},
									function(){
								//关闭窗口
								layer.closeAll();
								//列表刷新
								layer.msg("保存成功");
								table.reload("userlist_p");
							});
						}
						/* location.href="sys/assignDoc/"+checkid+"/"+zzz; */
				},btn2:function(){
						//点击取消
						//关闭弹出框
						layer.closeAll();
						table.reload("userlist_p");
					}
				});
			}else{
				layer.msg("请选中客户");
			 	}
			break;
		case 'annoRe':
			window.location.href="sys/annoRe";
			break;
		 case 'update':
			if(checkStatus.data.length==1){
				//获取参数
				var checkdata = table.checkStatus('userlist_p').data;
				var checkid = checkdata[0].customer_id;
				 $("#update_CusN").val(checkdata[0].customerName);
				 $("#update_ConcN").val(checkdata[0].contactName);
				 $("#update_ConcP").val(checkdata[0].customerTel);
				 $("#update_ConcE").val(checkdata[0].customerEmail);
				 $("#update_ConcA").val(checkdata[0].customerAddr);
				 $("#update_state").val(checkdata[0].state);
				 $("#update_grade").val(checkdata[0].customerGrade);
				 $("#update_userP").val(checkdata[0].userPhone);
					//弹出对话框
					layer.open({
						title:"修改信息",
						type:1,
						content:$("#update_user_div"),
						btn:["保存","关闭"],
						btn1:function(){
							$.post("updateCus",{"customer_id":checkid,"customerName":$("#update_CusN").val(),
								"contactName":$("#update_ConcN").val(),
								"customerTel":$("#update_ConcP").val(),
								"customerEmail":$("#update_ConcE").val(),
								"customerAddr":$("#update_ConcA").val(),
								"state":$("#update_state").val(),
								"customerGrade":$("#update_grade").val(),
								"userPhone":$("#update_userP").val()},
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
			url : "returnRe",
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
				adminArray[i]=checkdata[i].customer_id;
			}
			layer.open({
				title:"删除",
				type:1,
				content:$("#admin_del"),
				btn:["是","否"],
				btn1:function(){
					$.post("deleteCus",{"customer_id":adminArray},
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