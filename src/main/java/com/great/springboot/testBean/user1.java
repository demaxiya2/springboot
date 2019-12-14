package com.great.springboot.testBean;

import org.springframework.stereotype.Component;

@Component
public class user1
{
	private String roleid;
	private String username;

	public user1()
	{
	}

	public user1(String roleid, String username)
	{
		this.roleid = roleid;
		this.username = username;
	}

	public String getRoleid()
	{
		return roleid;
	}

	public void setRoleid(String roleid)
	{
		this.roleid = roleid;
	}

	public String getUsername()
	{
		return username;
	}

	@Override
	public String toString()
	{
		return "user1{" + "roleid='" + roleid + '\'' + ", username='" + username + '\'' + '}';
	}

	public void setUsername(String username)
	{
		this.username = username;
	}
}
