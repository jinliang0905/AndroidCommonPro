package com.commonpro.model;

import java.io.Serializable;

/**
 * �û���Ϣ���ݽṹ
 * �����ݽṹ���������������json����һ��
 * ��HttpEngine��ͨ��GJson�ӿڽ���ת��json==>obj
 * @author liang */
public class UserInfoData implements Serializable {
	
	private static final long serialVersionUID = 1491105535184914808L;
	
	private String userName;
	private String userPwd;
	private int userAge;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	
	
}
