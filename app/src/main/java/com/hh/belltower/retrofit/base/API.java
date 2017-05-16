package com.hh.belltower.retrofit.base;

import com.hh.belltower.bean.NewsBean;
import com.hh.belltower.bean.UserBean;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * API 基类
 * Created by Hh on 2017/3/30.
 */
public interface API {

    String BASE_URL = "http://192.168.191.1:8080/SchoolLife/";

    @FormUrlEncoded
    @POST("/user/login")
    Observable<BaseBean<UserBean>> login(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("/user/register")
    Observable<BaseBean<UserBean>> register(@FieldMap Map<String, String> map);


    @FormUrlEncoded
    @POST("/news/getNewsList")
    Observable<BaseBean<List<NewsBean>>> getNewList(@FieldMap Map<String, String> map);

}
