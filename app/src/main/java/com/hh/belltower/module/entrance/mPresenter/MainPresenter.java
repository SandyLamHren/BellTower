package com.hh.belltower.module.entrance.mPresenter;

import android.app.Activity;

import com.hh.belltower.module.entrance.mInteractor.IMainInteractor;
import com.hh.belltower.module.entrance.mModel.MainModel;

/**
 * Created by Hh on 2017/3/31.
 */

public class MainPresenter implements IMainInteractor.Presenter {

    private IMainInteractor.Model model;

    private IMainInteractor.View view;

    public MainPresenter(IMainInteractor.View view, Activity mActivity) {
        this.model = new MainModel(mActivity);
        this.view = view;
    }

    @Override
    public void presenterInit() {
        if (model.getUserInfo() != null) {
            view.showUserInfo(model.getUserInfo());
        }
        view.initToolBar();
        view.initFloatMenu();
        view.initVpListener();
        view.initViewPager();
    }
}
