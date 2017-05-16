package com.hh.belltower.ui.activity;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.haoren.belltower.R;
import com.hh.belltower.base.BaseActivity;

import butterknife.BindView;

/**
 * 欢迎页
 */
public class WelcomeActivity extends BaseActivity {


    @BindView(R.id.alpha_layout)
    LinearLayout alphaLayout;

    private Handler handler = new Handler();

    @Override
    protected int getContentViewId() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void init() {
        initAnimation();

    }

    /**
     * 初始化动画
     */
    private void initAnimation() {
        Animation anim = AnimationUtils.loadAnimation(mContext, R.anim.welcome_anim);
        alphaLayout.setAnimation(anim);
        anim.setFillAfter(true);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                simpleStart(LoginActivity.class);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        handler = null;
        super.onDestroy();
    }

}
