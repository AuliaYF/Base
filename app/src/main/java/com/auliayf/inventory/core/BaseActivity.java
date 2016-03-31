package com.auliayf.inventory.core;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.auliayf.inventory.R;

/**
 * Created by uoy on 31/03/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private View mBaseView = null;
    private View mHeaderView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(isHasUpButton());

        if (isParallax()) {
            mHeaderView = getLayoutInflater().inflate(getHeaderResource(), null);
            mHeaderView.setVisibility(View.VISIBLE);
        } else {
            mHeaderView.setVisibility(View.GONE);
        }

        mBaseView = getLayoutInflater().inflate(getLayoutResource(), null);
    }

    protected View getBaseView() {
        return this.mBaseView;
    }

    protected abstract int getLayoutResource();

    protected abstract int getHeaderResource();

    protected abstract boolean isHasUpButton();

    protected abstract boolean isParallax();
}
