package com.hh.belltower.retrofit.base;

import android.content.Context;

import java.lang.ref.WeakReference;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * 网络请求工具类
 * Created by Hh on 2017/3/30.
 */
public class MyHttpUtil {

    private volatile static MyHttpUtil singleton;  //单例
    private WeakReference<Context> context; //弱引用
    private Observable observable;
    private MyObserver myObserver;
    private boolean isDialogNeeded = true;


    //返回单例
    public static MyHttpUtil getInstance() {
        if (singleton == null) {
            synchronized (MyHttpUtil.class) {
                if (singleton == null) {
                    singleton = new MyHttpUtil();
                }
            }
        }
        return singleton;
    }

    public MyHttpUtil with(Context context) {
        this.context = new WeakReference<>(context);
        return singleton;
    }

    public MyHttpUtil setObservable(Observable observable) {
        this.observable = observable.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return singleton;
    }

    //是否显示ProgressDialog
    public MyHttpUtil showDialog(boolean isDialogNeeded) {
        this.isDialogNeeded = isDialogNeeded;
        return singleton;
    }

    //创建myObserver
    public void setDataListener(HttpDataListener listener) {
        myObserver = new MyObserver(listener, context.get(), isDialogNeeded);
        observable.subscribe(myObserver);
    }

    // 取消订阅
    public void cancelSubscribe() {
        if (myObserver != null) {
            myObserver.cancelSubscribe();
        }
    }
}
