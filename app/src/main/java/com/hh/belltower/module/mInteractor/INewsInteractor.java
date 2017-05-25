package com.hh.belltower.module.mInteractor;
import android.support.v7.widget.RecyclerView;

import com.hh.belltower.bean.NewsBean;
import com.hh.belltower.retrofit.base.BaseResponse;

import java.util.HashMap;
import java.util.List;

/**
 * 新闻
 * Created by Hh on 2017/3/31.
 */
public interface INewsInteractor {

    interface Model {
        void getNews(HashMap<String, String> params, BaseResponse<List<NewsBean>> response);
    }

    interface Presenter {
        void getNews(int type, int page);

        void initRecycler(RecyclerView rv);
    }


    interface View {
    }

}
