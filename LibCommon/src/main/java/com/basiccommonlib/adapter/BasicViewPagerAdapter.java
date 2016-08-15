/**
 * Copyright (C) © 2016
 * LuckyNest
 * BasicViewPagerAdapter.java
 */
package com.basiccommonlib.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.basiccommonlib.utils.EmptyUtil;
import com.basiccommonlib.fragment.BaseCommonFragment;

import java.util.List;

/**
 * @author
 * @since 16/7/13 下午4:28
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 */
public class BasicViewPagerAdapter extends FragmentStatePagerAdapter {

    // ===========================================================
    // Constants

    private String[]                 tabTitles;
    private Context                  context;
    private List<BaseCommonFragment> fragments;

    public BasicViewPagerAdapter(FragmentManager fm, Context context, String[] tabTitles,
                                 List<BaseCommonFragment> fragments) {
        super(fm);
        this.context = context;
        this.tabTitles = tabTitles;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {

        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return EmptyUtil.isEmpty(tabTitles) ? 0 : tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
