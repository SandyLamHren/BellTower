package com.hh.belltower.bean;

import java.io.Serializable;

/**
 * Created by Hh。 on 2016/11/30.
 */
public class News implements Serializable {
    private static final long serialVersionUID = 1l;

    private String advertisement;
    private String author;
    private String channelType;
    private String comment;
    private int commentCount;
    private String content;
    private String favor;
    private String favorTag;
    private int id;
    private String img;
    private String mainDate;
    private String mainPageTag;
    private String mark;
    private String maxDate;
    private String pageTag;
    private String pageTagFlag;
    private String shopAddress;
    private String shopName;
    private String tag;
    private String time;
    private String title;
    private String xls;

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getChannelType() {
        return channelType;
    }

    public void setChannelType(String channelType) {
        this.channelType = channelType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFavor() {
        return favor;
    }

    public void setFavor(String favor) {
        this.favor = favor;
    }

    public String getFavorTag() {
        return favorTag;
    }

    public void setFavorTag(String favorTag) {
        this.favorTag = favorTag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMainDate() {
        return mainDate;
    }

    public void setMainDate(String mainDate) {
        this.mainDate = mainDate;
    }

    public String getMainPageTag() {
        return mainPageTag;
    }

    public void setMainPageTag(String mainPageTag) {
        this.mainPageTag = mainPageTag;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(String maxDate) {
        this.maxDate = maxDate;
    }

    public String getPageTag() {
        return pageTag;
    }

    public void setPageTag(String pageTag) {
        this.pageTag = pageTag;
    }

    public String getPageTagFlag() {
        return pageTagFlag;
    }

    public void setPageTagFlag(String pageTagFlag) {
        this.pageTagFlag = pageTagFlag;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getXls() {
        return xls;
    }

    public void setXls(String xls) {
        this.xls = xls;
    }

    @Override
    public String toString() {
        return "News{" +
                "advertisement='" + advertisement + '\'' +
                ", author='" + author + '\'' +
                ", channelType='" + channelType + '\'' +
                ", comment='" + comment + '\'' +
                ", commentCount=" + commentCount +
                ", content='" + content + '\'' +
                ", favor='" + favor + '\'' +
                ", favorTag='" + favorTag + '\'' +
                ", id=" + id +
                ", img='" + img + '\'' +
                ", mainDate='" + mainDate + '\'' +
                ", mainPageTag='" + mainPageTag + '\'' +
                ", mark='" + mark + '\'' +
                ", maxDate='" + maxDate + '\'' +
                ", pageTag='" + pageTag + '\'' +
                ", pageTagFlag='" + pageTagFlag + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", shopName='" + shopName + '\'' +
                ", tag='" + tag + '\'' +
                ", time='" + time + '\'' +
                ", title='" + title + '\'' +
                ", xls='" + xls + '\'' +
                '}';
    }
}
