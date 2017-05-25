package com.hh.belltower.retrofit.base;

/**
 *
 * Created by Hh on 2017/3/31.
 */

public interface BaseResponse<E> {

    void onResponse(BaseBean<E> b);
}
