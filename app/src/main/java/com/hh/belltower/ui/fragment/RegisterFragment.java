package com.hh.belltower.ui.fragment;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.haoren.belltower.R;
import com.hh.belltower.base.BaseFragment;
import com.hh.belltower.module.mInteractor.IRegisterInteractor;
import com.hh.belltower.module.mPresenter.RegisterPresenter;
import com.hh.belltower.ui.activity.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 注册
 * Created by Hh on 2017/3/14.
 */
public class RegisterFragment extends BaseFragment implements IRegisterInteractor.View {

    //真实姓名
    @BindView(R.id.lg_realname)
    EditText lgRealName;
    //学号
    @BindView(R.id.lg_username)
    EditText lgUsername;
    //密码
    @BindView(R.id.lg_pwd)
    EditText lgPwd;
    //登陆按钮
    @BindView(R.id.lg_btn)
    Button lgBtn;
    //已经注册
    @BindView(R.id.lg_already_regi)
    TextView already;
    private LoginFragment.ChangePage changePage;

    private RegisterPresenter presenter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.changePage = (LoginFragment.ChangePage) context;
    }

    @Override
    public int getMainContentViewId() {
        return R.layout.fragment_register;
    }

    @Override
    public void initData() {
        presenter = new RegisterPresenter(this);
    }

    @OnClick({R.id.lg_btn, R.id.lg_already_regi})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lg_btn:
                presenter.doRegister(lgRealName.getText().toString(), lgUsername.getText().toString(), lgPwd.getText().toString());
                break;
            case R.id.lg_already_regi:
                changePage.changePage(0);
                break;
        }
    }
    /**
     * 吐司 并跳转
     */
    private void showSuccessToasty() {
        Toast toast = showToasty("注册成功", R.drawable.ic_check_white);
        lgBtn.setClickable(false); //注册成功后按钮不可点击
        View v = toast.getView();
        v.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            @Override
            public void onViewAttachedToWindow(View v) {

            }

            @Override
            public void onViewDetachedFromWindow(View v) {
                getActivity().finish();
                skipTo(MainActivity.class);
            }
        });
        toast.show();
    }

    @Override
    public Activity getMyActivity() {
        return mActivity;
    }

    @Override
    public void registerSucceed() {
        showSuccessToasty();
    }

    @Override
    public void registerFailed(String msg) {
        showToasty(msg, true);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.destroyMV();
    }
}
