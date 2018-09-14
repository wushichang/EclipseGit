package com.yidu.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.yidu.bean.UserInfo;
import com.yidu.services.UserService;

@Controller
public class UserInfoController {
	@Autowired
	private UserService userService;
	@RequestMapping("/login")
	public ModelAndView login(UserInfo user,HttpServletResponse response){
		//����ģ����ͼ����
		ModelAndView mv=new ModelAndView();
		//�ж��û��Ƿ��¼�ɹ�
		if(userService.login(user)){
			//���û���Ϣ���뻺����
			response.addCookie(new Cookie("userInfo", user.toString()));
			//���û���Ϣ��������ҳ
			mv.addObject("user", user);
			mv.setViewName("index");
		}else{
			//ȥ��¼ʧ��ҳ��
			mv.setViewName("Fail.jsp");
		}
		return mv;
	}
}
