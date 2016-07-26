/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * CommonTitleBar.java
 */
package com.basiccommonlib.weight;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.basiccommonlib.R;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * @author
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 * @since 16/6/30 下午5:39
 */
public class CommonTitleBar extends RelativeLayout {


    private Context context;

    private AutoLinearLayout common_title_left_layout;
    private TextView common_title_left_textview;
    private ImageView common_title_left_imageview;
    private AutoLinearLayout common_title_middle_layout;
    private TextView common_title_middle_textview;
    private ImageView common_title_middle_imageview;
    private AutoLinearLayout common_title_right_layout;
    private TextView common_title_right_textview;
    private ImageView common_title_right_imageview;

    public CommonTitleBar(Context context) {
        super(context);
        initView(context);
    }

    public CommonTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CommonTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CommonTitleBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;

        LayoutInflater.from(getContext()).inflate(R.layout.common_titlebar, this);
        common_title_left_layout = (AutoLinearLayout) findViewById(R.id.common_title_left_layout);
        common_title_left_textview = (TextView) findViewById(R.id.common_title_left_textview);
        common_title_left_imageview = (ImageView) findViewById(R.id.common_title_left_imageview);
        common_title_middle_layout = (AutoLinearLayout) findViewById(R.id.common_title_middle_layout);
        common_title_middle_textview = (TextView) findViewById(R.id.common_title_middle_textview);
        common_title_middle_imageview = (ImageView) findViewById(R.id.common_title_middle_imageview);
        common_title_right_layout = (AutoLinearLayout) findViewById(R.id.common_title_right_layout);
        common_title_right_textview = (TextView) findViewById(R.id.common_title_right_textview);
        common_title_right_imageview = (ImageView) findViewById(R.id.common_title_right_imageview);


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
