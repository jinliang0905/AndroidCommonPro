package com.commonpro.api;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import com.commonpro.model.ApiResponse;
import com.commonpro.model.UserInfoData;
import com.commonpro.utils.HttpEngine;
import com.google.gson.reflect.TypeToken;

public class ApiImpl implements Api {
    private final static String TIME_OUT_EVENT = "CONNECT_TIME_OUT";
    private final static String TIME_OUT_EVENT_MSG = "连接服务器失败";
    
    // http引擎
    private HttpEngine httpEngine;
    
	@Override
	public ApiResponse<Void> userLogin(String name, String pwd) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("method", Api.USER_LOGIN);
		paramMap.put("name", name);
		paramMap.put("pwd", pwd);

		Type type = new TypeToken<ApiResponse<Void>>() {}.getType();
		try {
			return httpEngine.postHandle(paramMap, type);
		} catch (IOException e) {
			return new ApiResponse<Void>(TIME_OUT_EVENT, TIME_OUT_EVENT_MSG);
		}
	}

	@Override
	public ApiResponse<UserInfoData> userInfo(String name, String pwd) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("method", Api.USER_INFO);
		paramMap.put("name", name);
		paramMap.put("pwd", pwd);

		Type type = new TypeToken<ApiResponse<Void>>() {}.getType();
		try {
			return httpEngine.postHandle(paramMap, type);
		} catch (IOException e) {
			return new ApiResponse<UserInfoData>(TIME_OUT_EVENT, TIME_OUT_EVENT_MSG);
		}
	}
}
