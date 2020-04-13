package com.st.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.st.bean.AnnoRe;
import com.st.bean.Customer;
import com.st.bean.Role;
import com.st.bean.User;
import com.st.bean.VisitR;
import com.st.dao.IUserDao;
import com.st.service.IUserService;
import com.st.util.Page;
@Service
public class UserService implements IUserService{

	@Autowired
	IUserDao userD;
	
	@Override
	public void addUser(Map params) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		params.put("user_id", uuid);
		userD.addUser(params);
	}
	@Override
	public void addRole(Map params) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		params.put("role_id", uuid);
		userD.addRole(params);
	}
	@Override
	public void addBm(Map params) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		params.put("bm_id", uuid);
		userD.addBm(params);
	}
	@Override
	public void saveVisitR(Map params) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		params.put("visit_id", uuid);
		userD.saveVisitR(params);
	}
	@Override
	public void saveAnno(Map params) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		params.put("annotation_id", uuid);
		userD.saveAnno(params);
	}
	@Override
	public void addCus(Map params) {
		// TODO Auto-generated method stub
		String uuid=UUID.randomUUID().toString();
		params.put("customer_id", uuid);
		userD.addCus(params);
	}
	@Override
	public void updateUser(Map params) {
		// TODO Auto-generated method stub
		userD.updateUser(params);
	}
	@Override
	public void updateRole(Map params) {
		// TODO Auto-generated method stub
		userD.updateRole(params);
	}
	@Override
	public void updateBm(Map params) {
		// TODO Auto-generated method stub
		userD.updateBm(params);
	}
	@Override
	public void updateCus(Map params) {
		// TODO Auto-generated method stub
		userD.updateCus(params);
	}
	@Override
	public void updateDoc(Map params) {
		// TODO Auto-generated method stub
		userD.updateDoc(params);
	}
	@Override
	public void updateAba(Map params) {
		// TODO Auto-generated method stub
		userD.updateAba(params);
	}
	@Override
	public void updateU(Map params) {
		// TODO Auto-generated method stub
		userD.updateU(params);
	}
	@Override
	public void upVisitR(Map params) {
		// TODO Auto-generated method stub
		userD.upVisitR(params);
	}
	@Override
	public void annoUp(Map params) {
		// TODO Auto-generated method stub
		userD.annoUp(params);
	}
	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		userD.deleteUser(user);
	}
	@Override
	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
		userD.deleteRole(role);
		userD.deletePerm(role);
		userD.deleteURole(role);
	}
	@Override
	public void deleteBm(Map params) {
		// TODO Auto-generated method stub
		userD.deleteBm(params);
	}
	@Override
	public int selU(Map params) {
		// TODO Auto-generated method stub
		int countU=userD.selU(params);
		return countU;
	}
	@Override
	public void deleteCus(Customer cus) {
		// TODO Auto-generated method stub
		userD.deleteCus(cus);
	}
	@Override
	public void deleteVis(VisitR vis) {
		// TODO Auto-generated method stub
		userD.deleteVis(vis);
	}
	@Override
	public void delAnno(AnnoRe anno) {
		// TODO Auto-generated method stub
		userD.delAnno(anno);
	}
	
	@Override
	public List getUser() {
		// TODO Auto-generated method stub
		//List list=userD.getUser();
		List list=userD.getBuMen();
		return list;
	}
	
	public List user_list(Map params) {
		Page.pageParams(params);
		return userD.user_list(params);
	}
	@Override
	public List<User> selectUser(Map params) {
		// TODO Auto-generated method stub
		List list=userD.selectUser(params);
		return list;
	}
	public List dapa_list(Map params) {
		Page.pageParams(params);
		return userD.dapa_list(params);
	}
	public List cusT_list(Map params) {
		Page.pageParams(params);
		return userD.cusT_list(params);
	}
	public List pubCus_list(Map params) {
		Page.pageParams(params);
		return userD.pubCus_list(params);
	}
	public List priCus_list(Map params) {
		Page.pageParams(params);
		return userD.priCus_list(params);
	}
	public List returnRe(Map params) {
		Page.pageParams(params);
		return userD.returnRe(params);
	}
	public List returnReP(Map params) {
		Page.pageParams(params);
		return userD.returnReP(params);
	}
	public List annoRe(Map params) {
		Page.pageParams(params);
		return userD.annoRe(params);
	}
	public List saveVisit(Map params) {
		return userD.saveVisit(params);
	}
	
	@Override
	public int getCount(Map params) {
		// TODO Auto-generated method stub
		int count=userD.getCount(params);
		return count;
	}
	@Override
	public int getCountDa(Map params) {
		// TODO Auto-generated method stub
		int count=userD.getCountDa(params);
		return count;
	}
	@Override
	public int getCountCusT(Map params) {
		// TODO Auto-generated method stub
		int count=userD.getCountCusT(params);
		return count;
	}
	@Override
	public int getCountCusP(Map params) {
		// TODO Auto-generated method stub
		int count=userD.getCountCusP(params);
		return count;
	}
	@Override
	public int getCountCusPri(Map params) {
		// TODO Auto-generated method stub
		int count=userD.getCountCusPri(params);
		return count;
	}
	public int returnReC(Map params) {
		// TODO Auto-generated method stub
		int count=userD.returnReC(params);
		return count;
	}
	public int returnReCP(Map params) {
		// TODO Auto-generated method stub
		int count=userD.returnReCP(params);
		return count;
	}
	public int returnAnno(Map params) {
		// TODO Auto-generated method stub
		int count=userD.returnAnno(params);
		return count;
	}
	
	@Override
	public List getUser(Map params) {
		// TODO Auto-generated method stub
		//List list=userD.getUser();
		List list=userD.getBuMen2(params);
		return list;
	}
	
	@Override
	public List getGT() {
		// TODO Auto-generated method stub
		//List list=userD.getUser();
		List list=userD.getGT();
		return list;
	}

}
