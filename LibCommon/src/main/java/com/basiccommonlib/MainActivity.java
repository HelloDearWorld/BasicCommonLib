package com.basiccommonlib;

import android.content.Intent;
import android.os.Bundle;

import com.basiccommonlib.activity.BaseCommonActivity;

public class MainActivity extends BaseCommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void getFromIntent() {


    }

    @Override
    public void initViews() {

        Intent intent = getIntent();
        if (intent.hasExtra("flag")) {
            intent.putExtra("flag", (Integer) 2);
        };
    }

    @Override
    public void initData() {

    }

}
