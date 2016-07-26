/**
 * Copyright (C) © 2016
 * LuckyNest
 * FindFragment.java
 */
package com.demo.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.basiccommonlib.Utils.okhttp.JsonGenericsSerializator;
import com.basiccommonlib.fragment.BaseCommonFragment;
import com.demo.Entry.ADEntry;
import com.demo.R;
import com.demo.adapter.ImagePagerAdapter;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;

/**
 * @author
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 * @since 16/7/13 下午4:32
 */
public class FindFragment extends BaseCommonFragment {

    private AutoScrollViewPager viewPager;
    private List<View> views = new ArrayList<View>();

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_find, null);
        return rootView;
    }

    @Override
    protected void initData() {

        Toast.makeText(getContext(), "initData", Toast.LENGTH_SHORT).show();
        requestADBanner();
    }

    private void initScrollBarData(List<ADEntry> bannerEntryList) {

        viewPager = (AutoScrollViewPager) rootView.findViewById(R.id.view_pager);

        viewPager.setAdapter(new ImagePagerAdapter(activity, bannerEntryList).setInfiniteLoop(true));
        viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
        viewPager.setInterval(2000);
        viewPager.startAutoScroll();
        // viewPager.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE /
        // 2 % bannerEntryList.size());

        // the more properties whose you can set
        // // set whether stop auto scroll when touching, default is true
        // viewPager.setStopScrollWhenTouch(false);
        // // set whether automatic cycle when auto scroll reaching the last or
        // first item
        // // default is true
        // viewPager.setCycle(false);
        // /** set auto scroll direction, default is AutoScrollViewPager#RIGHT
        // **/
        // viewPager.setDirection(AutoScrollViewPager.LEFT);
        // // set how to process when sliding at the last or first item
        // // default is AutoScrollViewPager#SLIDE_BORDER_NONE
        // viewPager.setBorderProcessWhenSlide(AutoScrollViewPager.SLIDE_BORDER_CYCLE);
        // viewPager.setScrollDurationFactor(3);
        // viewPager.setBorderAnimation(false);

    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        // stop auto scroll when onPause
        if (null != viewPager) {

            viewPager.stopAutoScroll();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        // start auto scroll when onResume

        if (null != viewPager) {

            viewPager.startAutoScroll();
        }
    }

    private void requestADBanner() {

//        new OkHttpHelper(activity, ServerConstant.UserRequest.AD).addParams(RequestConstant.ID, "6")
//                .execute(new GenericsCallback() {
//                    @Override
//                    public void onDataError(int errorCode, String msg) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(String responseString) {
//
//                        Logger.json(responseString);
//
//                        List<ADEntry> bannerEntryList =
//                                new JsonGenericsSerializator().fromJsonList(responseString, ADEntry.class);
//                        initScrollBarData(bannerEntryList);
//                    }
//
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//
//                    }
//                });

        String data = "[\n" +
                "        {\n" +
                "            \"title\": \"广告1\",\n" +
                "            \"img\": \"https:\\/\\/4meee.s3.amazonaws.com\\/files/article\\/168220\\/large_168220_2.jpg\",\n" +
                "            \"type\": 1,\n" +
                "            \"extra\": null\n" +
                "        },\n" +
                "        {\n" +
                "            \"title\": \"广告2\",\n" +
                "            \"img\": \"https:\\/\\/4meee.s3.amazonaws.com\\/files/article\\/168220\\/large_168220_2.jpg\",\n" +
                "            \"type\": 1,\n" +
                "            \"extra\": null\n" +
                "        }\n" +
                "    ]";

        Logger.json(data);
//
        List<ADEntry> bannerEntryList =
                new JsonGenericsSerializator().fromJsonList(data, ADEntry.class);
        initScrollBarData(bannerEntryList);
    }
}
