package com.great.springboot.bean;


import org.hibernate.validator.constraints.NotEmpty;

public class userBean
{
	private String USERID;
	@NotEmpty(message = "登录名称不能为空")
	private String USERNAME;
	@NotEmpty(message = "密码不能为空")
	private String USERPS;
	private String USERSEX;
	private String USERINFOR;
	private String USERPOINT;
	@NotEmpty(message = "可以返回")
	private String USEREDUCATION;
	private String USERJOB;
	private String USERPHONE;
	private String USEREM;
	private String USERSTATE;
	private String USERDATE;
	private String USERGODOWN;
	private String USERDOWN;
	private long startIndex;
	private long pageSize;
	public userBean()
	{
	}

	public userBean(String USERID, String USERNAME, String USERPS, String USERSEX, String USERINFOR, String USERPOINT, String USEREDUCATION, String USERJOB, String USERPHONE, String USEREM, String USERSTATE, String USERDATE, String USERGODOWN, String USERDOWN, long startIndex, long pageSize)
	{
		this.USERID = USERID;
		this.USERNAME = USERNAME;
		this.USERPS = USERPS;
		this.USERSEX = USERSEX;
		this.USERINFOR = USERINFOR;
		this.USERPOINT = USERPOINT;
		this.USEREDUCATION = USEREDUCATION;
		this.USERJOB = USERJOB;
		this.USERPHONE = USERPHONE;
		this.USEREM = USEREM;
		this.USERSTATE = USERSTATE;
		this.USERDATE = USERDATE;
		this.USERGODOWN = USERGODOWN;
		this.USERDOWN = USERDOWN;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

	public userBean(String USERID, String USERNAME, String USERPS, String USERSEX, String USERINFOR, String USERPOINT, String USEREDUCATION, String USERJOB, String USERPHONE, String USEREM, String USERSTATE, String USERDATE, String USERGODOWN, String USERDOWN)
	{
		this.USERID = USERID;
		this.USERNAME = USERNAME;
		this.USERPS = USERPS;
		this.USERSEX = USERSEX;
		this.USERINFOR = USERINFOR;
		this.USERPOINT = USERPOINT;
		this.USEREDUCATION = USEREDUCATION;
		this.USERJOB = USERJOB;
		this.USERPHONE = USERPHONE;
		this.USEREM = USEREM;
		this.USERSTATE = USERSTATE;
		this.USERDATE = USERDATE;
		this.USERGODOWN = USERGODOWN;
		this.USERDOWN = USERDOWN;
	}

	@Override
	public String toString()
	{
		return "userBean{" + "USERID='" + USERID + '\'' + ", USERNAME='" + USERNAME + '\'' + ", USERPS='" + USERPS + '\'' + ", USERSEX='" + USERSEX + '\'' + ", USERINFOR='" + USERINFOR + '\'' + ", USERPOINT='" + USERPOINT + '\'' + ", USEREDUCATION='" + USEREDUCATION + '\'' + ", USERJOB='" + USERJOB + '\'' + ", USERPHONE='" + USERPHONE + '\'' + ", USEREM='" + USEREM + '\'' + ", USERSTATE='" + USERSTATE + '\'' + ", USERDATE='" + USERDATE + '\'' + ", USERGODOWN='" + USERGODOWN + '\'' + ", USERDOWN='" + USERDOWN + '\'' + ", startIndex=" + startIndex + ", pageSize=" + pageSize + '}';
	}

	public long getStartIndex()
	{
		return startIndex;
	}

	public void setStartIndex(long startIndex)
	{
		this.startIndex = startIndex;
	}

	public long getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(long pageSize)
	{
		this.pageSize = pageSize;
	}

	public String getUSERID()
	{
		return USERID;
	}

	public void setUSERID(String USERID)
	{
		this.USERID = USERID;
	}

	public String getUSERNAME()
	{
		return USERNAME;
	}

	public void setUSERNAME(String USERNAME)
	{
		this.USERNAME = USERNAME;
	}

	public String getUSERPS()
	{
		return USERPS;
	}

	public void setUSERPS(String USERPS)
	{
		this.USERPS = USERPS;
	}

	public String getUSERSEX()
	{
		return USERSEX;
	}

	public void setUSERSEX(String USERSEX)
	{
		this.USERSEX = USERSEX;
	}

	public String getUSERINFOR()
	{
		return USERINFOR;
	}

	public void setUSERINFOR(String USERINFOR)
	{
		this.USERINFOR = USERINFOR;
	}

	public String getUSERPOINT()
	{
		return USERPOINT;
	}

	public void setUSERPOINT(String USERPOINT)
	{
		this.USERPOINT = USERPOINT;
	}

	public String getUSEREDUCATION()
	{
		return USEREDUCATION;
	}

	public void setUSEREDUCATION(String USEREDUCATION)
	{
		this.USEREDUCATION = USEREDUCATION;
	}

	public String getUSERJOB()
	{
		return USERJOB;
	}

	public void setUSERJOB(String USERJOB)
	{
		this.USERJOB = USERJOB;
	}

	public String getUSERPHONE()
	{
		return USERPHONE;
	}

	public void setUSERPHONE(String USERPHONE)
	{
		this.USERPHONE = USERPHONE;
	}

	public String getUSEREM()
	{
		return USEREM;
	}

	public void setUSEREM(String USEREM)
	{
		this.USEREM = USEREM;
	}

	public String getUSERSTATE()
	{
		return USERSTATE;
	}

	public void setUSERSTATE(String USERSTATE)
	{
		this.USERSTATE = USERSTATE;
	}

	public String getUSERDATE()
	{
		return USERDATE;
	}

	public void setUSERDATE(String USERDATE)
	{
		this.USERDATE = USERDATE;
	}

	public String getUSERGODOWN()
	{
		return USERGODOWN;
	}

	public void setUSERGODOWN(String USERGODOWN)
	{
		this.USERGODOWN = USERGODOWN;
	}

	public String getUSERDOWN()
	{
		return USERDOWN;
	}

	public void setUSERDOWN(String USERDOWN)
	{
		this.USERDOWN = USERDOWN;
	}
}
