package com.hh.belltower.bean;

/**
 * 学院bean
 * Created by Hh on 2017/4/4.
 */
public class AcademyBean {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AcademyBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
