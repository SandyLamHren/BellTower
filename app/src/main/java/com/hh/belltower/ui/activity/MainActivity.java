package com.hh.belltower.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;
import com.haoren.belltower.R;
import com.hh.belltower.adapter.MDPagerAdapter;
import com.hh.belltower.base.DrawerActivity;
import com.hh.belltower.bean.UserBean;
import com.hh.belltower.constants.Constants;
import com.hh.belltower.module.mInteractor.IMainInteractor;
import com.hh.belltower.module.mPresenter.MainPresenter;
import com.hh.belltower.retrofit.base.API;
import com.hh.belltower.ui.fragment.NewsFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 主页
 * Created by Hh on 2017/3/17.
 */
public class MainActivity extends DrawerActivity implements IMainInteractor.View {

    //首页viewPager
    @BindView(R.id.materialViewPager)
    MaterialViewPager mViewPager;
    //抽屉头像
    @BindView(R.id.drawer_head_img)
    ImageView drawerHeadImg;
    //用户信息
    @BindView(R.id.drawer_info)
    TextView drawerInfo;
    //抽屉
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    //浮动菜单
    @BindView(R.id.main_float_menu)
    FloatingActionsMenu mFloatingActionMenu;

    private MainPresenter presenter;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setTitle("");
        presenter = new MainPresenter(this, this);
        presenter.presenterInit();
    }

    @Override
    public void initToolBar() {
        toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    /**
     * 初始化浮动菜单
     */
    @Override
    public void initFloatMenu() {

    }

    /**
     * 初始化ViewPager
     */
    @Override
    public void initViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            fragments.add(new NewsFragment());
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.KEY_INDEX, i);
            fragments.get(i).setArguments(bundle);
        }
        MDPagerAdapter mdPagerAdapter = new MDPagerAdapter(getSupportFragmentManager(),fragments);
        mViewPager.getViewPager().setAdapter(mdPagerAdapter);
        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
    }

    /**
     * 初始化 setMaterialViewPagerListener
     */
    @Override
    public void initVpListener() {
        mViewPager.setMaterialViewPagerListener(page -> {
            switch (page) {
                case 0:
                    return HeaderDesign.fromColorAndDrawable(
                            ContextCompat.getColor(this, R.color.colorPrimary),
                            ContextCompat.getDrawable(this, R.drawable.banner_img4));
                case 1:
                    return HeaderDesign.fromColorAndDrawable(
                            ContextCompat.getColor(this, R.color.lightslategray),
                            ContextCompat.getDrawable(this, R.drawable.banner_img2));
                case 2:
                    return HeaderDesign.fromColorAndDrawable(
                            ContextCompat.getColor(this, R.color.powderblue),
                            ContextCompat.getDrawable(this, R.drawable.banner_img3));
                case 3:
                    return HeaderDesign.fromColorAndDrawable(
                            ContextCompat.getColor(this, R.color.seagreen),
                            ContextCompat.getDrawable(this, R.drawable.banner_img1));
            }
            return null;
        });
    }

    @Override
    public void showUserInfo(UserBean userBean) {
        drawerInfo.setText(userBean.getReal_name());
        Glide.with(this)
                .load(API.BASE_URL + userBean.getHead_photo())
                .asBitmap().centerCrop()
                .into(new BitmapImageViewTarget(drawerHeadImg) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        drawerHeadImg.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    @OnClick(R.id.user_info)
    public void toUserInfo(View view) {
        skipTo(UserInfoActivity.class);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
