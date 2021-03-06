package com.example.zy.androidgithubuse;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2018/1/29.
 */

public class Test2 {

    public static void main(String[] args){
//        Class<?> clazz = PointImpl.class;
//        Type type = clazz.getGenericSuperclass();
//        if (type instanceof ParameterizedType) {
//            ParameterizedType parameterizedType = (ParameterizedType) type;
//            //返回表示此类型实际类型参数的 Type 对象的数组
//            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
//            for (Type parameterArgType : actualTypeArguments) {
//                Class parameterArgClass = (Class) parameterArgType;
//                System.out.println("填充类型为：" + parameterArgClass.getName());
//            }
//
//            //返回 Type 对象，表示声明此类型的类或接口。
//            Type type1 = parameterizedType.getRawType();
//            Class class22 = (Class) type1;
//            System.out.println("PointImpl的父类类型为："+class22.getName());
//
//        }

        Class<?> clazz = PointImpl.class;
        Type type = clazz.getGenericSuperclass();
        if (type instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            for (Type parameterArgType : actualTypeArguments){
                Class parameterArgClass = (Class) parameterArgType;
                System.out.println("填充类型为："+parameterArgClass.getName());
            }

            Type type1 = parameterizedType.getRawType();
            Class class22 = (Class) type1;
            System.out.println("PointImpl的父类类型为："+class22.getName());
        }
    }
}
