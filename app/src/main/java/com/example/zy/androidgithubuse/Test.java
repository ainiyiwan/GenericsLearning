package com.example.zy.androidgithubuse;

/**
 * Created by Administrator on 2018/1/29.
 */

public class Test {

    public static void main(String[] args){
        Class<?> class1 = Animal.class;
        Package package1 = class1.getPackage();

        System.out.println("完整的类名："+class1.getName());
        System.out.println("仅获取类名："+class1.getSimpleName());
        System.out.println("包名："+package1.getName());

        Class<?> class2 = null;
        try {
            class2 = Class.forName("com.example.zy.androidgithubuse.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class<?> parentClass = class2.getSuperclass();
        System.out.println("父类：" + parentClass.getName());


        //获取Animal类的接口列表
        Class<?> class3 = Animal.class;
        Class<?>[] interfaces = class3.getInterfaces();
        for (Class interItem:interfaces){
            System.out.println("Animal继承的接口：" + interItem.getName());
        }

        //获取AnimalImpl的接口列表
        class3 = Dog.class;
        interfaces = class3.getInterfaces();
        if (interfaces.length >0) {
            for (Class interItem : interfaces) {
                System.out.println("Dog继承的接口：" + interItem.getName());
            }
        }else {
            System.out.println("Dog无继承的接口");
        }
    }
}
