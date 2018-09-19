package com.newdicooker.tempetek.utilsdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by SPC
 * on 2018/9/17
 * 邮箱：13027699936@163.com.
 * version 2.0.4
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initView();
        setData();
    }

    protected abstract int getLayoutId();

    public abstract void initView();

    public abstract void setData();

    public  void setSplash() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
