package com.st.shiro;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.st.bean.PermBean;
import com.st.bean.UserBean;
import com.st.service.IRoleService;
@Component
public class MyRealm extends AuthorizingRealm{
	@Autowired
	IRoleService roleS;
	/**
	 * 该方法一定是登录成功之后运行的
	 * 每当需要权限认证时,会执行此方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String username=(String) SecurityUtils.getSubject().getPrincipal();
		List list=roleS.getPermByUserName(username);//PermBean对象的一个集合
		SimpleAuthorizationInfo sai=new SimpleAuthorizationInfo();
		//需要一个字符串的集合
		List<String> str_perm_list=getPermList(list);
		sai.addStringPermissions(str_perm_list);
		return sai;
	}
	
	private List<String> getPermList(List list){
		
		List<PermBean> PBlist=(List<PermBean>)list;
		List<String> str_perm_list=new ArrayList<String>();
		for(PermBean pb:PBlist) {
			str_perm_list.add(pb.getPermCode());
		}
		return str_perm_list;
		
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		//获得用户名和密码
		System.out.println("进realm了");
		String phoneNo=token.getPrincipal().toString();
		String password=new String((char[])token.getCredentials());
//		SimpleHash sh=new SimpleHash("md5", password);
//		sh=new SimpleHash("md5", password,username);
//		sh=new SimpleHash("md5", password,username,12);
//		uuid--盐值
//		uuid+23
//		System.out.println("-----"+sh.toString());
//		sh.setIterations(20);
//		System.out.println(sh.toString());
		//数据库验证是否正确
		System.out.println("-------------------没有做验证");
		UserBean user=roleS.getUser(phoneNo);
		if(user==null||user.getPhoneNo() == null||!password.equals(user.getPassWord())) {
			throw new CredentialsException("密码不正确");
		}
//		else if(password==null){
//			
//		}else {
////			HttpServletRequest request=new HttpServletRequest();
////			HttpSession session = request.getSession();
////			session.setAttribute("business", user.getPhoneNo());
//		}
		return new SimpleAuthenticationInfo(phoneNo, password, getName());
	}


}
