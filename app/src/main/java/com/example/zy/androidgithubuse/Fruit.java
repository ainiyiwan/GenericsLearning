package com.example.zy.androidgithubuse;

/**
 * Created by Administrator on 2018/1/29.
 */

public class Fruit {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    static class Banana extends Fruit{
        public Banana(){
            setName("bababa");
        }
    }
    static class Apple extends Fruit{
        public Apple(){
            setName("apple");
        }
    }
}
