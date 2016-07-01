package com.basiccommonlib;

import android.os.Bundle;

import com.basiccommonlib.activity.BaseCommonActivity;

import butterknife.ButterKnife;

public class MainActivity extends BaseCommonActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void getFromIntent() {

    }

    @Override
    public void initViews() {

    }

    @Override
    public void initData() {

    }



}

