package com.example.zy.androidgithubuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> strList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Point<Integer> point = new Point();
        point.setX(1);
        point.setY((int) 2.0);

        StaticFans staticFans = new StaticFans();
        staticFans.OtherMethod("abc");
        staticFans.<Integer>OtherMethod(1);
    }
}
