package com.hh.belltower.ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.haoren.belltower.R;
import com.hh.belltower.base.BaseFragment;
import com.hh.belltower.bean.BaseEvent;
import com.hh.belltower.constants.Constants;
import com.hh.belltower.module.mInteractor.INewsInteractor;
import com.hh.belltower.module.mPresenter.NewsPresenter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

/**
 * 首页Tab 对应fragment
 */
public class NewsFragment extends BaseFragment implements INewsInteractor.View {

    @BindView(R.id.recyclerView)
    RecyclerView rv_news;

    @BindView(R.id.swipe)
    SwipeRefreshLayout swipe;

    private int page_index;

    private NewsPresenter presenter;

    private int page = 1;

    private boolean isViesble = false;

    private boolean isPrepared = false;

    @Override
    protected void handArguments(Bundle arguments) {
        page_index = arguments.getInt(Constants.KEY_INDEX);
    }

    @Override
    public int getMainContentViewId() {
        return R.layout.fragment_recyclerview;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isViesble = isVisibleToUser;
        if (isVisibleToUser && isPrepared) {
            presenter.getNews(page_index, page);
        }
    }

    @Override
    public void initData() {
        presenter = new NewsPresenter(mActivity);
        presenter.initRecycler(rv_news);
        setBottomMore();
        isPrepared = true;
        if (page_index == 0) {
            presenter.getNews(page_index, page);
        }
        swipe.setOnRefreshListener(() -> presenter.getNews(page_index, 1));
    }

    /**
     * 上滑加载更多
     */
    private boolean isOnce = true;
    private void setBottomMore() {
        rv_news.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (!rv_news.canScrollVertically(1)) { //底部
                    if (isOnce) {
                        page++;
                        presenter.getNews(page_index,page);
                    }
                    isOnce = false;
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(BaseEvent baseEvent) {
        if (baseEvent.getCode() == BaseEvent.CANCLE_REFRESH) {
            swipe.setRefreshing(false);
        }
    }


}
