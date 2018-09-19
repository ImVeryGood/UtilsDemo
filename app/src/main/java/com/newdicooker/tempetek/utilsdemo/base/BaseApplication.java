package com.newdicooker.tempetek.utilsdemo.base;

import android.app.Application;
import android.content.Context;


/**
 * Created by SPC
 * on 2018/9/19
 * 邮箱：13027699936@163.com.
 * version 2.0.4
 */

public class BaseApplication extends Application {
    public static BaseApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        synchronized (BaseApplication.class) {
            return mContext.getApplicationContext();
        }
    }

    public static BaseApplication getInstance() {
        return mContext;
    }
}
