package com.auliayf.inventory.core;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.auliayf.inventory.R;

/**
 * Created by uoy on 31/03/16.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private View mBaseView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(isParallax() ? R.layout.activity_base_parallax : R.layout.activity_base);

        if (isParallax()) {
            RelativeLayout baseHeader = (RelativeLayout) findViewById(R.id.header);
            baseHeader.removeAllViews();

            View includedHeader = getLayoutInflater().inflate(getHeaderResource(), null);
            final CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

            baseHeader.addView(includedHeader);

            if (baseHeader.getChildAt(0) instanceof ImageView) {
                Bitmap bitmap = ((BitmapDrawable) ((ImageView) baseHeader.getChildAt(0)).getDrawable()).getBitmap();
                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    public void onGenerated(Palette palette) {
                        applyPalette(collapsingToolbarLayout, palette);
                    }
                });
            }
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(isHasUpButton());

        mBaseView = getLayoutInflater().inflate(getLayoutResource(), null);
    }

    private void applyPalette(CollapsingToolbarLayout collapsingToolbarLayout, Palette palette) {
        int primaryDark = ContextCompat.getColor(this, R.color.colorPrimaryDark);
        int primary = ContextCompat.getColor(this, R.color.colorPrimary);
        collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(primary));
        collapsingToolbarLayout.setStatusBarScrimColor(palette.getDarkMutedColor(primaryDark));
        supportStartPostponedEnterTransition();
    }

    protected View getBaseView() {
        return this.mBaseView;
    }

    protected abstract int getLayoutResource();

    protected abstract int getHeaderResource();

    protected abstract boolean isHasUpButton();

    protected abstract boolean isParallax();

    protected abstract void updateState(Object... args);
}
