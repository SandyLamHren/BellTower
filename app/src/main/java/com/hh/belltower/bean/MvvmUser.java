package com.hh.belltower.bean;

/**
 * Created by Hh on 2017/5/8.
 */

public class MvvmUser {
    private final String name;

    private final int age;

    public MvvmUser(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
