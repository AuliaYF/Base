package com.auliayf.base;

import android.os.Bundle;
import android.view.View;

import com.auliayf.base.core.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getLayoutResource() {
        return R.layout.content_main;
    }

    @Override
    protected int getHeaderResource() {
        return R.layout.header_main;
    }

    @Override
    protected View.OnClickListener getFabClickListener() {
        return null;
    }

    @Override
    protected boolean isHasUpButton() {
        return false;
    }

    @Override
    protected boolean isParallax() {
        return false;
    }

    @Override
    protected boolean isHasFab() {
        return false;
    }

    @Override
    protected void updateState(Object... args) {

    }

}
