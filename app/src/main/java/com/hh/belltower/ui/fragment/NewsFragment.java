package com.hh.belltower.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;
import com.haoren.belltower.R;
import com.hh.belltower.adapter.CardRecyclerViewAdapter;
import com.hh.belltower.base.BaseFragment;
import com.hh.belltower.bean.NewsBean;
import com.hh.belltower.constants.Constants;
import com.hh.belltower.retrofit.base.BaseBean;
import com.hh.belltower.retrofit.base.HttpDataListener;
import com.hh.belltower.retrofit.base.MyHttpUtil;
import com.hh.belltower.retrofit.base.MyRetrofit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

/**
 * 首页Tab 对应fragment
 */
public class NewsFragment extends BaseFragment {

    private static final boolean GRID_LAYOUT = false;
    private static final int ITEM_COUNT = 100;

    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;

    private int page_index;

    @Override
    protected void handArguments(Bundle arguments) {
        page_index= arguments.getInt(Constants.KEY_INDEX);
    }

    @Override
    public int getMainContentViewId() {
        return R.layout.fragment_recyclerview;
    }

    @Override
    public void initData() {
        getData();
        initRecycler();
        initViews();
    }

    /**
     * 获取列表数据
     */
    private void getData() {
        HashMap<String, String> parasm = new HashMap<>();
        parasm.put("type", page_index+"");
        MyHttpUtil.getInstance().with(mActivity)
                .setObservable(MyRetrofit.getService().getNewList(parasm))
                .setDataListener(new HttpDataListener<BaseBean<List<NewsBean>>> () {
                    @Override
                    public void onNext(BaseBean data) throws ClassNotFoundException {

                    }
                });
    }

    /**
     * 初始化列表
     */
    private void initRecycler() {

    }


    private void initViews() {
        final List<Object> items = new ArrayList<>();

        for (int i = 0; i < ITEM_COUNT; ++i) {
            items.add(new Object());
        }

        if (GRID_LAYOUT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        mRecyclerView.setAdapter(new CardRecyclerViewAdapter(items));
    }

}
