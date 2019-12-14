package com.great.springboot.controller;



import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.great.springboot.bean.*;
import com.great.springboot.infince.nameSpace;
import com.great.springboot.journal.Log;
import com.great.springboot.service.Iservice;
import com.great.springboot.testBean.TreeBean;
import com.great.springboot.testBean.menu1;
import com.sun.deploy.net.HttpResponse;
import com.sun.net.httpserver.HttpsServer;
import net.minidev.json.JSONObject;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.System.out;
import static java.lang.System.setOut;


//表示为控制层
@Controller
public class controllers
{
	@Resource
	private Iservice iservice;
	Gson gs = new Gson();
	userLimitBean ul = new userLimitBean();
	private String userName = null;
	int page = 1;
	String menuname = null;
	List<menu1> m1 = new ArrayList<>();
	private String uploadFilePath;
	SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
	int point=50;
	//	@RequestMapping 除了可以使用请求URL 映射请求外，还可以使用请求方法、请求参数及请求头映射请求。
	//
	//2.@RequestMapping 的value、method、params及heads分别表示请求URL、请求方法、
	// 请求参数及请求头的映射条件，他们之间是与的关系，联合使用多个条件可以让请求映射更加精确化。
	@RequestMapping("/handleRequest.action")
	//	value = "/handleRequest",metnon = requestMethon.post/get
	protected ModelAndView handleRequest()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loginview");
		return modelAndView;
	}

	//登入操作
	@RequestMapping(value = "/wangleai.action", produces = {"application/json;charset=utf-8"})
	@Log(operationType = "登入操作", operationName = "管理员登入")
	protected String login(HttpServletRequest request, @Validated userBean userBean, BindingResult bindingResult)
	{

		StringBuilder stringBuilder = new StringBuilder();
		if (bindingResult != null && bindingResult.hasErrors())
		{
			List<ObjectError> list = bindingResult.getAllErrors();
			for (ObjectError error : list)
			{
				stringBuilder.append(error.getDefaultMessage()).append(",");
			}
		}
		Map<String, List<menuBean>> map = new HashMap<>();
		userName = request.getParameter("USERNAME");
		String userPs = request.getParameter("USERPS");
		userBean us = new userBean();
		us.setUSERNAME(userName);
		us.setUSERPS(userPs);
		List<userBean> list = iservice.loginView(us);
		if (list.size() > 0)
		{
			request.setAttribute("success1", "success1");
			request.getSession().setAttribute("user", list.get(0));
			List<menuBean> list2 = iservice.selectAllmeanBean();

			for (int i = 0; i < list2.size(); i++)
			{
				if (list2.get(i).getMENUID().equals(list2.get(i).getMENUIDD()))
				{
					List<menuBean> list1 = new ArrayList<>();
					for (int j = 0; j < list2.size(); j++)
					{
						if (list2.get(j).getMENUIDD().equals(list2.get(i).getMENUIDD()) && !list2.get(j).getMENUID().equals(list2.get(i).getMENUIDD()))
						{
							list1.add(list2.get(j));
						}
					}
					map.put(list2.get(i).getMENUNAME(), list1);
				}
			}
			request.setAttribute("map", map);
			System.out.println(userName);
			request.getSession().setAttribute("USERNAME", userName);
			return "registerView";
		} else
		{
			request.setAttribute("success1", "success1");

		}

		return "loginview";
	}


	//用户管理的ajax表格操作
	@RequestMapping("/allUser.action")
	@ResponseBody
	protected userLimitBean AallUser(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		String str1 = request.getParameter("page");
		page = Integer.valueOf(str1);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		userBean us = new userBean();
		us.setStartIndex((page - 1) * 5);
		us.setPageSize(5);
		List<userSlectBean> list = iservice.getAllMap(us);
		ul.setData(list);
		Integer x = iservice.countUser(us);
		ul.setCount(x % 5 == 0 ? x / 5 : x / 5 + 1);
		return ul;

	}

	//页面跳转
	@RequestMapping("/web/{url}")
	protected String login(@PathVariable(value = "url") String path)
	{

		return path;
	}

	@RequestMapping("/tansferAll.action")
	@ResponseBody
	protected String menuTransfer(HttpServletRequest request)
	{
		menuname = request.getParameter("msg");
		if (menuname != null)
		{
			if (menuname.equals("公司领导"))
			{
				menuname = "2";
			}
			if (menuname.equals("小秘"))
			{
				menuname = "3";
			}
		} else
		{
			menuname = "1";
		}
		ArrayList<TreeBean> list = new ArrayList<>();
		List<Integer> list2 = new ArrayList();
		m1 = iservice.selectSuper(null, menuname);
		Gson gson = new Gson();
		for (menu1 menu1 : m1)
		{
			TreeBean treeBean = new TreeBean();
			ArrayList<TreeBean> list1 = new ArrayList<>();
			if (menu1.getMenuid().equals(menu1.getMenutwoid()))
			{
				treeBean.setId(menu1.getMenuid());
				treeBean.setTitle(menu1.getMenuname());
				for (int i = 0; i < m1.size(); i++)
				{
					TreeBean treeBean1 = new TreeBean();
					if (m1.get(i).getMenutwoid().equals(menu1.getMenuid()) && !m1.get(i).equals(menu1))
					{
						treeBean1.setId(m1.get(i).getMenuid());
						treeBean1.setTitle(m1.get(i).getMenuname());
						list2.add(Integer.valueOf(m1.get(i).getMenuid()));
						list1.add(treeBean1);

					}
					treeBean.setChildren(list1);
				}
				list.add(treeBean);
			}
		}
		String res = null;
		if (menuname.equals("1"))
		{
			res = gson.toJson(list);
		} else
		{
			res = gson.toJson(list2);
		}
		System.out.println(res);
		return res;
	}

	@RequestMapping("/addMenu.action")
	@ResponseBody
	protected JSONObject addMenu(HttpServletRequest request)
	{
		String msg = request.getParameter("msg");
		Gson gs = new Gson();

		List<TreeBean> list = gs.fromJson(msg, new TypeToken<List<TreeBean>>() {}.getType());
		List<Integer> menu1s = new ArrayList<>();
		List<Integer> menuls2 = new ArrayList<>();
		//将前段传回来的菜单值做循环遍历出所有的id值并做判断
		for (TreeBean treeBean : list)
		{
			for (TreeBean child : treeBean.getChildren())
			{
				menu1s.add(Integer.valueOf(child.getId()));
			}
			menu1s.add(Integer.valueOf(treeBean.getId()));
		}
		//将原先传给前段复选的值遍历取出id与提交修改时的长度做判断看是否有过修改
		for (int i = 0; i < m1.size(); i++)
		{
			menuls2.add(Integer.valueOf(m1.get(i).getMenuid()));
		}
		JSONObject jsonObject = new JSONObject();
		//menuls2 原菜单 menu1s 新菜单
		if (menu1s.containsAll(menuls2) && menuls2.size() == menu1s.size())
		{
			jsonObject.put("msg", "contion");
		} else if (menuls2.size() < menu1s.size())
		{
			menu1s.removeAll(menuls2);
			int num = iservice.insertMenu(menuname, menu1s);
			if (num > 0)
			{
				jsonObject.put("msg", "insert");
			} else
			{
				jsonObject.put("msg", "insertFail");
			}
		} else if (menuls2.size() > menu1s.size())
		{
			menuls2.removeAll(menu1s);
			System.out.println(menuls2.size() + "menuls2");
			int num = iservice.deleteMenu(menuname, menuls2);
			if (num > 0)
			{
				jsonObject.put("msg", "del");
			} else
			{
				jsonObject.put("msg", "delFail");
			}

		}

		System.out.println(jsonObject.toString());
		return jsonObject;
	}

	@RequestMapping(value = "/uploadFile.action")
	@ResponseBody
	@Log(operationType = "文件上传 ", operationName = "管理员操作")
	protected JSONObject uploadFile(MultipartFile file)
	{

		try
		{
			file.transferTo(new File("C:\\Users\\40651\\Desktop\\u10\\" + file.getOriginalFilename()));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		JSONObject resObj = new JSONObject();
		resObj.put("msg", "success");
		return resObj;

	}

	@RequestMapping("/deleteUser.action")
	@ResponseBody
	@Log(operationType = "删除用户 ", operationName = "管理员操作")
	protected JSONObject deleteUser(HttpServletRequest request)
	{
		String str = request.getParameter("msg");
		int num = iservice.deleteUser(str);
		JSONObject resObj = new JSONObject();
		if (num > 0)
		{
			resObj.put("msg", "success");
		} else
		{
			resObj.put("msg", "fail");
		}
		return resObj;
	}


	//添加用户
	@RequestMapping("/insertUser.action")
	@ResponseBody
	@Log(operationType = "添加操作", operationName = "管理员操作")
	protected JSONObject insertUser(HttpServletRequest request)
	{
		String str = request.getParameter("msg");
		userBean userBean = new userBean();
		String userMsg[] = str.split("=");
		userBean.setUSERNAME(userMsg[0]);
		userBean.setUSERPS(userMsg[1]);
		userBean.setUSERPHONE(userMsg[2]);
		int num = iservice.insertUser(userBean);
		JSONObject jsonObject = new JSONObject();
		if (num > 0)
		{
			jsonObject.put("msg", "success");
		} else
		{
			jsonObject.put("msg", "fail");
		}
		return jsonObject;
	}

	//文件下载
	@RequestMapping("/downloadFile.action")
	@ResponseBody
	protected void downloadFile(String fileName1, String filePath, HttpServletResponse response)
	{

			/*String downloadFilePath = filePath;
			String fileName = fileName1;//被下载文件的名称*/
		//			D:\springboot\src\main\resources\static\filePath\新建文本文档 (5).txt
		//			static/filePath/新建文本文档 (5).txt
		response.setCharacterEncoding("UTF-8");
		response.setContentType("txt");
		String fileff = "传一刘德华.txt";
		try
		{
			response.setHeader("Content-Disposition", "attachment;fileName=" + new String(fileff.getBytes(), "iso8859-1"));
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		File file = new File("C:\\Users\\40651\\Desktop\\新建文本文档 (5).txt");
		System.out.println(file.getAbsolutePath());
		if (file.exists())
		{
			System.out.println("文件有找到");
			try
			{
				BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
				BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
				byte[] bytes = new byte[1024];
				int len = 0;
				while ((len = bis.read(bytes)) != -1)
				{
					bos.write(bytes, 0, len);
					bos.flush();
				}
				bos.close();
				bis.close();
				System.out.println("写出完毕");
			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		} else
		{
			System.out.println("文件没找到");
		}


	}

	//用户注册
	@RequestMapping("/register.action")
	protected String addUser(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String userName = request.getParameter("title");
		String userps = request.getParameter("password");
		String sex = request.getParameter("sex");
		String userInforMation = request.getParameter("information");
		String education = request.getParameter("education");
		String work = request.getParameter("work");
		String email =request.getParameter("email");
		String phoneNum = request.getParameter("phoneNum");
		Date currentDate = new Date();
		String userDate = sdf.format(currentDate);
		userlast userlast = new userlast();
		userlast.setUsername(userName);;
		userlast.setUserps(userps);
		userlast.setUsersex(sex);
		userlast.setUserinfor(userInforMation);
		userlast.setUserpoint(String.valueOf(point));
		int num = iservice.registerUser(userlast);
		if (num>0){
			return "loginview";
		}
		return "jsp";
	}
	@RequestMapping("/manger.action")
	@ResponseBody
	protected MangerLimitBean mangerDown(HttpServletResponse response,HttpServletRequest request) throws UnsupportedEncodingException
	{
		String str1 = request.getParameter("page");
		String downName = request.getParameter("downName");
		page = Integer.valueOf(str1);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String startPage = String.valueOf((page - 1) * 5);
		String pageSize = "5";
		List<MangerDownBean> mg = iservice.mangerDown(downName,Integer.valueOf(startPage),Integer.valueOf(pageSize));
		int count = iservice.countDown(downName);
		MangerLimitBean limitBean = new MangerLimitBean();
		limitBean.setCount(count % 5 == 0 ? count / 5 : count / 5 + 1);
		limitBean.setData(mg);
		return limitBean;
	}
}

