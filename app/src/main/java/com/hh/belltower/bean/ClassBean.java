package com.hh.belltower.bean;

/**
 * 班级bean
 * Created by Hh。 on 2016/12/2.
 */
public class ClassBean {

    private int id;

    private int major_id;

    private MajorBean major;

    private String class_name;

    private int year_level;

    public MajorBean getMajor() {
        return major;
    }

    public void setMajor(MajorBean major) {
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }


    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getYear_level() {
        return year_level;
    }

    public void setYear_level(int year_level) {
        this.year_level = year_level;
    }

    @Override
    public String toString() {
        return "ClassBean{" +
                "id=" + id +
                ", major_id=" + major_id +
                ", major=" + major +
                ", class_name='" + class_name + '\'' +
                ", year_level=" + year_level +
                '}';
    }
}
