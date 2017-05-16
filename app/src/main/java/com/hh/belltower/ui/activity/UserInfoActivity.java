package com.hh.belltower.ui.activity;

import android.graphics.Bitmap;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.haoren.belltower.R;
import com.hh.belltower.base.BaseFullActivity;
import com.hh.belltower.bean.UserBean;
import com.hh.belltower.constants.Global;
import com.hh.belltower.retrofit.base.API;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 个人信息
 * Created by Hh on 2017/4/5.
 */
public class UserInfoActivity extends BaseFullActivity {

    @BindView(R.id.userinfo_headphoto)
    ImageView iv_head_photo;  // 头像
    @BindView(R.id.userinfo_usernumber)
    TextView tv_usernumber; //用户号
    @BindView(R.id.userinfo_actual_name)
    TextView tv_actual_name; //真实姓名
    @BindView(R.id.userinfo_major)
    TextView tv_major; //专业
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbar_layout; //toolbar_layout

    @Override
    protected int getContentViewId() {
        return R.layout.activity_userinfo;
    }

    @Override
    protected void init() {
        UserBean userBean = Global.getUser();
        if (userBean != null) {
            showUserInfo(userBean);
        }
    }

    /**
     * 显示用户信息
     */
    private void showUserInfo(UserBean userBean) {
        String photo_url = API.BASE_URL + userBean.getHead_photo();
        Glide.with(this)
                .load(photo_url)
                .asBitmap().centerCrop()
                .into(new BitmapImageViewTarget(iv_head_photo) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        iv_head_photo.setImageDrawable(circularBitmapDrawable);
                    }
                });
        tv_actual_name.setText(userBean.getReal_name());
        tv_usernumber.setText(userBean.getUser_number());
        toolbar_layout.setTitle(userBean.getReal_name());
        tv_major.setText(userBean.getClassBean().getMajor().getName());
    }

    @OnClick(R.id.userinfo_add)
    public void onClick() {
    }
}
