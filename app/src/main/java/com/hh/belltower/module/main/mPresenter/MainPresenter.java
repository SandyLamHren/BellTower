package com.hh.belltower.module.main.mPresenter;

import android.app.Activity;

import com.hh.belltower.module.main.mInteractor.IMainInteractor;
import com.hh.belltower.module.main.mModel.MainModel;

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
        view.showUserInfo(model.getUserInfo());
        view.init();
        view.initFloatMenu();
        view.initVpListener();
        view.initViewPager();
        view.setMDVP();
    }
}
