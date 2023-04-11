package com.zhuguohui.myapplication.bean;

/**
 * Created by zhuguohui
 * Date: 2023/4/11
 * Time: 21:20
 * Desc:
 */
public class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age+"";
    }
}
