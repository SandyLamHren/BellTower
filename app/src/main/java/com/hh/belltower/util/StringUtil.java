package com.hh.belltower.util;

/**
 * 字符串处理工具类
 * Created by Administrator on 2016/11/22.
 */
public class StringUtil {

    /**
     * 判断字符串是否为null或全为空格
     *
     * @param s 待校验字符串
     * @return {@code true}: null或全空格<br> {@code false}: 不为null且不全空格
     */
    public static boolean isSpace(String s) {
        return (s == null || s.trim().length() == 0);
    }


    /**
     * 精确到后两位
     * @param num
     * @return
     */
    public static String  numberFormat(double num) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("######0.00");

        return df.format(num);
    }

}
