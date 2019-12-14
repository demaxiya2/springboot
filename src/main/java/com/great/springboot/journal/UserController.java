package com.great.springboot.journal;

import org.springframework.stereotype.Component;


@Component
public class UserController {

	@Log(operationType = "登入操作", operationName = "管理员登入")
	public void testAOP(String userName, String password){
		System.out.println("UserController被调用了~~~~~~~~~~~~~~~~···");



	}
	
	@Log(operationType = "注册操作", operationName = "管理员操作")
	public void testAOP2(String userName, String password){
		System.out.println("UserController被调用了~~~~~~~~~~~~~~~~···");

	}
	
}