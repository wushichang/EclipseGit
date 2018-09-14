package com.yidu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.yidu.bean.UserBean;

public class UserController extends MultiActionController{
	/*此处为实现Contoller接口需要重写的方法
	 * @Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println(request.getParameter("userName"));
		return null;
	}*/
	
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response,UserBean user) throws Exception {
		System.out.println(user.getUserName());
		return null;
	}
	
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("已进入register");
		return null;
	}
}
