package com.hh.belltower.module.entrance.mPresenter;

import com.hh.belltower.constants.Constants;
import com.hh.belltower.module.entrance.mInteractor.IRegisterInteractor;
import com.hh.belltower.module.entrance.mModel.RegisterModel;
import com.hh.belltower.util.StringUtil;

/**
 * Created by Hh on 2017/3/27.
 */
public class RegisterPresenter implements IRegisterInteractor.Presenter {

    IRegisterInteractor.View view;

    IRegisterInteractor.Model model;


    public RegisterPresenter(IRegisterInteractor.View view) {
        this.view = view;
        model = new RegisterModel(view.getMyActivity());
    }


    @Override
    public void doRegister(String real_name, String user_number, String pwd) {
        if (!StringUtil.isSpace(user_number) && !StringUtil.isSpace(pwd)) {
            model.checkUser(real_name, user_number, pwd, b -> {
                if (b.getCode() == Constants.ERROR_CODE) {
                    view.registerFailed(b.getMsg());
                }
                if (b.getCode() == Constants.SUCCEED_CODE) {
                    view.registerSucceed();
//                    model.saveUser(b.getData());
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
