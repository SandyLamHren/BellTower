package com.hh.belltower.module.mModel;

import android.app.Activity;

import com.alibaba.fastjson.JSON;
import com.hh.belltower.bean.UserBean;
import com.hh.belltower.constants.Global;
import com.hh.belltower.module.mInteractor.ILoginInteractor;
import com.hh.belltower.retrofit.base.BaseResponse;
import com.hh.belltower.retrofit.base.MyHttpUtil;
import com.hh.belltower.retrofit.base.MyRetrofit;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hh on 2017/3/27.
 */
public class LoginModel implements ILoginInteractor.Model {

    private Activity mActivity;

    public LoginModel(Activity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public void checkUser(String number, String pwd, BaseResponse<UserBean> modelResponse) {
        Map<String, String> params = new HashMap<>();
        params.put("user_number", number);
        params.put("pwd", pwd);
        MyHttpUtil.getInstance().with(mActivity)
                .setObservable(MyRetrofit.getService().login(params))
                .setDataListener(modelResponse::onResponse);
    }


    @Override
    public void saveUser(UserBean userBean) {
        Global.saveUser(JSON.toJSONString(userBean));
        Global.saveUserName(userBean.getUser_number());
        Global.savePassword(userBean.getPwd());
    }
}
