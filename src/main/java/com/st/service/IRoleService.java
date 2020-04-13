package com.st.service;

import java.util.List;
import java.util.Map;

import com.st.bean.UserBean;

public interface IRoleService {

	void role_perm(String role_id,String perms);
	void delRo(String role_id);
	void assignR(String checkid,String zzz,String ggg);
	void assignS(String bmName,String zzz);
	void sendEmail(Map params);
	List toList(String perms);
	UserBean getUser(String phoneNo);
	List role_list(Map params);
	int getCountRo(Map params);
	List selectRole();
	List selectS();
	
	List getPermByUserName(String userName);
}
