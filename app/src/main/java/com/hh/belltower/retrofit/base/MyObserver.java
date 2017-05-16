package com.hh.belltower.retrofit.base;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.haoren.belltower.R;
import com.hh.belltower.util.MyLog;
import com.hh.belltower.views.NetLoadingDialog;

import java.lang.ref.WeakReference;

import es.dmoral.toasty.Toasty;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 重写观察者
 * Created by Hh on 2017/3/30.
 */
public class MyObserver<T> implements Observer<T> {

    private HttpDataListener mSubscriberOnNextListener;

    private WeakReference<Context> context;

    private NetLoadingDialog netLoadingDialog;

    private Disposable disposable;

    private boolean isDialogNeeded = true;

    public MyObserver(HttpDataListener mSubscriberOnNextListener, Context context, boolean isDialogNeeded) {
        this.mSubscriberOnNextListener = mSubscriberOnNextListener;
        this.context = new WeakReference<>(context);
        this.isDialogNeeded = isDialogNeeded;
        initProgressDialog();
    }


    private void initProgressDialog() {
        Context context = this.context.get();
        if (netLoadingDialog == null) {
            netLoadingDialog = new NetLoadingDialog(context, R.style.transparent_dialog);
            netLoadingDialog.setCancelable(false);
        }
    }

    private void showProgressDialog() {
        netLoadingDialog.show();
    }

    private void dismissProgressDialog() {
        netLoadingDialog.dismiss();
    }


    //取消订阅
    public void cancelSubscribe() {
        disposable.dispose();
    }


    @Override
    public void onError(Throwable e) {
        Context context = this.context.get();
        if (context == null) {
            return;
        }
        MyLog.e("请求失败+++++++++" + e.toString()+"++++++++++请求失败");
        Toasty.custom(context, "网络异常", ContextCompat.getDrawable(context, R.drawable.ic_clear_white_48dp),
                ContextCompat.getColor(context, R.color.white),
                ContextCompat.getColor(context, R.color.colorPrimaryAlpha), 1500, true, true).show();
        dismissProgressDialog();
    }

    @Override
    public void onComplete() {
        if (isDialogNeeded) {
            dismissProgressDialog();
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        this.disposable = d;
        if (isDialogNeeded) {
            showProgressDialog();
        }
    }

    @Override
    public void onNext(T t) {
        if (mSubscriberOnNextListener != null) {
            try {
                mSubscriberOnNextListener.onNext((BaseBean) t);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
