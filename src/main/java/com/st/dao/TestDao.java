package com.st.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public interface TestDao {
	
	void addBM(Map params);
	
	List treeJson();
	List getRole(Map params);
	
}
