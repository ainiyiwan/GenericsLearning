package com.example.zy.androidgithubuse;

/**
 * Created by Administrator on 2018/1/29.
 */

public class Main {

    public static void main(String[] args){
        Fruit.Apple apple = new Fruit.Apple();
        Fruit.Banana banana = new Fruit.Banana();
        System.out.println(apple.getName());
        System.out.println(banana.getName());

        Point<?> point;
        point = new Point<Integer>(3);
        point.getY();
//        point.setX(new Integer(1));
        point = new Point<Float>(4.3f);
        point = new Point<Double>(4.3d);
        point = new Point<Long>(12l);

        Point<? extends String> points;
        points = new Point<String>("ss");

    }
}
