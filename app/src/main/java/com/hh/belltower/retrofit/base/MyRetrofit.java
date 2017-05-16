package com.hh.belltower.retrofit.base;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hh on 2017/3/30.
 */
public class MyRetrofit {

    private static final int TIME_OUT = 15;

    private API mAPI;

    private volatile static MyRetrofit singleton;

    private MyRetrofit() {

        //配置拦截器
        //分四种级别
        // None->无打印日志
        // Basic打印请求类型，URL，请求体大小，返回值状态以及返回值的大小
        // Header打印返回请求和返回值的头部信息，请求类型，URL以及返回值状态码
        // Body打印请求和返回值的头部和body信息
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);//拦截器级别
        //Okhttp初优化
        Retrofit retrofit = new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(API.BASE_URL)
                .build();
        mAPI = retrofit.create(API.class);
    }

    public static MyRetrofit getInstance() {
        if (singleton == null) {
            synchronized (MyRetrofit.class) {
                if (singleton == null) {
                    singleton = new MyRetrofit();
                }
            }
        }
        return singleton;
    }

    public static API getService() {
        return getInstance().mAPI;
    }


}
