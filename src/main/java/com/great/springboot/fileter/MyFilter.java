package com.great.springboot.fileter;

import com.great.springboot.controller.IloginInterCeptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyFilter implements WebMvcConfigurer
{
	@Override
	public void addInterceptors(InterceptorRegistry registration){
		registration.addInterceptor(new IloginInterCeptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/loginview","/loginview.jsp","/jsp.jsp","/error")
				.excludePathPatterns("/layui/**","/css/**","/js/**");
	}

}
