package com.hh.belltower.views;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.KeyEvent;

import com.haoren.belltower.R;

/**
 *
 */
public class NetLoadingDialog extends Dialog {


    public NetLoadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.netloading_dialog);
    }

    private OnKeyListener onKeyListener = (dialog, keyCode, event) -> {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            return true;
        } else {
            return false;
        }
    };

    /**
     * 按下返回键是否可以取消
     * @param can
     */
    private void setCancelAble(boolean can) {
        if (!can) {
            setOnKeyListener(onKeyListener);
        }
    }
}
