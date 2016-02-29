package com.commonpro.core;

import android.content.Context;
import android.os.AsyncTask;

import com.commonpro.api.Api;
import com.commonpro.api.ApiImpl;
import com.commonpro.model.ApiResponse;
import com.commonpro.model.UserInfoData;
import com.commonpro.utils.TextUtils;

@SuppressWarnings("unused")
public class AppActionImpl implements AppAction{
    private final static int LOGIN_OS = 1; // ��ʾAndroid
	private final static int PAGE_SIZE = 20; // Ĭ��ÿҳ20��

    private Context context;
    private Api api;

    public AppActionImpl(Context context) {
        this.context = context;
        this.api = new ApiImpl();
    }
    
	@Override
	public void userLogin(final String name, final String pwd,
			final ActionCallbackListener<Void> listener) {
		 // ����Ϊ�ռ��
        if (TextUtils.isEmpty(name)) {
            if (listener != null) {
                listener.onFailure(ErrorEvent.PARAM_NULL, "�û���Ϊ��");
            }	
            return;
        }
        
        // �½��첽����ȥ����Api
        new AsyncTask<Void, Void, ApiResponse<Void>>() {
            @Override
            protected ApiResponse<Void> doInBackground(Void... voids) {
                return api.userLogin(name, pwd);
            }

            @Override
			protected void onProgressUpdate(Void... values) {
            	 if (listener != null) {
            		 listener.onProgress(0, "");//�������ؽӿڿɼ�����ȷ���ui
            	 }
			}

			@Override
            protected void onPostExecute(ApiResponse<Void> response) {
                if (listener != null && response != null) {
                    if (response.isSuccess()) {
                        listener.onSuccess(null);
                    } else {
                        listener.onFailure(response.getEvent(), response.getMsg());
                    }
                }
            }
        }.execute();
	}

	@Override
	public void userInfo(final String name, final String pwd,
			final ActionCallbackListener<UserInfoData> listener) {
		 new AsyncTask<Void, Void, ApiResponse<UserInfoData>>() {
	            @Override
	            protected ApiResponse<UserInfoData> doInBackground(Void... voids) {
	                return api.userInfo(name, pwd);
	            }

	            @Override
	            protected void onPostExecute(ApiResponse<UserInfoData> response) {
	                if (listener != null && response != null) {
	                    if (response.isSuccess()) {
	                        listener.onSuccess(null);
	                    } else {
	                        listener.onFailure(response.getEvent(), response.getMsg());
	                    }
	                }
	            }
	        }.execute();
	}

}
