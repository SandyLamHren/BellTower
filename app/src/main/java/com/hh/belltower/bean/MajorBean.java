package com.hh.belltower.bean;

/**
 * 专业Bean
 * Created by Hh。 on 2016/12/2.
 */
public class MajorBean  {

    private int id;

    private int academy_id;

    private AcademyBean academyBean;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcademy_id() {
        return academy_id;
    }

    public void setAcademy_id(int academy_id) {
        this.academy_id = academy_id;
    }

    public AcademyBean getAcademyBean() {
        return academyBean;
    }

    public void setAcademyBean(AcademyBean academyBean) {
        this.academyBean = academyBean;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MajorBean{" +
                "id=" + id +
                ", academy_id=" + academy_id +
                ", academyBean=" + academyBean +
                ", name='" + name + '\'' +
                '}';
    }
}

