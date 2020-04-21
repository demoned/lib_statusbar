package com.bojun.statusbar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bojun.bar.ImmersionBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置共同沉浸式样式
        ImmersionBar.with(this).navigationBarColor(R.color.colorPrimary).init();
        ImmersionBar.with(this)
                .fitsSystemWindows(true)
                .statusBarColorInt(getResources().getColor(R.color.colorPrimary))
                .navigationBarColorInt(getResources().getColor(R.color.colorPrimary))
                .autoDarkModeEnable(true)
                .init();
    }
}
