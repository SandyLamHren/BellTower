package com.hh.belltower.module.entrance.mModel;

import android.app.Activity;

import com.alibaba.fastjson.JSON;
import com.hh.belltower.bean.UserBean;
import com.hh.belltower.constants.SharePref;
import com.hh.belltower.module.entrance.mInteractor.IRegisterInteractor;
import com.hh.belltower.retrofit.base.MyRetrofit;
import com.hh.belltower.retrofit.base.MyHttpUtil;
import com.hh.belltower.retrofit.base.BaseResponse;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hh on 2017/3/27.
 */
public class RegisterModel implements IRegisterInteractor.Model {

    private Activity mActivity;

    public RegisterModel(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public void checkUser(String real_name, String number, String pwd, BaseResponse modelResponse) {
        Map<String, String> params = new HashMap<>();
        params.put("real_name", real_name);
        params.put("user_number", number);
        params.put("pwd", pwd);
        MyHttpUtil.getInstance().with(mActivity).
                setObservable(MyRetrofit.getService().register(params))
                .setDataListener(modelResponse::onResponse);
    }

    @Override
    public void saveUser(UserBean userBean) {
        SharePref.saveString(SharePref.USER_BEAN, JSON.toJSONString(userBean));
        SharePref.saveString(SharePref.PASSWORD, userBean.getPwd());
    }
}
