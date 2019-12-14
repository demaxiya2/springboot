package com.great.springboot.testBean;

import org.springframework.stereotype.Component;

@Component
public class menu1
{
	private String menuid;
	private String menuname;
	private String menutwoid;

	public menu1()
	{
	}

	public menu1(String menuid, String menuname)
	{
		this.menuid = menuid;
		this.menuname = menuname;
	}

	public menu1(String menuid, String menuname, String menutwoid)
	{
		this.menuid = menuid;
		this.menuname = menuname;
		this.menutwoid = menutwoid;
	}

	public String getMenuid()
	{
		return menuid;
	}

	public void setMenuid(String menuid)
	{
		this.menuid = menuid;
	}

	public String getMenuname()
	{
		return menuname;
	}

	public void setMenuname(String menuname)
	{
		this.menuname = menuname;
	}

	public String getMenutwoid()
	{
		return menutwoid;
	}

	public void setMenutwoid(String menutwoid)
	{
		this.menutwoid = menutwoid;
	}

	@Override
	public String toString()
	{
		return "relation{" + "menuid='" + menuid + '\'' + ", menuname='" + menuname + '\'' + ", menutwoid='" + menutwoid + '\'' + '}';
	}
}
