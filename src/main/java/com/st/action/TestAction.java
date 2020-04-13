	package com.st.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.bean.LayJson;
import com.st.service.ITestService;
import com.st.service.IUserService;

@Controller
public class TestAction {

	@Autowired
	ITestService testS;
	
	@RequestMapping("/addBM")
	@ResponseBody
	public String addBM() {
		testS.addBM();
		return "ceshi";
	}
	
	@RequestMapping("/treeJson")
	@ResponseBody
	public List treeJson() {
		List list=testS.treeJson();
		System.out.println(list);
		return list;
	}
//	@RequestMapping("/index")
//	public String index() {
//		return "index.jsp";
//	}
//	@RequestMapping("/behind")
//	public String behind() {
//		return "behind.jsp";
//	}
//	@RequestMapping("/zzz")
//	public String hhh() {
//		return "userlist_p.jsp";
//	}
//	@RequestMapping("/userlist_p")
//	@ResponseBody
//		public ListJson userlist(@RequestParam Map params) {
//		System.out.println("--------userlist");
//		//需要service实现查询user数据,并且这个方法接受一定的String值
//		List listuser=testS.getRole(params);
//		
//		ListJson layjson=new ListJson(listuser);
//		
////		String strjson=JSONObject.toJSONString(layjson);
//		
//		return layjson;
//	}
	
	@RequestMapping("/rest/{id}/{name}")
	@ResponseBody
	public String rest(@PathVariable String id,@PathVariable String name) {
		return "id:"+id+",name:"+name;
	}
		
		
	}
