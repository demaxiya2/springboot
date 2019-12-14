package com.great.springboot.bean;

public class userSlectBean
{
	private String USERNAME;
	private String USERDATE;
	private String USERPOINT;
	private String USERGODOWN;
	private String USERDOWN;
	private String USERSTATE;

	public userSlectBean()
	{
	}

	public userSlectBean(String USERNAME, String USERDATE, String USERPOINT, String USERGODOWN, String USERDOWN, String USERSTATE)
	{
		this.USERNAME = USERNAME;
		this.USERDATE = USERDATE;
		this.USERPOINT = USERPOINT;
		this.USERGODOWN = USERGODOWN;
		this.USERDOWN = USERDOWN;
		this.USERSTATE = USERSTATE;
	}

	public String getUSERNAME()
	{
		return USERNAME;
	}

	public void setUSERNAME(String USERNAME)
	{
		this.USERNAME = USERNAME;
	}

	public String getUSERDATE()
	{
		return USERDATE;
	}

	public void setUSERDATE(String USERDATE)
	{
		this.USERDATE = USERDATE;
	}

	public String getUSERPOINT()
	{
		return USERPOINT;
	}

	public void setUSERPOINT(String USERPOINT)
	{
		this.USERPOINT = USERPOINT;
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

	public String getUSERSTATE()
	{
		return USERSTATE;
	}

	public void setUSERSTATE(String USERSTATE)
	{
		this.USERSTATE = USERSTATE;
	}
}
