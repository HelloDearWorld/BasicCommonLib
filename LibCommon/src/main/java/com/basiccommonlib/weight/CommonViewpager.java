/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * SuperViewpager.java
 */
package com.basiccommonlib.weight;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.basiccommonlib.R;

/**
 * @author
 * @since 16/7/8 上午11:04
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 */
public class CommonViewpager extends RelativeLayout {

    private Context context;
    private ViewPager common_viewpager;
    private TabLayout common_tablayout;

    public CommonViewpager(Context context) {
        super(context);
        initView(context);
    }

    public CommonViewpager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CommonViewpager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CommonViewpager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {

        this.context = context;
        LayoutInflater.from(getContext()).inflate(R.layout.common_superviewpager, this);
        common_viewpager=(ViewPager)findViewById(R.id.common_viewpager);
        common_tablayout=(TabLayout)findViewById(R.id.common_tablayout);
    }

}
