package com.hh.belltower.retrofit.base;

/**
 * 请求回调接口
 * Created by Hh on 2017/3/30.
 */
public interface HttpDataListener<E> {
    void onNext(BaseBean<E> data) throws  ClassNotFoundException;
}
