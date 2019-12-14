package com.great.springboot.bean;

import java.util.List;

public class userLimitBean
{
	private int code;
	private String msg;
	private int count;
	private List<userSlectBean>data;


	public userLimitBean()
	{
	}

	public userLimitBean(int code, String msg, int count, List<userSlectBean> data)
	{
		this.code = code;
		this.msg = msg;
		this.count = count;
		this.data = data;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int count)
	{
		this.count = count;
	}

	public List<userSlectBean> getData()
	{
		return data;
	}

	public void setData(List<userSlectBean> data)
	{
		this.data = data;
	}
}
