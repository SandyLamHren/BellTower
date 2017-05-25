package com.hh.belltower.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.haoren.belltower.R;
import com.hh.belltower.retrofit.base.MyHttpUtil;
import com.hh.belltower.util.SoftInputUtils;
import com.hh.belltower.util.StatusBarUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

import static android.view.KeyCharacterMap.ALPHA;
import static com.haoren.belltower.R.id.root;

/**
 * Activity 基类
 * Created by Hh on 2017/3/7.
 */
public abstract class BaseActivity extends AppCompatActivity {

    //ToolBar
    @BindView(R.id.toolbar)
    Toolbar toolbar;

//    //标题
//    @BindView(R.id.tv_title)
//    TextView tvTitle;

    //根布局
    @BindView(root)
    View mRoot;

    protected Context mContext;

    protected Activity mActivity;

    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        EventBus.getDefault().register(this);
        mContext = getApplicationContext();
        mActivity = this;
        ButterKnife.bind(this);
        initToolBar();
        handIntent(getIntent());
        init();
        initSoftInput();
    }

    /**
     * 处理数据传递
     */
    protected void handIntent(Intent intent) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void finish(String msg){
    }
    /**
     * 点击外层 让edittext 失去焦点
     */
    private void initSoftInput() {
        mRoot.setOnTouchListener((v, event) -> {
            mRoot.setFocusable(true);
            mRoot.setFocusableInTouchMode(true);

            mRoot.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
            }
            return false;
        });
    }


    /**
     * 初始化 toolbar
     */
    private void initToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_18dp);
        toolbar.setNavigationOnClickListener(v -> {
            SoftInputUtils.hideSoftInput(mActivity);
            finish();
        });
    }

    /**
     * 设置标题
     */
    protected void setTitle(String title) {
//        tvTitle.setText(title);
    }


    protected void simpleStart(Class to) {
        Intent intent = new Intent(mActivity, to);
        mActivity.startActivity(intent);
    }


    /**
     * 隐藏返回Icon
     */
    protected void hideNavigationIcon() {
        toolbar.setNavigationIcon(null);
        toolbar.setNavigationOnClickListener(null);
    }


    //自定义
    protected Toast showTosaty(String title, int icon, int textColor, int bgColor) {
        Toast toast = Toasty.custom(mActivity, title, ContextCompat.getDrawable(mActivity, icon),
                ContextCompat.getColor(mActivity, textColor),
                ContextCompat.getColor(mActivity, bgColor), 1500, true, true);
        toast.show();
        return toast;
    }

    //默认
    protected Toast showTosaty(String title, boolean withIcon) {
        Toast toast = Toasty.custom(mActivity, title, ContextCompat.getDrawable(mActivity, R.drawable.ic_clear_white),
                ContextCompat.getColor(mActivity, R.color.white),
                ContextCompat.getColor(mActivity, R.color.colorPrimaryAlpha), 1500, withIcon, true);
        toast.show();
        return toast;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setBarColor();
    }

    /**
     * 设置沉浸.
     **/
    private void setBarColor() {
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.colorPrimary), ALPHA);
    }

    /**
     * 传入ContentView Resource id
     *
     * @return
     */
    protected abstract int getContentViewId();

    /**
     * 初始化数据和视图
     */
    protected abstract void init();

    @Override
    protected void onDestroy() {
        //取消订阅
        if (MyHttpUtil.getInstance() != null) {
            MyHttpUtil.getInstance().cancelSubscribe();
        }
            EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    /**
     * 跳转到activity 不带参数
     *
     * @param cls
     */
    protected void skipTo(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        this.startActivity(intent);
    }

}
