package com.hh.belltower.util;

import android.content.Context;
import android.content.Intent;

/**
 * Activity 跳转 Util
 * Created by Hh on 2017/3/7.
 */

public final class StartActivityUtil {

    public static void skipTo(Context packageContext, Class<?> cls) {
        Intent intent = new Intent(packageContext, cls);
        packageContext.startActivity(intent);
    }
}
