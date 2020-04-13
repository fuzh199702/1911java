package com.st.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.bean.UserBean;
import com.st.dao.RoleDao;
import com.st.service.IRoleService;
import com.st.util.Email;
import com.st.util.Page;
@Service
public class RoleService implements IRoleService{

	@Autowired
	RoleDao roleD;
	
	public UserBean getUser(String phoneNo) {
		return roleD.getUser(phoneNo);
	}
	
	public List role_list(Map params) {
		Page.pageParams(params);
		return roleD.role_list(params);
	}
	
	@Override
	public int getCountRo(Map params) {
		// TODO Auto-generated method stub
		int count=roleD.getCountRo(params);
		return count;
	}
	
	public List selectRole() {
		return roleD.selectRole();
	}
	public List selectS() {
		return roleD.selectS();
	}
	
	public List getPermByUserName(String userName) {
		return roleD.getPermByUserName(userName);
	}
	
	/**
	 * 
	 */
	public void assignR(String checkid,String zzz,String ggg) {
		//1.将perms转为集合
		List list =toList(zzz);
		Map map=new HashMap();
		map.put("user_id", checkid);
		map.put("zzz", list);
		String ggS=ggg.substring(0, ggg.length()-1);
		map.put("userRo", ggS);
		roleD.delUi(checkid);
		roleD.assignR(map);
		roleD.insertRN(map);
	}
	public void assignS(String bmName,String zzz) {
		//1.将perms转为集合
		List list =toList(zzz);
		Map map=new HashMap();
		map.put("bmName", bmName);
		for (Object str : list) {
            map.put("user_id", str);
    		roleD.assignS(map);
        }
	}
	
	public void delRo(String role_id) {
		//1.将perms转为集合
		roleD.delRo(role_id);
	}
	
	/**
	 * 保存角色和权限的关联
	 */
	public void role_perm(String role_id,String perms) {
		//1.将perms转为集合
		List list =toList(perms);
		Map map=new HashMap();
		map.put("role_id", role_id);
		map.put("perms", list);
		roleD.role_perm(map);
	}
	
	
	public List toList(String perms) {
		List list=new ArrayList();
		String[] perm_arr=perms.split(",");
		for(String str:perm_arr) {
			if(!str.trim().equals("")) {
				list.add(str);
			}
		}
		return list;
	}
	
	public void sendEmail(Map params) {
		String title=params.get("title").toString();
		String info=params.get("info").toString();
		String email_arr=params.get("email_arr").toString();
		String[] email_str_arr=email_arr.split(",");
		try {
			Email.sendEmail(title, info, email_str_arr);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
