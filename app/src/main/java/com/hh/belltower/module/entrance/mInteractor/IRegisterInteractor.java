package com.hh.belltower.module.entrance.mInteractor;

import android.app.Activity;

import com.hh.belltower.bean.UserBean;
import com.hh.belltower.retrofit.base.BaseResponse;

/**
 * Created by Hh on 2017/3/27.
 */
public interface IRegisterInteractor {

    interface Model {

        void checkUser(String real_name, String number, String pwd, BaseResponse modelResponse);

        void saveUser(UserBean userBean);
    }

    interface Presenter {

        void doRegister(String real_name, String user_number, String pwd);

        void destroyMV();

    }


    interface View {


        Activity getMyActivity();

        void registerSucceed();

        void registerFailed(String msg);

    }

}
