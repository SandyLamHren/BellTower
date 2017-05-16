package com.hh.belltower.util;

import android.util.Log;

/**
 * 日志打印工具类
 */
public final class MyLog {
    private static final String TAG = "haoren";


    public static void e(String msg) {
        Log.e(TAG, msg);
    }


}
