package com.hh.belltower.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.haoren.belltower.R;
import com.hh.belltower.base.BaseFragment;
import com.hh.belltower.module.mInteractor.ILoginInteractor;
import com.hh.belltower.module.mPresenter.LoginPresenter;
import com.hh.belltower.ui.activity.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * 登陆
 * Created by Hh on 2017/3/14.
 */
public class LoginFragment extends BaseFragment implements ILoginInteractor.View {

    @BindView(R.id.lg_username)
    EditText lgUsername;

    @BindView(R.id.lg_pwd)
    EditText lgPwd;

    @BindView(R.id.root)
    LinearLayout root;

    private ChangePage changePage;

    private LoginPresenter loginPresenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        changePage = (ChangePage) context;
    }

    @Override
    public int getMainContentViewId() {
        return R.layout.fragment_login;
    }

    @Override
    public void initData() {
        loginPresenter = new LoginPresenter(this);

    }

    @Override
    public void loginSucceed() {
        getActivity().finish();
        skipTo(MainActivity.class);
    }

    @Override
    public void loginFailed() {
        new SweetAlertDialog(mActivity)
                .setTitleText("用户名或密码错误")
                .show();
    }

    @OnClick({R.id.lg_btn, R.id.lg_not_regi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lg_btn: //登陆
                loginPresenter.doLogin(lgUsername.getText().toString(), lgPwd.getText().toString());
                break;
            case R.id.lg_not_regi: //跳转注册页:
                //注册
                changePage.changePage(1);
                break;
        }
    }

    @Override
    public Activity getMyActivity() {
        return mActivity;
    }

    public interface ChangePage {
        void changePage(int pageIndex);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        loginPresenter.destroyMV();
    }
}
