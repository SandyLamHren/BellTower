package com.hh.belltower.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.haoren.belltower.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

/**
 * Fragment基类
 * Created by admin on 2016/9/18.
 */
public abstract class BaseFragment extends Fragment {

    protected Activity mActivity;

    protected Context mContext;

    protected View mView = null;

    protected void handArguments(Bundle arguments){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        mContext = getActivity().getApplicationContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mView == null) {
            mView = inflater.inflate(getMainContentViewId(), null);
            //init ButterKnife
            ButterKnife.bind(this, mView);
            //loadDialog
        }
        EventBus.getDefault().register(this);
        //init data
        handArguments(getArguments());
        initData();
        return mView;
    }

    //自定义
    protected Toast showToasty(String title, int icon, int textColor, int bgColor) {
        Toast toast = Toasty.custom(mActivity, title, ContextCompat.getDrawable(mActivity, icon),
                ContextCompat.getColor(mActivity, textColor),
                ContextCompat.getColor(mActivity, bgColor), 1500, true, true);
        toast.show();
        return toast;
    }
    //自定义 icon
    protected Toast showToasty(String title, int icon) {
        Toast toast = Toasty.custom(mActivity, title, ContextCompat.getDrawable(mActivity, icon),
                ContextCompat.getColor(mActivity, R.color.white),
                ContextCompat.getColor(mActivity, R.color.colorPrimaryAlpha), 1500, true, true);
        toast.show();
        return toast;
    }

    //默认
    protected Toast showToasty(String title, boolean withIcon) {
        Toast toast = Toasty.custom(mActivity, title, ContextCompat.getDrawable(mActivity, R.drawable.ic_clear_white),
                ContextCompat.getColor(mActivity, R.color.white),
                ContextCompat.getColor(mActivity, R.color.colorPrimaryAlpha), 1500, withIcon, true);
        toast.show();
        return toast;
    }

    /**
     * 跳转到
     */
    protected void skipTo( Class<?> cls) {
        Intent intent = new Intent(mActivity, cls);
        mActivity.startActivity(intent);
    }

    public abstract int getMainContentViewId();

    public abstract void initData();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void finish(String msg){
    }
}
