package com.great.springboot.controller;


import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IloginInterCeptor implements HandlerInterceptor
{
	@Override
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception
	{

		String url = httpServletRequest.getRequestURI();
		String contextPath = httpServletRequest.getContextPath();
		//登入界面
		if (url.endsWith("/loginview"))
		{

			return true;
		}
		//注册界面
		if (url.endsWith("/register.action")||url.endsWith("/jsp")){
			return true;
		}
		if (url.endsWith("/wangleai.action"))
		{
			if (httpServletRequest.getParameter("USERNAME") == null || httpServletRequest.getParameter("USERPS") == null)
			{
				httpServletResponse.sendRedirect(contextPath + "/web/loginview");
			}else {
				return true;
			}
		}
		if (httpServletRequest.getSession().getAttribute("USERNAME") == null)
		{
			httpServletResponse.sendRedirect(contextPath + "/web/loginview");
		} else
		{
			return true;
		}
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception
	{

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception
	{

	}
}
