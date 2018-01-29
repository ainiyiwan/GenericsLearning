package com.example.zy.androidgithubuse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/1/29.
 */

public class StaticFans {

    public static <T> void StaticMethod(T a){

    }

    public <T> void OtherMethod(T a){

    }

    public static <R> List<R> parseArray(String response, Class<R> object){
        List<R> list = new ArrayList<>();
        return list;
    }
}
