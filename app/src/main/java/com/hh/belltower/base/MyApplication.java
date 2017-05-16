package com.hh.belltower.base;

import android.app.Application;


/**
 * Created by Hh on 2017/3/14.
 */

public class MyApplication extends Application {

    private static MyApplication sInstance;

    /**
     * 获取全局Application对象
     */
    public static MyApplication getInstance() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        //noHttp初始化
    }
}
