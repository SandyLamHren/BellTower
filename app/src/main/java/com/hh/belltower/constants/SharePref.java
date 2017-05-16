package com.hh.belltower.constants;

import android.content.Context;
import android.content.SharedPreferences;

import com.hh.belltower.base.MyApplication;


/**
 * <公共存储类>
 * <功能详细描述>
 * Created by admin on 2016/9/9.
 */
public class SharePref {


    //用户名
    public static final String USER_NUMBER = "user_number";

    //密码
    public static final String PASSWORD = "password";

    //JSON.UserBean
    public static final String USER_BEAN = "userBean";

    public static void saveBoolean(String key, boolean value) {
        getSharedPreferences().edit().putBoolean(key, value).apply();
    }

    public static boolean getBoolean(String key, boolean defvalue) {
        return getSharedPreferences().getBoolean(key, defvalue);
    }

    /**
     * Save a string value to the shared preference.
     *
     * @param key   to mark the store value.
     * @param value to saved value.
     */
    public static void saveString(String key, String value) {
        getSharedPreferences().edit().putString(key, value).apply();
    }

    /**
     * Get the specified value through the key value.
     *
     * @param key to retrieve the value.
     * @return the string value returned.
     */
    public static String getString(String key, String def) {
        return getSharedPreferences().getString(key, def);
    }

    /**
     * Save a integer value to the shared preference.
     *
     * @param key   to mark the store value.
     * @param value to saved value.
     */
    public static void saveInt(String key, int value) {
        getSharedPreferences().edit().putInt(key, value).apply();
    }

    /**
     * Get the specified value through the key value.
     *
     * @param key to retrieve the value.
     * @return the integer value returned.
     */
    public static int getInt(String key, int def) {
        return getSharedPreferences().getInt(key, def);
    }

    /**
     * Save a Long value to the shared preference.
     *
     * @param key   to mark the store value.
     * @param value to saved value.
     */
    public static void saveLong(String key, long value) {
        getSharedPreferences().edit().putLong(key, value).apply();
    }

    /**
     * Get the specified value through the key value.
     *
     * @param key to retrieve the value.
     * @return the integer value returned.
     */
    public static long getLong(String key, long def) {
        return getSharedPreferences().getLong(key, def);
    }

    /**
     * Retrieve the package shared preferences object.
     */
    private static SharedPreferences getSharedPreferences() {
        return MyApplication.getInstance().getSharedPreferences(Constants.USER_INFO, Context.MODE_PRIVATE);
    }

}
