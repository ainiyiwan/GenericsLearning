package com.example.zy.androidgithubuse;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/29.
 */

public class Point<T> {

    private T x;
    private T y;

    public Point(){}

    public Point(T t){

    }

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }

    //添加上extends Comparable之后，就可以Comparable里的函数了
    public static <T extends Comparable & Serializable>  T min(T...a){
        T smallest = a[0];
        for(T item:a){
            if (smallest.compareTo(item) == 0){
                smallest = item;
            }
        }
        return smallest;
    }
}
