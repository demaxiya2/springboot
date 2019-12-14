package com.great.springboot.bean;

import java.util.List;

public class MangerLimitBean
{
	private int code;
	private String msg;
	private int count;
	private List<MangerDownBean> data;

	public MangerLimitBean()
	{
	}

	public MangerLimitBean(int code, String msg, int count, List<MangerDownBean> data)
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

	public List<MangerDownBean> getData()
	{
		return data;
	}

	public void setData(List<MangerDownBean> data)
	{
		this.data = data;
	}

	@Override
	public String toString()
	{
		return "MangerLimitBean{" + "code=" + code + ", msg='" + msg + '\'' + ", count=" + count + ", data=" + data + '}';
	}
}
