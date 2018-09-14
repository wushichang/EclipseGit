package com.yidu.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yidu.bean.FirstCode;
import com.yidu.bean.MenuInfo;
import com.yidu.bean.UserInfo;
import com.yidu.services.MenuInfoService;

@Controller
public class MenuInfoController {
	@Autowired
	MenuInfoService menuInfoService;
	@RequestMapping("/index")
	public ModelAndView index(UserInfo user){
		//�����û���ŵõ����в˵���Ϣ
		HashMap<String, List<MenuInfo>> map=menuInfoService.selectMenuInfosByUserId(user);
		//����ģ����ͼ����
		ModelAndView mv=new ModelAndView();
		//���û���������ҳ��
		mv.addObject("userName",user.getUserName());
		//���˵���Ϣ���ϴ�����ҳ��
		mv.addObject("menus", map);
		//������ͼ��
		mv.setViewName("YiDu.jsp");
		return mv;
	}
	
	@RequestMapping("/rootManage")
	public @ResponseBody List<FirstCode> rootManage(HttpServletRequest request,int roleId){
		/*System.out.println("����");
		//��ȡ�������û���Ϣ
		Cookie[] cookies=request.getCookies();
		//�����û���Ϣ
		String userInfo="";
		for (Cookie cookie : cookies) {
			if("userInfo".equals(cookie.getName())){
				userInfo=cookie.getValue();
				break;
			}
		}
		//�õ��û��Ľ�ɫ���
		int roleId=Integer.parseInt(userInfo.substring(userInfo.indexOf("=")+1, userInfo.indexOf(",")));*/
		return menuInfoService.selectFirstCodeByRoleId(roleId);
	}
	
}
