package com.st.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.st.bean.UserBean;

@Repository
public interface RoleDao {

	List role_list(Map params);
	int getCountRo(Map params);
	List selectRole();
	List selectS();
	List user_list(Map params);
	
	void role_perm(Map map);
	void delRo(String role_id);
	void delUi(String checkid);
	void assignR(Map map);
	String selRN(Map map);
	void insertRN(Map map);
	void assignS(Map map);
	void sendEmail(Map params);
	UserBean getUser(String phoneNo);
	
	List getPermByUserName(String userName);
}
