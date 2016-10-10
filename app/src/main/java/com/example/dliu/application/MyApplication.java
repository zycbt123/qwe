package com.example.dliu.application;

import android.app.Application;
import android.util.Log;

import org.xutils.x;

/**
 * Created by dliu on 2016/9/30.
 *
 * 1、MyApplication初始化
 *
 */
public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("MyApplication", "onCreate: ");
        x.Ext.init(this);
    }
}
