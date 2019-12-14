package com.great.springboot.infince;



import com.great.springboot.bean.*;
import com.great.springboot.testBean.menu1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface nameSpace
{

	public List<userBean> loginView(userBean userBean);
	public List<menuBean> selectAllmeanBean();

	/**
	 * @param userBean
	 * @return 分页操作
	 */
	public List<userSlectBean> getAllMap(userBean userBean);

	/**
	 * @param userBean
	 * @return 获取总页数
	 */
	public Integer countUser(userBean userBean);

	//用户管理操作
	public int deleteUser(String userName);
	//添加用户
	public int insertUser(userBean userBean);
	//添加日志操作
	public int insertJourel(journal journal);
	//查询用户权限菜单
	public List<menu1> selectSuper(@Param("username")String username,@Param("roleid")String roleid );
	//添加菜单
	public int insertMenu(@Param("roleid")String roleid,@Param("list")List<Integer> list);
	//删除权限
	public int deleteMenu(@Param("roleid")String roleid,@Param("list")List<Integer> list);
	//用户注册
	public int registerUser(userlast userlast);
	//查询总条数
	public int countDown(@Param("DOWNNAME") String DOWNNAME);
	//分页查询文档
	public List<MangerDownBean> mangerDown(@Param("DOWNNAME")String DOWNNAME,
	    @Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);


}
