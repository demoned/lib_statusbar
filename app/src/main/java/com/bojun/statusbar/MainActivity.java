package com.bojun.statusbar;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.bojun.bar.StatusBar;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置共同沉浸式样式
        StatusBar.with(this).navigationBarColor(R.color.colorPrimary).init();
        StatusBar.with(this)
                .fitsSystemWindows(true)
                .statusBarColorInt(getResources().getColor(R.color.colorPrimary))
                .navigationBarColorInt(getResources().getColor(R.color.colorPrimary))
                .autoDarkModeEnable(true)
                .init();
    }
}
