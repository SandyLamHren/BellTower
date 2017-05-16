package com.hh.belltower.bean;

/**
 * 用户实体类
 * Created by Hh。 on 2016/11/29.
 */
public class UserBean  {

    private int id;

    private int class_id;

    private ClassBean classBean;

    private String user_number;

    private String real_name;

    private String user_role;

    private String pwd;

    private String head_photo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public ClassBean getClassBean() {
        return classBean;
    }

    public void setClassBean(ClassBean classBean) {
        this.classBean = classBean;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getHead_photo() {
        return head_photo;
    }

    public void setHead_photo(String head_photo) {
        this.head_photo = head_photo;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "id=" + id +
                ", class_id=" + class_id +
                ", classBean=" + classBean +
                ", user_number='" + user_number + '\'' +
                ", real_name='" + real_name + '\'' +
                ", user_role='" + user_role + '\'' +
                ", pwd='" + pwd + '\'' +
                ", head_photo='" + head_photo + '\'' +
                '}';
    }
}
