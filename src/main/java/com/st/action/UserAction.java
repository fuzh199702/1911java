package com.st.action;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.bean.AnnoRe;
import com.st.bean.Customer;
import com.st.bean.LayJson;
import com.st.bean.Role;
import com.st.bean.User;
import com.st.bean.VisitR;
import com.st.service.IUserService;

@Controller
public class UserAction {

	@Autowired
	IUserService userS;
	
	
	
	@RequestMapping("/sendE")
	@ResponseBody
	public void sendE() throws Exception{
		Properties props=new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		//创建会话
		Session session=Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("fuzh199702@163.com","BWDHWTPEDLNNPSDE");
			}
		});
		//开启调试模式
		session.setDebug(true);
		//获得一个传输者对象
		Transport t=session.getTransport();
		//四个参数--邮箱服务--端口号--账号--登录密码
		t.connect("smtp.163.com", 25, "fuzh199702@163.com", "ning,123");
		//邮件内容
		Message message=new MimeMessage(session);
		message.setFrom(new InternetAddress("fuzh199702@163.com"));
		message.setRecipients(Message.RecipientType.TO, new InternetAddress[] {new InternetAddress("fuzh199702@163.com")});
		message.setSubject("-----标题------------");
		String text="";
		URL url=new URL("http://localhost:8080/emailfile2");
		InputStream is=url.openStream();
		char[] c_arr=new char[1024];
		int l=0;
		Reader r=new InputStreamReader(is);
		while((l=r.read(c_arr))>0) {
			text+=new String(Arrays.copyOf(c_arr, l));
		}
//		message.setContent("------hello ,张维浩-----------------", "text/html;charset=UTF-8");
		message.setContent(text, "text/html;charset=UTF-8");
		//发送邮件
		t.sendMessage(message, message.getAllRecipients());
		//关闭传输者流
		t.close();
	}
	
	@RequestMapping("/emailfile2")
	public String emailfile2() {
		return "2";
	}
	
	@RequestMapping("/getUser")
	@ResponseBody
	public List getUser(@RequestParam Map params) {
		List list=userS.getUser(params);
		return list;
	}
	@RequestMapping("/getGoods")
	@ResponseBody
	public List getGT() {
		List list=userS.getGT();
		return list;
	}
	
//	++++++++++++++++++++++++++++++++++如下有效
	
	@RequestMapping("/selectUser")
	@ResponseBody
	public LayJson getStyle(HttpSession session,@RequestParam Map params) {
		// 需要service实现查询user数据,并且这个方法接受一定的String值
		List list = userS.selectUser(params);
		LayJson layjson = new LayJson(list);
		return layjson;
	}
	
	
	@RequestMapping("/user_list")
	@ResponseBody
	public LayJson user_list(@RequestParam Map params) {
		int count=userS.getCount(params);
		List listuser=userS.user_list(params);
//		System.out.println(listuser);
		LayJson layjson=new LayJson(listuser);
		layjson.setData(listuser);
		layjson.setCount(count);
//		String strjson=JSONObject.toJSONString(layjson);
		return layjson;
	}
	@RequestMapping("/dapa_list")
	@ResponseBody
	public LayJson dapa_list(@RequestParam Map params) {
		int count=userS.getCountDa(params);
		List listuser=userS.dapa_list(params);
//		System.out.println(listuser);
		LayJson layjson=new LayJson(listuser);
		layjson.setData(listuser);
		layjson.setCount(count);
//		String strjson=JSONObject.toJSONString(layjson);
		return layjson;
	}
	@RequestMapping("/cusT_list")
	@ResponseBody
	public LayJson cusT_list(@RequestParam Map params) {
		int count=userS.getCountCusT(params);
		List listuser=userS.cusT_list(params);
//		System.out.println(listuser);
		LayJson layjson=new LayJson(listuser);
		layjson.setData(listuser);
		layjson.setCount(count);
//		String strjson=JSONObject.toJSONString(layjson);
		return layjson;
	}
	@RequestMapping("/pubCus_list")
	@ResponseBody
	public LayJson pubCus_list(@RequestParam Map params) {
		int count=userS.getCountCusP(params);
		List listuser=userS.pubCus_list(params);
//		System.out.println(listuser);
		LayJson layjson=new LayJson(listuser);
		layjson.setData(listuser);
		layjson.setCount(count);
//		String strjson=JSONObject.toJSONString(layjson);
		return layjson;
	}
	
	
	@RequestMapping("/priCus_list")
	@ResponseBody
	public LayJson priCus_list(@RequestParam Map params) {
		int count=userS.getCountCusPri(params);
		List listuser=userS.priCus_list(params);
//		System.out.println(listuser);
		LayJson layjson=new LayJson(listuser);
		layjson.setData(listuser);
		layjson.setCount(count);
//		String strjson=JSONObject.toJSONString(layjson);
		return layjson;
	}
	@RequestMapping("/returnRe")
	@ResponseBody
	public LayJson returnRe(@RequestParam Map params) {
		int count=userS.returnReC(params);
		List listuser=userS.returnRe(params);
		LayJson layjson=new LayJson(listuser);
		layjson.setData(listuser);
		layjson.setCount(count);
		return layjson;
	}
	@RequestMapping("/returnReP")
	@ResponseBody
	public LayJson returnReP(@RequestParam Map params,HttpSession session) {
		params.put("visitUserPhone", 11111);
		int count=userS.returnReCP(params);
		List listuser=userS.returnReP(params);
		LayJson layjson=new LayJson(listuser);
		layjson.setData(listuser);
		layjson.setCount(count);
		return layjson;
	}
	@RequestMapping("/annoRe")
	@ResponseBody
	public LayJson annoRe(@RequestParam Map params,HttpSession session) {
		int count=userS.returnAnno(params);
		List listuser=userS.annoRe(params);
		LayJson layjson=new LayJson(listuser);
		layjson.setData(listuser);
		layjson.setCount(count);
		return layjson;
	}
	
	@RequestMapping("/saveVisit")
	@ResponseBody
	public LayJson saveVisit(@RequestParam Map params) {
		List listuser=userS.saveVisit(params);
		LayJson layjson=new LayJson(listuser);
		return layjson;
	}
	
	
	@RequestMapping("/addUser")
	public String addUser(@RequestParam Map params) {
		userS.addUser(params);
		return "user_p";
	}
	
	@RequestMapping("/addRole")
	public String addRole(@RequestParam Map params) {
		userS.addRole(params);
		return "role";
	}
	
	@RequestMapping("/addBm")
	public String addBm(@RequestParam Map params) {
		userS.addBm(params);
		return "dapa";
	}
	@RequestMapping("/saveVisitR")
	public String saveVisitR(@RequestParam Map params) {
		userS.saveVisitR(params);
		return "priCus";
	}
	
	@RequestMapping("/saveAnno")
	public String saveAnno(@RequestParam Map params) {
		userS.saveAnno(params);
		return "visitR";
	}
	@RequestMapping("/addCus")
	public String addCus(@RequestParam Map params) {
		Customer cus=new Customer();
		cus.setCustomerPublic("public");
		params.put("CustomerPublic", cus.getCustomerPublic());
		userS.addCus(params);
		return "cusT";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(@RequestParam Map params) {
		userS.updateUser(params);
		return "user_p";
	}
	@RequestMapping("/updateRole")
	public String updateRole(@RequestParam Map params) {
		userS.updateRole(params);
		return "role";
	}
	@RequestMapping("/updateBm")
	public String updateBm(@RequestParam Map params) {
		userS.updateBm(params);
		return "dapa";
	}
	@RequestMapping("/updateCus")
	public String updateCus(@RequestParam Map params) {
		userS.updateCus(params);
		return "cusT";
	}
	@RequestMapping("/updateDoc")
	public String updateDoc(@RequestParam Map params,HttpSession session) {
		params.put("business", 11111);
		userS.updateDoc(params);
		return "pubCus";
	}
	@RequestMapping("/updateAba")
	public String updateAba(@RequestParam Map params,HttpSession session) {
//		params.put("business", 11111);
		userS.updateAba(params);
		return "priCus";
	}
	@RequestMapping("/updateU")
	public String updateU(@RequestParam Map params,HttpSession session) {
//		params.put("business", 11111);
		userS.updateU(params);
		return "cusT";
	}
	
	@RequestMapping("/upVisitR")
	public String upVisitR(@RequestParam Map params) {
		userS.upVisitR(params);
		return "visitPR";
	}
	
	@RequestMapping("/annoUp")
	public String annoUp(@RequestParam Map params) {
		System.out.println("jinlaile-------"+params.get("annotationInfo"));
		System.out.println("jinlaileId-------"+params.get("annotation_id"));
		userS.annoUp(params);
		return "annoRe";
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(@RequestParam(value="user_id[]") String[] id) {
		String[] arr=id;
		for(String user_id:arr) {
			User user=new User();
			user.setUser_id(user_id);
			userS.deleteUser(user);
		}
		return "user_p";
	}
	@RequestMapping("/deleteRole")
	public String deleteRole(@RequestParam(value="role_id[]") String[] id) {
		String[] arr=id;
		for(String role_id:arr) {
			Role role=new Role();
			role.setRole_id(role_id);
			userS.deleteRole(role);
		}
		return "role";
	}
//	@RequestMapping("/deleteBm")
//	public String deleteBm(@RequestParam(value="bm_id[]") String[] id) {
//		String[] arr=id;
//		for(String bm_id:arr) {
//			BuMen bm=new BuMen();
//			bm.setBm_id(bm_id);
//			userS.deleteBm(bm);
//		}
//		return "dapa";
//	}
	@RequestMapping("/deleteBm")
	@ResponseBody
	public String deleteBm(@RequestParam Map params) {
		int count=userS.selU(params);
		if(count==0) {
			userS.deleteBm(params);
			return "dapa";
		}else {
			return "1";
		}
	}
	@RequestMapping("/deleteCus")
	public String deleteCus(@RequestParam(value="customer_id[]") String[] id) {
		String[] arr=id;
		for(String customer_id:arr) {
			Customer cus=new Customer();
			cus.setCustomer_id(customer_id);
			userS.deleteCus(cus);
		}
		return "cusT";
	}
	@RequestMapping("/deleteVis")
	public String deleteVis(@RequestParam(value="visit_id[]") String[] id) {
		String[] arr=id;
		for(String visit_id:arr) {
			VisitR vis=new VisitR();
			vis.setVisit_id(visit_id);
			userS.deleteVis(vis);
		}
		return "visitPR";
	}
	@RequestMapping("/delAnno")
	public String delAnno(@RequestParam(value="annotation_id[]") String[] id) {
		String[] arr=id;
		for(String annotation_id:arr) {
			AnnoRe anno=new AnnoRe();
			anno.setAnnotation_id(annotation_id);
			userS.delAnno(anno);
		}
		return "visitPR";
	}
}
