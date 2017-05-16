package com.hh.belltower.module.entrance.mPresenter;

import com.hh.belltower.module.entrance.mInteractor.ILoginInteractor;
import com.hh.belltower.module.entrance.mModel.LoginModel;
import com.hh.belltower.util.StringUtil;

/**
 * Created by Hh on 2017/3/27.
 */
public class LoginPresenter implements ILoginInteractor.Presenter {

    ILoginInteractor.View view;

    ILoginInteractor.Model model;

    public LoginPresenter(ILoginInteractor.View view) {
        this.view = view;
        model = new LoginModel(view.getMyActivity());
    }


    @Override
    public void doLogin(String user_number, String pwd) {
        if (!StringUtil.isSpace(user_number) && !StringUtil.isSpace(pwd)) {
           model.checkUser(user_number, pwd, b -> {
               if (b.getCode() == 0) {
                   view.loginFailed();
               } else {
                   view.loginSucceed();
                   model.saveUser( b.getData());
               }
           });

        }
    }

    @Override
    public void destroyMV() {
        view = null;
        model = null;
    }
}
