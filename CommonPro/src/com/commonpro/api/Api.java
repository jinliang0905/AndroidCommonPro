package com.commonpro.api;

import com.commonpro.model.ApiResponse;
import com.commonpro.model.UserInfoData;

public interface Api {
	
	 // �ӿڶ�Ӧurl������������(�������controller����mapping����һ��) ========================================
     
	 //�û���¼
	 public final static String USER_LOGIN = "userLogin";
	 //��ȡ�û���Ϣ
	 public final static String USER_INFO = "userInfo";
	 
	 
	 //�ӿڶ�Ӧ�ն˷�������========================================
	 public ApiResponse<Void> userLogin(String name,String pwd);
	 
	 public ApiResponse<UserInfoData> userInfo(String name,String pwd);
}
