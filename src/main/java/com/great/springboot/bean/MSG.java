package com.great.springboot.bean;

public class MSG
{
	private String msg;

	public MSG(String msg)
	{
		this.msg = msg;
	}

	public MSG()
	{
	}

	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}

	@Override
	public String toString()
	{
		return "MSG{" + "msg='" + msg + '\'' + '}';
	}
}
