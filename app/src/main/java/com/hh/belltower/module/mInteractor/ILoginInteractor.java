package com.hh.belltower.module.mInteractor;

import android.app.Activity;

import com.hh.belltower.bean.UserBean;
import com.hh.belltower.retrofit.base.BaseResponse;

/**
 * Created by Hh on 2017/3/27.
 */

public interface ILoginInteractor {

    interface Model {

        void checkUser(String number, String pwd, BaseResponse<UserBean> modelResponse);

        void saveUser(UserBean userBean);

    }

    interface Presenter {

        void doLogin(String user_number, String pwd);

        void destroyMV();

    }


    interface View {

        Activity getMyActivity();

        void loginSucceed();

        void loginFailed();


    }

}
