package com.great.springboot.service;

import com.great.springboot.bean.*;
import com.great.springboot.infince.nameSpace;
import com.great.springboot.testBean.menu1;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class Iservice
{
	@Resource
	private nameSpace nameSpace;

	@Transactional
	public List<userBean> loginView(userBean userBean){
		return nameSpace.loginView(userBean);
	}
	@Transactional
	public List<menuBean> selectAllmeanBean(){
		return nameSpace.selectAllmeanBean();
	}
	@Transactional
	public List<userSlectBean> getAllMap(userBean userBean){
		return nameSpace.getAllMap(userBean);
	}
	@Transactional
	public Integer countUser(userBean userBean){
		return nameSpace.countUser(userBean);
	}

	@Transactional
	public int deleteUser(String userName){
		return nameSpace.deleteUser(userName);
	}

	@Transactional
	public int insertUser(userBean userBean){
		return nameSpace.insertUser(userBean);
	}

	@Transactional
	public int insertJourel(journal journal){
		return nameSpace.insertJourel(journal);
	}
	@Transactional
	public int insertMenu(String roleid,List<Integer>list){
		return nameSpace.insertMenu(roleid,list);
	}
	@Transactional
	public List<menu1> selectSuper(String username,String roleid){
		return nameSpace.selectSuper(username,roleid);
	}
	@Transactional
	public int deleteMenu(String roleid,List<Integer>list){
		return nameSpace.deleteMenu(roleid, list);
	}
	@Transactional
	public int registerUser(userlast userlast){
		return nameSpace.registerUser(userlast);
	}
	@Transactional
	public List<MangerDownBean> mangerDown(String userDown,Integer startIndex,Integer pageSize){
		return nameSpace.mangerDown(userDown, startIndex, pageSize);
	}
	@Transactional
	public int countDown(String userDown){
		return nameSpace.countDown(userDown);
	}
}
