package com.yidu.bean;

public class Child {
	private String id;   //�ڵ�ID���Լ���Զ�����ݺ���Ҫ
    private String text; //��ʾ�ڵ��ı� 
    private boolean checked; //��ʾ�ýڵ��Ƿ�ѡ��
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
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public Child() {
		super();
	}
	public Child(String id, String text, boolean checked) {
		super();
		this.id = id;
		this.text = text;
		this.checked = checked;
	}
    
    
}