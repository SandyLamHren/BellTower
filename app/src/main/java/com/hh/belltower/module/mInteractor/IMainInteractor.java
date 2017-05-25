package com.hh.belltower.module.mInteractor;

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

        void initFloatMenu();

        void initViewPager();

        void initVpListener();

        void showUserInfo(UserBean userBean);

        void initToolBar();
    }

}
