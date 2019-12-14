package com.great.springboot.bean;

public class userlast
{
	private String userid;
	private String username;
	private String userps;
	private String userinfor;
	private String usersex;
	private String userpoint;

	public userlast()
	{
	}

	public userlast(String userid, String username, String userps, String userinfor, String usersex, String userpoint)
	{
		this.userid = userid;
		this.username = username;
		this.userps = userps;
		this.userinfor = userinfor;
		this.usersex = usersex;
		this.userpoint = userpoint;
	}

	public String getUserid()
	{
		return userid;
	}

	public void setUserid(String userid)
	{
		this.userid = userid;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getUserps()
	{
		return userps;
	}

	public void setUserps(String userps)
	{
		this.userps = userps;
	}

	public String getUserinfor()
	{
		return userinfor;
	}

	public void setUserinfor(String userinfor)
	{
		this.userinfor = userinfor;
	}

	public String getUsersex()
	{
		return usersex;
	}

	public void setUsersex(String usersex)
	{
		this.usersex = usersex;
	}

	public String getUserpoint()
	{
		return userpoint;
	}

	public void setUserpoint(String userpoint)
	{
		this.userpoint = userpoint;
	}

	@Override
	public String toString()
	{
		return "com.solf.bean.userlast{" + "userid='" + userid + '\'' + ", username='" + username + '\'' + ", userps='" + userps + '\'' + ", userinfor='" + userinfor + '\'' + ", usersex='" + usersex + '\'' + ", userpoint='" + userpoint + '\'' + '}';
	}
}
