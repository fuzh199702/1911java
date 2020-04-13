package com.st.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.bean.LayJson;
import com.st.bean.Role;
import com.st.service.IRoleService;

@Controller
@RequestMapping("/sys")
public class RoleAction {

	@Autowired
	IRoleService roleS;
	
	@RequestMapping("/system")
	public String system() {
		return "system";
	}
	/**
	 * 
	 * 跳转到列表页面
	 * @return
	 */
	
	@RequestMapping("/role_page")
//	@RequiresPermissions("user_system")
	public String role_page() {
		return "role";
	}
	@RequestMapping("/user_page")
//	@RequiresPermissions("user_system")
	public String user_page() {
		return "user_p";
	}
	@RequestMapping("/dapa_page")
//	@RequiresPermissions("user_system")
	public String dapa_page() {
		return "dapa";
	}
	@RequestMapping("/cus_page")
//	@RequiresPermissions("user_system")
	public String cus_page() {
		return "cusT";
	}
	@RequestMapping("/pubCus_page")
//	@RequiresPermissions("user_system")
	public String pubCus_page() {
		return "pubCus";
	}
	@RequestMapping("/priCus_page")
//	@RequiresPermissions("user_system")
	public String priCus_page() {
		return "priCus";
	}
	@RequestMapping("/returnRe")
//	@RequiresPermissions("user_system")
	public String returnRe() {
		return "visitR";
	}
	
	@RequestMapping("/visitRe")
//	@RequiresPermissions("user_system")
	public String visitRe() {
		return "visitPR";
	}
	
	@RequestMapping("/annoRe")
//	@RequiresPermissions("user_system")
	public String annoRe() {
		return "annoRe";
	}
	
	@RequestMapping("/register")
//	@RequiresPermissions("user_system")
	public String register() {
		return "register";
	}
	
	
	@RequestMapping("/role_list")
	@ResponseBody
	public LayJson role_list(@RequestParam Map params) {
		int count=roleS.getCountRo(params);
		List listuser=roleS.role_list(params);
//		System.out.println(listuser);
		LayJson layjson=new LayJson(listuser);
//		String strjson=JSONObject.toJSONString(layjson);
		layjson.setData(listuser);
		layjson.setCount(count);
		return layjson;
	}
	
	
	@RequestMapping("/selectRole")
	@ResponseBody
	public LayJson selectRole() {
		List listuser=roleS.selectRole();
		LayJson layjson=new LayJson(listuser);
		return layjson;
	}
	@RequestMapping("/selectS")
	@ResponseBody
	public LayJson selectS() {
		List listuser=roleS.selectS();
		LayJson layjson=new LayJson(listuser);
		return layjson;
	}
	

	
	/**
	 * 跳转到分配权限的页面
	 * @param role_id
	 * @param request
	 * @return
	 */
	@RequestMapping("/role_perm_page/{role_id}")
	public String role_perm_page(@PathVariable String role_id, HttpServletRequest request) {
		request.setAttribute("role_id", role_id);
		return "perm";
	}
	/**
	 * 保存分配的权限
	 * @param role_id
	 * @param perms
	 */
	@RequestMapping("/role_perm/{role_id}/{perms}")
	public String role_perm(@PathVariable String role_id,@PathVariable String perms) {
		roleS.delRo(role_id);
		roleS.role_perm(role_id, perms);
		return "role";
				
	}
	/**
	 * 分配角色的权限
	 * @param role_id
	 * @param perms
	 */
	@RequestMapping("/assignR/{checkid}/{zzz}/{ggg}")
	public String assignR(@PathVariable String checkid,@PathVariable String zzz,@PathVariable String ggg) {
		roleS.assignR(checkid, zzz,ggg);
		return "user_p";
	}
	@RequestMapping("/assignS/{bmName}/{zzz}")
	public String assignS(@PathVariable String bmName,@PathVariable String zzz) {
		roleS.assignS(bmName, zzz);
		return "dapa";
	}
	
	@RequestMapping("/sendEmail")
	@ResponseBody
	public void sendEmail(@RequestParam Map params) {
		roleS.sendEmail(params);
	}
	
}
