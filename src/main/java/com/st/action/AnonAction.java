package com.st.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.st.bean.UserBean;
@Controller
public class AnonAction implements ErrorController{

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "error";
	}
	
//	@RequestMapping("/role_page")
////	@RequiresPermissions("user_system")
//	public String role_page() {
//		System.out.println("建立了");
//		return "role";
//	}
	
	@RequestMapping("/error")
	public String error() {
		return "error";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping("/tologin")
	public String tologin() {
		return "tologin";
	}
	
	
	@RequestMapping("/login_system")
	public String login_system(String phoneNo,String userpass,HttpServletRequest request) {
		//生成安全令牌
		UsernamePasswordToken token=new UsernamePasswordToken(phoneNo,userpass);//使用用户名和密码生成安全令牌
		Subject sub=SecurityUtils.getSubject();//获取当前访问用户的对象
		try {
			sub.login(token);//开始登录--执行realm
		}catch(CredentialsException ce) {
			request.setAttribute("msg", ce.getMessage());
			return "login";
		}
		return "system";
	}
	
}
