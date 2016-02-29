package com.commonpro.core;

import com.commonpro.model.UserInfoData;

public interface AppAction {
	
	//用户登录
    public void userLogin(String userName,String pwd, ActionCallbackListener<Void> listener);
    
    //用户信息获取
    public void userInfo(String userName,String pwd, ActionCallbackListener<UserInfoData> listener);
}
