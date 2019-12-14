package com.great.springboot.testBean;

import org.springframework.stereotype.Component;

@Component
public class relation
{
	private String rid;
	private String roleid;
	private String menuid;

	public relation()
	{
	}

	public relation(String rid, String roleid, String menuid)
	{
		this.rid = rid;
		this.roleid = roleid;
		this.menuid = menuid;
	}

	public String getRid()
	{
		return rid;
	}

	public void setRid(String rid)
	{
		this.rid = rid;
	}

	public String getRoleid()
	{
		return roleid;
	}

	public void setRoleid(String roleid)
	{
		this.roleid = roleid;
	}

	public String getMenuid()
	{
		return menuid;
	}

	public void setMenuid(String menuid)
	{
		this.menuid = menuid;
	}

	@Override
	public String toString()
	{
		return "relation{" + "rid='" + rid + '\'' + ", roleid='" + roleid + '\'' + ", menuid='" + menuid + '\'' + '}';
	}
}
