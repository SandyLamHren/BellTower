package com.hh.belltower.bean;

import java.io.Serializable;

/**
 * 新闻实体类
 * Created by Hh。 on 2016/11/30.
 */
public class NewsBean implements Serializable {

    private int id;

    private int type; //新闻类型

    private String title; //新闻标题

    private String content; //新闻内容

    private String img; //新闻图片

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
