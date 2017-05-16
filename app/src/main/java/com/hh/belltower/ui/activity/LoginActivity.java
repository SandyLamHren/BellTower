package com.hh.belltower.ui.activity;

import android.support.v4.app.Fragment;
import android.widget.LinearLayout;

import com.haoren.belltower.R;
import com.hh.belltower.adapter.FragmentViewPagerAdapter;
import com.hh.belltower.base.BaseActivity;
import com.hh.belltower.ui.fragment.LoginFragment;
import com.hh.belltower.ui.fragment.RegisterFragment;
import com.hh.belltower.views.SlowViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.relex.circleindicator.CircleIndicator;


/**
 * 登陆注册页
 */
public class LoginActivity extends BaseActivity implements LoginFragment.ChangePage  {

    @BindView(R.id.lg_vp)
    SlowViewPager lgVp;
    @BindView(R.id.lg_indicator)
    CircleIndicator lgIndicator;
    @BindView(R.id.root)
    LinearLayout root;

    private LoginFragment loginFragment;

    private RegisterFragment registerFragment;

    private List<Fragment> fragments = new ArrayList<>();

    public static int LOGIN_PAGE = 0;

    public static int REGISTER_PAGE = 1;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        initFragment();
        lgVp.setDurationScroll(500);

    }

    /**
     * 初始化fragment
     */
    private void initFragment() {
        if (loginFragment == null) {
            loginFragment = new LoginFragment();
        }
        if (registerFragment == null) {
            registerFragment = new RegisterFragment();
        }
        fragments.add(loginFragment);
        fragments.add(registerFragment);
        lgVp.setAdapter(new FragmentViewPagerAdapter(getSupportFragmentManager(), fragments));
        lgIndicator.setViewPager(lgVp);
    }

    @Override
    public void changePage(int pageIndex) {
        lgVp.setCurrentItem(pageIndex);
    }

    @Override
    public void onBackPressed() {
        if (lgVp.getCurrentItem() == LOGIN_PAGE) {
            this.finish();
        } else {
            lgVp.setCurrentItem(LOGIN_PAGE);
        }
    }


}


