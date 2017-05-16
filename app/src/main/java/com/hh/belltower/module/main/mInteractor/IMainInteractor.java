package com.hh.belltower.module.main.mInteractor;

import android.app.Activity;

import com.hh.belltower.bean.UserBean;

/**
 * 主页
 * Created by Hh on 2017/3/31.
 */
public interface IMainInteractor {

    interface Model {

        UserBean getUserInfo();

        void getTopImg();
    }

    interface Presenter {
        void presenterInit();
    }


    interface View {

        Activity getMyActivity();

        void init();

        void initFloatMenu();

        void initViewPager();

        void setMDVP();

        void initVpListener();

        void showUserInfo(UserBean userBean);

    }

}
