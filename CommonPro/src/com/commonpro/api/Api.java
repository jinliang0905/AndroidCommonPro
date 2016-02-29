package com.commonpro.api;

import com.commonpro.model.ApiResponse;
import com.commonpro.model.UserInfoData;

public interface Api {
	
	 // 接口对应url方法方法定义(与服务器controller方法mapping保持一致) ========================================
     
	 //用户登录
	 public final static String USER_LOGIN = "userLogin";
	 //读取用户信息
	 public final static String USER_INFO = "userInfo";
	 
	 
	 //接口对应终端方法定义========================================
	 public ApiResponse<Void> userLogin(String name,String pwd);
	 
	 public ApiResponse<UserInfoData> userInfo(String name,String pwd);
}
