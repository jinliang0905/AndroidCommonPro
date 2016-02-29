package com.commonpro.model;

import java.io.Serializable;

/**
 * 用户信息数据结构
 * 该数据结构必须与服务器返回json保持一致
 * 在HttpEngine中通过GJson接口进行转换json==>obj
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
