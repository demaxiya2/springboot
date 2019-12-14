package com.great.springboot.bean;

public class journal
{
	private String JID;
	private  String JDATE;
	private String USERNAME;
	private String USERHANDEL;
	private String doucmentid;

	public journal()
	{
	}

	public journal(String JID, String JDATE, String USERNAME, String USERHANDEL, String doucmentid)
	{
		this.JID = JID;
		this.JDATE = JDATE;
		this.USERNAME = USERNAME;
		this.USERHANDEL = USERHANDEL;
		this.doucmentid = doucmentid;
	}

	public journal(String JDATE, String USERNAME, String USERHANDEL, String doucmentid)
	{
		this.JDATE = JDATE;
		this.USERNAME = USERNAME;
		this.USERHANDEL = USERHANDEL;
		this.doucmentid = doucmentid;
	}

	public String getJID()
	{
		return JID;
	}

	public void setJID(String JID)
	{
		this.JID = JID;
	}

	public String getJDATE()
	{
		return JDATE;
	}

	public void setJDATE(String JDATE)
	{
		this.JDATE = JDATE;
	}

	public String getUSERNAME()
	{
		return USERNAME;
	}

	public void setUSERNAME(String USERNAME)
	{
		this.USERNAME = USERNAME;
	}

	public String getUSERHANDEL()
	{
		return USERHANDEL;
	}

	public void setUSERHANDEL(String USERHANDEL)
	{
		this.USERHANDEL = USERHANDEL;
	}

	public String getDoucmentid()
	{
		return doucmentid;
	}

	public void setDoucmentid(String doucmentid)
	{
		this.doucmentid = doucmentid;
	}

	@Override
	public String toString()
	{
		return "journal{" + "JID='" + JID + '\'' + ", JDATE='" + JDATE + '\'' + ", USERNAME='" + USERNAME + '\'' + ", USERHANDEL='" + USERHANDEL + '\'' + ", doucmentid='" + doucmentid + '\'' + '}';
	}
}
