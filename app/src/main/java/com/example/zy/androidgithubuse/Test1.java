package com.example.zy.androidgithubuse;

import java.lang.reflect.Modifier;

/**
 * Created by Administrator on 2018/1/29.
 */

public class Test1 {

    public static void main(String[] args){
        Class<?> clazz = InnerClass.class;
        int modifiers = clazz.getModifiers();
        String retval = Modifier.toString(modifiers);
        boolean isFinal = Modifier.isFinal(modifiers);
        System.out.println("InnerClass的定义修饰符:" + retval);
        System.out.println("is Final:" + isFinal);
    }
}
