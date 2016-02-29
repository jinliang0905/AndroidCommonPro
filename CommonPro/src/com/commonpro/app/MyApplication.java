package com.commonpro.app;

import android.app.Application;

import com.commonpro.core.AppAction;
import com.commonpro.core.AppActionImpl;

public class MyApplication extends Application{
	private AppAction appAction;

    @Override
    public void onCreate() {
        super.onCreate();
        appAction = new AppActionImpl(this);
    }

    public AppAction getAppAction() {
        return appAction;
    }
}
