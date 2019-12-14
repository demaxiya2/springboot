package com.great.springboot.journal;



import com.great.springboot.bean.journal;
import com.great.springboot.service.Iservice;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect  //让这个类变成切点类
@Component  //把这个切面类加载到ioc容器中
public class controllerSomeUser
{
	@Resource
	private Iservice iservice;

	//Controller层切点
	@Pointcut("within(com.great.springboot.controller.controllers)")
	public void controllerAspect()
	{
	}


	@After(value = "controllerAspect()")
	public void doAfter(JoinPoint jionPoint) throws Throwable
	{

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		Object user = request.getSession().getAttribute("USERNAME");
		journal journal = new journal();
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		try
		{
			//获取实例对象名
			String targetName = jionPoint.getTarget().getClass().getName();
			//获取到实例对象名方法名称
			String methodName = jionPoint.getSignature().getName();
			//获取到条件值
			Object[] arguments = jionPoint.getArgs();
			Class targetClass = null;

			targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();

			//1.方法名相同  2.参数个数相同   3.参数的名字对应也相同
			String operationType = "";
			String operationName = "";
			boolean islive = true;

			for (Method method : methods)
			{

				if (method.getName().equals(methodName) && arguments.length == method.getParameterTypes().length)
				{

					Class[] clazzs = method.getParameterTypes();

					for (int i = 0; i < clazzs.length; i++)
					{
						//这里的instance of是为了判断该方法属性是否为该接口的实现类，因为通过反射方法无法获取到真正的接口
						if (arguments[i] instanceof HttpServletRequest && clazzs[i] == HttpServletRequest.class)
						{
							continue;
						}
						if (arguments[i] instanceof HttpServletResponse && clazzs[i] == HttpServletResponse.class)
						{
							continue;
						}
						if (clazzs[i].getName().equals(arguments[i].getClass().getName()))
						{
							continue;
						}
						if (arguments[2] instanceof BindingResult && clazzs[2] == BindingResult.class)
						{
							continue;
						}
						islive = false;
						break;
					}
					if (islive)
					{
						//判断为空的标准是因为每次操作servlet都会执行一次这个操作，但是有的并没有这个注解所以报错
						if (method.getAnnotation(Log.class) != null)
						{
							operationType = method.getAnnotation(Log.class).operationType();
							operationName = method.getAnnotation(Log.class).operationName();
							journal.setUSERNAME(user.toString());
							Date currentDate = new Date();
							journal.setJDATE(sdf.format(currentDate));
							journal.setUSERHANDEL(operationType);
							journal.setDoucmentid(operationName);
							int num = iservice.insertJourel(journal);
						}
					}


				}

			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}


}
