package com.st.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.st.dao.IUserDao;
import com.st.dao.TestDao;
import com.st.service.ITestService;
import com.st.service.IUserService;
@Service
public class TestService implements ITestService{

	@Autowired
	TestDao testD;
	
	public List treeJson() {
		return testD.treeJson();
	}
	
//	食物处理器    编程式事务
	@Autowired
	TransactionTemplate transT;
	//这一个方法作为一个事务  一般业务操作在service层
	//注解式事务
	//@Transactional
	@Override
	public void addBM() {
		// TODO Auto-generated method stub
		//List list=userD.getUser();
//		新增部门数据
//		新增两个部门信息 uuid bmName--Map
		//事务--整体--
		//1
//		匿名类对象
		transT.execute(new TransactionCallback<Boolean>() {

			@Override
			public Boolean doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub
				try {
					Map map=new HashMap();
					UUID uuid=UUID.randomUUID();
					map.put("uuid", uuid.toString());
					map.put("bmName", "人力部");
					testD.addBM(map);
					//System.out.println(1/0);
					//2
					uuid=UUID.randomUUID();
					map.put("uuid", uuid.toString());
					map.put("bmName", "市场部");
					testD.addBM(map);
				} catch (Exception e) {
					status.setRollbackOnly();
					e.printStackTrace();
					// TODO: handle exception
					return false;
				}
				return true;
			}
			
		});
		
	}
	
	@Override
	public List getRole(Map params) {
		// TODO Auto-generated method stub
		List list=testD.getRole(params);
		return list;
	}
	
//	Map map=new HashMap();
//	UUID uuid=UUID.randomUUID();
//	map.put("uuid", uuid.toString());
//	map.put("bmName", "人力部");
//	testD.addBM(map);
////	System.out.println(1/0);
//	//2
//	uuid=UUID.randomUUID();
//	map.put("uuid", uuid.toString());
//	map.put("bmName", "市场部");
//	testD.addBM(map);

}
