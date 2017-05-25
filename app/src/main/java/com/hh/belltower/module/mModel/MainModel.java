package com.hh.belltower.module.mModel;

import android.app.Activity;

import com.hh.belltower.bean.UserBean;
import com.hh.belltower.constants.Global;
import com.hh.belltower.module.mInteractor.IMainInteractor;

/**
 * Created by Hh on 2017/3/31.
 */

public class MainModel implements IMainInteractor.Model {

    private Activity mActivity;

    public MainModel(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public UserBean getUserInfo() {
        UserBean userBean = Global.getUser();;
        return userBean;
    }

    @Override
    public void getTopImg() {

    }
}
