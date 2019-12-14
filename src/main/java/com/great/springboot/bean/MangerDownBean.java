package com.great.springboot.bean;

/**
 * @author 40651
 * 文档审核bean
 */
public class MangerDownBean
{
	private String DOWNID;
	private String DOWNNAME;
	private String USERNAME;
	private String DOWNDATE;
	private String DOWNPOINT;
	private String DOWNTYPE;
	private String DOWNEXAM;

	public MangerDownBean()
	{
	}

	public MangerDownBean(String DOWNNAME, String USERNAME, String DOWNDATE, String DOWNPOINT, String DOWNTYPE, String DOWNEXAM)
	{
		this.DOWNNAME = DOWNNAME;
		this.USERNAME = USERNAME;
		this.DOWNDATE = DOWNDATE;
		this.DOWNPOINT = DOWNPOINT;
		this.DOWNTYPE = DOWNTYPE;
		this.DOWNEXAM = DOWNEXAM;
	}

	public MangerDownBean(String DOWNID, String DOWNNAME, String USERNAME, String DOWNDATE, String DOWNPOINT, String DOWNTYPE, String DOWNEXAM)
	{
		this.DOWNID = DOWNID;
		this.DOWNNAME = DOWNNAME;
		this.USERNAME = USERNAME;
		this.DOWNDATE = DOWNDATE;
		this.DOWNPOINT = DOWNPOINT;
		this.DOWNTYPE = DOWNTYPE;
		this.DOWNEXAM = DOWNEXAM;
	}

	public String getDOWNID()
	{
		return DOWNID;
	}

	public void setDOWNID(String DOWNID)
	{
		this.DOWNID = DOWNID;
	}

	public String getDOWNNAME()
	{
		return DOWNNAME;
	}

	public void setDOWNNAME(String DOWNNAME)
	{
		this.DOWNNAME = DOWNNAME;
	}

	public String getUSERNAME()
	{
		return USERNAME;
	}

	public void setUSERNAME(String USERNAME)
	{
		this.USERNAME = USERNAME;
	}

	public String getDOWNDATE()
	{
		return DOWNDATE;
	}

	public void setDOWNDATE(String DOWNDATE)
	{
		this.DOWNDATE = DOWNDATE;
	}

	public String getDOWNPOINT()
	{
		return DOWNPOINT;
	}

	public void setDOWNPOINT(String DOWNPOINT)
	{
		this.DOWNPOINT = DOWNPOINT;
	}

	public String getDOWNTYPE()
	{
		return DOWNTYPE;
	}

	public void setDOWNTYPE(String DOWNTYPE)
	{
		this.DOWNTYPE = DOWNTYPE;
	}

	public String getDOWNEXAM()
	{
		return DOWNEXAM;
	}

	public void setDOWNEXAM(String DOWNEXAM)
	{
		this.DOWNEXAM = DOWNEXAM;
	}

	@Override
	public String toString()
	{
		return "MangerDownBean{" + "DOWNID='" + DOWNID + '\'' + ", DOWNNAME='" + DOWNNAME + '\'' + ", USERNAME='" + USERNAME + '\'' + ", DOWNDATE='" + DOWNDATE + '\'' + ", DOWNPOINT='" + DOWNPOINT + '\'' + ", DOWNTYPE='" + DOWNTYPE + '\'' + ", DOWNEXAM='" + DOWNEXAM + '\'' + '}';
	}
}
