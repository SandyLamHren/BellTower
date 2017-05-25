package com.hh.belltower.module.mPresenter;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.haoren.belltower.R;
import com.hh.belltower.adapter.NewsAdapter;
import com.hh.belltower.bean.BaseEvent;
import com.hh.belltower.bean.NewsBean;
import com.hh.belltower.module.mInteractor.INewsInteractor;
import com.hh.belltower.module.mModel.NewsModel;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Hh on 2017/5/22.
 */

public class NewsPresenter implements INewsInteractor.Presenter {

    private INewsInteractor.View view;

    private NewsModel model;

    private NewsAdapter adapter;

    private Activity mActivity;

    private ArrayList<NewsBean> datas = new ArrayList<>();

    public NewsPresenter(Activity mActivity) {
        this.mActivity = mActivity;
        model = new NewsModel(mActivity);
    }

    @Override
    public void getNews(int type, int page) {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", type + "");
        params.put("page", page + "");
        model.getNews(params, b -> {
            datas.clear();
            datas.addAll(b.getData());
            adapter.notifyDataSetChanged();
            EventBus.getDefault().post(new BaseEvent(BaseEvent.CANCLE_REFRESH));
        });

    }

    @Override
    public void initRecycler(RecyclerView rv) {
        rv.setLayoutManager(new LinearLayoutManager(mActivity));
        rv.setHasFixedSize(true);
        rv.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        adapter = new NewsAdapter(mActivity, R.layout.list_item_card_small, datas);
        rv.setAdapter(adapter);
    }
}
