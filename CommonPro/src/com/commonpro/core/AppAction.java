package com.commonpro.core;

import com.commonpro.model.UserInfoData;

public interface AppAction {
	
	//�û���¼
    public void userLogin(String userName,String pwd, ActionCallbackListener<Void> listener);
    
    //�û���Ϣ��ȡ
    public void userInfo(String userName,String pwd, ActionCallbackListener<UserInfoData> listener);
}
