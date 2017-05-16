package com.hh.belltower.ui.activity;

import android.content.Intent;

import com.hh.belltower.base.BaseActivity;
import com.hh.belltower.constants.Constants;

/**
 * 新闻详情
 * Created by Hh on 2017/5/13.
 */

public class NewsDetailActivity extends BaseActivity {


    private int news_id;

    @Override
    protected void handIntent(Intent intent) {
        news_id = intent.getIntExtra(Constants.KEY_NEWS_ID, 0);
    }

    @Override
    protected int getContentViewId() {
        return 0;
    }

    @Override
    protected void init() {

    }
}
