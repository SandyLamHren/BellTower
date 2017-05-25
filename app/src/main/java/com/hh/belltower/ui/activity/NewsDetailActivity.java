package com.hh.belltower.ui.activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.haoren.belltower.R;
import com.hh.belltower.base.BaseFullActivity;
import com.hh.belltower.bean.NewsBean;
import com.hh.belltower.constants.Constants;
import com.hh.belltower.retrofit.base.API;

import butterknife.BindView;

/**
 * 新闻详情
 * Created by Hh on 2017/5/13.
 */

public class NewsDetailActivity extends BaseFullActivity {
    @BindView(R.id.content)
    TextView tv_content;

    @BindView(R.id.title)
    TextView tv_title;

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbar_layout;

    private NewsBean newsBean;

    @Override
    protected void handIntent(Intent intent) {
        newsBean = (NewsBean) intent.getSerializableExtra(Constants.KEY_NEWS);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_news_detail;
    }

    @Override
    protected void init() {
        setContent();
    }


    private void setContent() {
        Glide.with(getApplicationContext()).load(API.BASE_URL+newsBean.getImg()).into(new SimpleTarget<GlideDrawable>() {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                toolbar_layout.setBackground(resource);
            }
        });
        tv_content.setText(newsBean.getContent());
        tv_title.setText(newsBean.getTitle());
        toolbar_layout.setTitle("新闻详情");
    }
}
