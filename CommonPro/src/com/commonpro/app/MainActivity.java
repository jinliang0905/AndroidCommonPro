package com.commonpro.app;

import android.os.Bundle;

import com.commonpro.core.ActionCallbackListener;

public class MainActivity extends BaseActivity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mAppAction.userLogin("123", "456", new ActionCallbackListener<Void>() {
			@Override
			public void onSuccess(Void data) { }
			
			@Override
			public void onProgress(int progress, String desc) { }
			
			@Override
			public void onFailure(String errorEvent, String message) { }
		});
    }

    
}
