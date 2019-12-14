package com.great.springboot.testBean;

import java.util.List;

public class TreeBean
{
	private String title;
	private String id;
	private List<TreeBean>children;
	public TreeBean()
	{
	}
	public TreeBean(String title, String id, List<TreeBean> children)
	{
		this.title = title;
		this.id = id;
		this.children = children;
	}



	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public List<TreeBean> getChildren()
	{
		return children;
	}

	public void setChildren(List<TreeBean> children)
	{
		this.children = children;
	}


}
