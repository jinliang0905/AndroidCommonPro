package com.commonpro.app;

import com.commonpro.core.AppAction;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity{
	protected AppAction mAppAction = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 mAppAction = ((MyApplication)this.getApplication()).getAppAction();
	}

}
