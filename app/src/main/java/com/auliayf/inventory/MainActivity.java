package com.auliayf.inventory;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.auliayf.inventory.core.BaseActivity;

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
    protected boolean isHasUpButton() {
        return false;
    }

    @Override
    protected boolean isParallax() {
        return true;
    }

    @Override
    protected void updateState(Object... args) {

    }

}
