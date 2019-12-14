package com.great.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.SpringServletContainerInitializer;

public class ServletInitAlizer extends SpringBootServletInitializer
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
		return applicationBuilder.sources(SpringbootApplication.class);
	}
}
