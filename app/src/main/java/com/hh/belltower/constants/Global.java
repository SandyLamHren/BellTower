package com.hh.belltower.constants;

import com.alibaba.fastjson.JSON;
import com.hh.belltower.bean.UserBean;

import static com.hh.belltower.constants.SharePref.USER_NUMBER;

/**
 * <全局静态缓存数据>
 * <功能详细描述>
 */
public class Global {

    /**
     * 用户名
     **/
    public static void saveUserName(String user_number) {
        SharePref.saveString(USER_NUMBER, user_number);
    }
    public static String getUserName() {
        return SharePref.getString(SharePref.USER_NUMBER, "");
    }

    /**
     * 密码
     **/
    public static String getPassword() {
        return SharePref.getString(SharePref.PASSWORD, "");
    }
    public static void savePassword(String password) {
        SharePref.saveString(SharePref.PASSWORD, password);
    }


    /**
     * 保存用户实体类json字符串
     */

    public static UserBean getUser() {
        return JSON.parseObject( SharePref.getString(SharePref.USER_BEAN, ""),UserBean.class);
    }

    public static void saveUser(String userBean) {
        SharePref.saveString(SharePref.USER_BEAN, userBean);
    }
    /**
     * <退出登陆>
     * <功能详细描述>
     *
     * @see [类、类#方法、类#成员]
     */
    public static void loginOut() {
        Global.savePassword("");
        Global.saveUserName("");
        Global.saveUser("");
    }

}
