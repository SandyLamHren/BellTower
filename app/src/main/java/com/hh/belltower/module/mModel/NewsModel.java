package com.hh.belltower.module.mModel;

import android.app.Activity;

import com.hh.belltower.bean.NewsBean;
import com.hh.belltower.module.mInteractor.INewsInteractor;
import com.hh.belltower.retrofit.base.BaseResponse;
import com.hh.belltower.retrofit.base.MyHttpUtil;
import com.hh.belltower.retrofit.base.MyRetrofit;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Hh on 2017/5/22.
 */

public class NewsModel implements INewsInteractor.Model{

    private Activity mActivity;


    public NewsModel(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public void getNews(HashMap<String, String> params, BaseResponse<List<NewsBean>> response) {
        MyHttpUtil.getInstance().with(mActivity)
                .setObservable(MyRetrofit.getService().getNewList(params))
                .setDataListener(response::onResponse);
    }
}
