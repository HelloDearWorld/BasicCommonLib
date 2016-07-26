/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * HomeActivity.java
 */
package com.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.basiccommonlib.Utils.AndroidVersionAdapterUtil;
import com.basiccommonlib.activity.BaseCommonActivity;
import com.basiccommonlib.adapter.BasicViewPagerAdapter;
import com.basiccommonlib.fragment.BaseCommonFragment;
import com.basiccommonlib.weight.CommonTitleBar;
import com.demo.R;
import com.demo.fragment.FindFragment;
import com.demo.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @version 1.0
 *          <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 16/7/26 下午2:17
 */
public class HomeActivity extends BaseCommonActivity {
    private CommonTitleBar home_CommonTitleBar;
    private ViewPager home_ViewPager;
    private TabLayout home_TabLayout;

    private BasicViewPagerAdapter pagerAdapter;

    private String[] tabTitles = new String[]{"发现", "微商", "乐店", "聊天", "我的"};
    private List<BaseCommonFragment> fragments = new ArrayList<BaseCommonFragment>() {

        {
            add(new FindFragment());
            add(new FindFragment());
            add(new FindFragment());
            add(new FindFragment());
            add(new MineFragment());
        }
    };

    private int[] tabImages =
            new int[]{R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    @Override
    public void oncreate(@Nullable Bundle savedInstanceState) {

        setContentView(R.layout.activity_home);
    }

    @Override
    public void getFromIntent() {

    }

    @Override
    public void initViews() {
        home_CommonTitleBar = (CommonTitleBar) findViewById(R.id.home_CommonTitleBar);
        home_ViewPager = (ViewPager) findViewById(R.id.home_ViewPager);
        home_TabLayout = (TabLayout) findViewById(R.id.home_TabLayout);
    }

    @Override
    public void initData() {
        initViewpager();
    }

    private void initViewpager() {

        if (null != pagerAdapter) {
            return;
        }

        pagerAdapter = new BasicViewPagerAdapter(getSupportFragmentManager(), this, tabTitles, fragments);

        home_ViewPager.setAdapter(pagerAdapter);
        LayoutInflater mLayoutInflater = this.getLayoutInflater();

        for (int i = 0; i < tabTitles.length; i++) {
            TabLayout.Tab tab = home_TabLayout.newTab();
            View tabView = mLayoutInflater.inflate(R.layout.home_tab_view, null);
            tab.setCustomView(tabView);

            TextView text = (TextView) tabView.findViewById(R.id.homeTab_Text);
            ImageView imageView = (ImageView) tabView.findViewById(R.id.homeTab_Image);
            text.setText(tabTitles[i]);
            imageView.setImageDrawable(AndroidVersionAdapterUtil.getDrawable(this, tabImages[i]));

            if (i == 0) {
                text.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            }
            home_TabLayout.addTab(tab);
        }

        // tabLayout.setupWithViewPager(noScrollViewPager);
        home_ViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(home_TabLayout));
        home_TabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(home_ViewPager));
        home_ViewPager.setOffscreenPageLimit(4);

        home_ViewPager.setCurrentItem(0);

    }
}