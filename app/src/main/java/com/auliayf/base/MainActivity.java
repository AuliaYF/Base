package com.auliayf.base;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.auliayf.base.core.BaseActivity;

public class MainActivity extends BaseActivity {

    private static final String EXTRA_PARALLAX = "com.auliayf.base.extraParallax";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Button btnSwitchMode = (Button) findViewById(R.id.btnSwitchMode);
        btnSwitchMode.setText(isParallax() ? R.string.btn_normal : R.string.btn_parallax);
        btnSwitchMode.setOnClickListener(new View.OnClickListener() {
            boolean isParallax = isParallax();

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                intent.putExtra(EXTRA_PARALLAX, !isParallax);

                startActivity(intent);
                finish();
            }
        });

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
        return getIntent().getBooleanExtra(EXTRA_PARALLAX, false);
    }

    @Override
    protected boolean isHasFab() {
        return false;
    }

    @Override
    protected void updateState(Object... args) {

    }

}
