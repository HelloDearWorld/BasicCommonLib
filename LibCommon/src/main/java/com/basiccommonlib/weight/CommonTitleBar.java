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

import com.basiccommonlib.R;
import com.basiccommonlib.utils.AndroidVersionAdapterUtil;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

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

    private AutoRelativeLayout common_title_root_view;
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
        common_title_root_view = (AutoRelativeLayout) findViewById(R.id.common_title);
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


    public void setLeftText(String leftText, View.OnClickListener onClickListener) {

        common_title_left_textview.setVisibility(View.VISIBLE);
        common_title_left_textview.setText(leftText);
        common_title_left_layout.setOnClickListener(onClickListener);
    }

    public void setLeftImage(int leftImageID, View.OnClickListener onClickListener) {
        common_title_left_imageview.setVisibility(View.VISIBLE);
        common_title_left_imageview.setImageDrawable(AndroidVersionAdapterUtil.getDrawable(context, leftImageID));
        common_title_left_layout.setOnClickListener(onClickListener);
    }

    public void setMiddleText(String midText, View.OnClickListener onClickListener) {
        common_title_middle_textview.setVisibility(View.VISIBLE);
        common_title_middle_textview.setText(midText);
        common_title_middle_layout.setOnClickListener(onClickListener);
    }

    public void setMiddleImage(int midImageID, View.OnClickListener onClickListener) {
        common_title_middle_imageview.setVisibility(View.VISIBLE);
        common_title_middle_imageview.setImageDrawable(AndroidVersionAdapterUtil.getDrawable(context, midImageID));
        common_title_middle_layout.setOnClickListener(onClickListener);
    }

    public void setRightText(String rightText, View.OnClickListener onClickListener) {
        common_title_right_textview.setVisibility(View.VISIBLE);
        common_title_right_textview.setText(rightText);
        common_title_right_layout.setOnClickListener(onClickListener);
    }

    public void setRightImage(int rightImageID, View.OnClickListener onClickListener) {
        common_title_right_imageview.setVisibility(View.VISIBLE);
        common_title_right_imageview.setImageDrawable(AndroidVersionAdapterUtil.getDrawable(context, rightImageID));
        common_title_right_layout.setOnClickListener(onClickListener);
    }

    public void hideTitleLeft() {
        common_title_left_layout.setVisibility(View.GONE);
    }

    public void hideTitleMid() {
        common_title_middle_layout.setVisibility(View.GONE);
    }

    public void hideTitleRight() {
        common_title_right_layout.setVisibility(View.GONE);
    }
}
