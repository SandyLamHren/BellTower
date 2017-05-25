package com.hh.belltower.bean;

/**
 * EventBus 基础事件
 * Created by Hh on 2017/5/23.
 */

public class BaseEvent {

    public static final int GET_NEWS = 0;

    public static final int CANCLE_REFRESH = 1;


    private int code;

    private String msg;

    private Object data;

    public BaseEvent(int code) {
        this.code = code;
    }

    public BaseEvent(String msg) {
        this.msg = msg;
    }

    public BaseEvent(Object data) {
        this.data = data;
    }

    public BaseEvent(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseEvent(String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

    public BaseEvent(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public BaseEvent(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
