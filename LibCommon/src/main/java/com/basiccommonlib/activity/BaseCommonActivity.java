/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * BaseCommonActivity.java
 */
package com.basiccommonlib.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author
 * @since 16/6/30 下午4:48
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 */
public abstract class BaseCommonActivity extends AppCompatActivity {

    private Handler handler_jump;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFromIntent();
        initViews();
        initData();
    }

    public abstract void getFromIntent();

    public abstract void initViews();

    public abstract void initData();

    public void gotoActivity(Class<? extends Activity> clazz) {
        gotoActivity(clazz, false);
    }

    public void gotoActivity(Class<? extends Activity> clazz, boolean finish) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        if (finish) {
            finish();
        }

    }

    public void CountJump(long mills, final Class<? extends Activity> clazz, final boolean finish) {
        this.handler_jump = new Handler();
        this.handler_jump.postDelayed(new Runnable() {
            public void run() {
                BaseCommonActivity.this.gotoActivity(clazz, finish);
            }
        }, mills);
    }

    public void gotoActivity(Class<? extends Activity> clazz, boolean finish, Bundle pBundle) {
        Intent intent = new Intent(this, clazz);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
        if (finish) {
            finish();
        }
    }

    public void finish(int animIn, int animOut) {
        super.finish();
        overridePendingTransition(animIn, animOut);
    }
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter &amp; Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
