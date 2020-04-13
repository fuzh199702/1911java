package com.st.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.st.bean.AnnoRe;
import com.st.bean.BuMen;
import com.st.bean.Customer;
import com.st.bean.Role;
import com.st.bean.User;
import com.st.bean.VisitR;

@Repository
public interface IUserDao {
	List getUser();
	List getGT();
	
	List getBuMen();
	
	List getBuMen2(Map params);
	
	void addUser(Map params);
	void addRole(Map params);
	void addBm(Map params);
	void saveVisitR(Map params);
	void saveAnno(Map params);
	void addCus(Map params);
	void updateUser(Map params);
	void updateRole(Map params);
	void updateBm(Map params);
	void updateCus(Map params);
	void updateDoc(Map params);
	void updateAba(Map params);
	void updateU(Map params);
	void upVisitR(Map params);
	void annoUp(Map params);
	void deleteUser(User user);
	void deleteRole(Role role);
	void deletePerm(Role role);
	void deleteURole(Role role);
	void deleteBm(Map params);
	int selU(Map params);
	void deleteCus(Customer cus);
	void deleteVis(VisitR vis);
	void delAnno(AnnoRe anno);
	List user_list(Map params);
	List selectUser(Map params);
	List dapa_list(Map params);
	List cusT_list(Map params);
	List pubCus_list(Map params);
	List priCus_list(Map params);
	List returnRe(Map params);
	List returnReP(Map params);
	List annoRe(Map params);
	List saveVisit(Map params);
	int getCount(Map params);
	int getCountDa(Map params);
	int getCountCusT(Map params);
	int getCountCusP(Map params);
	int getCountCusPri(Map params);
	int returnReC(Map params);
	int returnReCP(Map params);
	int returnAnno(Map params);
}
