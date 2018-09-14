package com.yidu.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bean.Child;
import com.yidu.bean.FirstCode;
import com.yidu.bean.MenuInfo;
import com.yidu.bean.UserInfo;
import com.yidu.dao.MenuInfoInter;

@Service
public class MenuInfoService {
	@Autowired
	MenuInfoInter menuInfoInter;
	public HashMap<String,List<MenuInfo>> selectMenuInfosByUserId(UserInfo user){
		//�����˵���Ϣӳ��
		HashMap<String,List<MenuInfo>> map=new HashMap<String,List<MenuInfo>>();
		//�����û���ŵĵ��˵���Ϣ����
		List<MenuInfo> menus=menuInfoInter.selectMenuInfosByUserId(user);
		//���������˵�����
		List<MenuInfo> secondMenu=null;
		//����һ���˵����
		String menuId="";
		//�����˵�ӳ��
		String key="";
		for (MenuInfo menuInfo : menus) {
			if("root".equals(menuInfo.getPid())){
				//�õ�һ���˵�����
				key=menuInfo.getTitle();
				//���ö����˵�����
				secondMenu=new ArrayList<MenuInfo>();
				//�õ�һ���˵����
				menuId=menuInfo.getMenuId();
				//���˵�װ��ӳ��
				map.put(key, secondMenu);
			}else if(menuId.equals(menuInfo.getPid())){
				//�õ������˵���Ϣ
				secondMenu.add(menuInfo);
			}
		}
		return map;
	}
	
	public List<FirstCode> selectFirstCodeByRoleId(int roleId){
		//��ѯ���в˵�
		List<MenuInfo> list=menuInfoInter.selectAll();
		//��ѯĳ����ɫ��Ӧ�Ĳ˵�
		List<MenuInfo> list2=menuInfoInter.selectMenuInfosByRoleId(roleId);
		//��������һ�����󼯺�
		List<FirstCode> tree=new ArrayList<FirstCode>();
		//���������Ӽ��ļ���
		List<Child> children=null;
		//��������һ������
		FirstCode firstCode=null;
		//����һ���˵����
		String menuId="";
		for (MenuInfo menuInfo : list) {
			//�õ�һ���˵���Ϣ
			if("root".equals(menuInfo.getPid())){
				//�õ�һ���˵����
				menuId=menuInfo.getMenuId();
				//��������Ӽ��ռ�
				children=new ArrayList<Child>();
				firstCode=new FirstCode(menuInfo.getMenuId(), menuInfo.getTitle(), children);
				tree.add(firstCode);
			}else if(menuId.equals(menuInfo.getPid())){
				//���������Ӽ�����ֵ
				boolean checked=false;
				for (MenuInfo menuInfo2 : list2) {
					if(menuInfo.getMenuId().equals(menuInfo2.getMenuId())){
						checked=true;
						break;
					}
				}
				children.add(new Child(menuInfo.getMenuId(), menuInfo.getTitle(), checked));
			}
		}
		return tree;
	}
}
