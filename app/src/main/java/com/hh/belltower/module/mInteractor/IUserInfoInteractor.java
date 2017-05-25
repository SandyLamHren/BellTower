package com.hh.belltower.module.mInteractor;

import com.hh.belltower.bean.UserBean;

/**
 * 个人信息
 * Created by Hh on 2017/3/31.
 */
public interface IUserInfoInteractor {

    interface Model {

    }

    interface Presenter {

    }


    interface View {
        void showUserInfo(UserBean userBean);
    }

}
