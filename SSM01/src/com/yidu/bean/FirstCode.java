package com.yidu.bean;

import java.util.List;

public class FirstCode {
	private String id;   //�ڵ�ID���Լ���Զ�����ݺ���Ҫ
    private String text; //��ʾ�ڵ��ı� 
    private List<Child> children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Child> getChildren() {
		return children;
	}
	public void setChildren(List<Child> children) {
		this.children = children;
	}
	public FirstCode() {
		super();
	}
	public FirstCode(String id, String text, List<Child> children) {
		super();
		this.id = id;
		this.text = text;
		this.children = children;
	}
    
}
