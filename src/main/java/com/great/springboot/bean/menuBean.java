package com.great.springboot.bean;

/**
 * 菜单表
 */
public class menuBean
{
	private String MENUID;
	private String MENUNAME;
	private String MENUIDD;
	private String MENUURL;

	public menuBean(String MENUID, String MENUNAME, String MENUIDD, String MENUURL)
	{
		this.MENUID = MENUID;
		this.MENUNAME = MENUNAME;
		this.MENUIDD = MENUIDD;
		this.MENUURL = MENUURL;
	}

	public menuBean()
	{
	}

	public String getMENUID()
	{
		return MENUID;
	}

	public void setMENUID(String MENUID)
	{
		this.MENUID = MENUID;
	}

	public String getMENUNAME()
	{
		return MENUNAME;
	}

	public void setMENUNAME(String MENUNAME)
	{
		this.MENUNAME = MENUNAME;
	}

	public String getMENUIDD()
	{
		return MENUIDD;
	}

	public void setMENUIDD(String MENUIDD)
	{
		this.MENUIDD = MENUIDD;
	}

	public String getMENUURL()
	{
		return MENUURL;
	}

	public void setMENUURL(String MENUURL)
	{
		this.MENUURL = MENUURL;
	}
}
