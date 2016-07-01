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
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.basiccommonlib.R;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author
 * @since 16/6/30 下午5:39
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 */
public class CommonTitleBar extends RelativeLayout {

    @BindView(R.id.common_title_left_textview)
    TextView         commonTitleLeftTextview;
    @BindView(R.id.common_title_left_imageview)
    ImageView        commonTitleLeftImageview;
    @BindView(R.id.common_title_left_layout)
    AutoLinearLayout commonTitleLeftLayout;
    @BindView(R.id.common_title_middle_textview)
    TextView         commonTitleMiddleTextview;
    @BindView(R.id.common_title_middle_imageview)
    ImageView        commonTitleMiddleImageview;
    @BindView(R.id.common_title_middle_layout)
    AutoLinearLayout commonTitleMiddleLayout;
    @BindView(R.id.common_title_right_textview)
    TextView         commonTitleRightTextview;
    @BindView(R.id.common_title_right_imageview)
    ImageView        commonTitleRightImageview;
    @BindView(R.id.common_title_right_layout)
    AutoLinearLayout commonTitleRightLayout;

    private Context  context;

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
        ButterKnife.bind(this);

    }

    @OnClick({ R.id.common_title_left_textview, R.id.common_title_left_imageview, R.id.common_title_left_layout,
            R.id.common_title_middle_textview, R.id.common_title_middle_imageview, R.id.common_title_middle_layout,
            R.id.common_title_right_textview, R.id.common_title_right_imageview })
    public void onClick(View view) {
        int i = view.getId();
        if (i == R.id.common_title_left_textview) {
            Toast.makeText(context, "common_title_left_textview", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.common_title_left_imageview) {
            Toast.makeText(context, "common_title_left_imageview", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.common_title_left_layout) {
            Toast.makeText(context, "common_title_left_layout", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.common_title_middle_textview) {
            Toast.makeText(context, "common_title_middle_textview", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.common_title_middle_imageview) {
            Toast.makeText(context, "common_title_middle_imageview", Toast.LENGTH_SHORT).show();

        } else if (i == R.id.common_title_middle_layout) {
            Toast.makeText(context, "common_title_middle_layout", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.common_title_right_textview) {
            Toast.makeText(context, "common_title_right_textview", Toast.LENGTH_SHORT).show();
        } else if (i == R.id.common_title_right_imageview) {
            Toast.makeText(context, "common_title_right_imageview", Toast.LENGTH_SHORT).show();
        }
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
