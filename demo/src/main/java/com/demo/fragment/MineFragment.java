/**
 * Copyright (C) © 2016
 * LuckyNest
 * MineFragment.java
 */
package com.demo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.basiccommonlib.fragment.BaseCommonFragment;
import com.basiccommonlib.weight.RoundImageView;
import com.demo.R;

/**
 * @author
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 * @since 16/7/18 上午10:06
 */
public class MineFragment extends BaseCommonFragment {

    private Button my_Login;
    private Button my_Register;
    private RoundImageView roundImageView;

    @Override
    protected View initViews(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_my, null);
        my_Login = (Button) rootView.findViewById(R.id.my_Login);
        my_Register = (Button) rootView.findViewById(R.id.my_Register);
        roundImageView = (RoundImageView) rootView.findViewById(R.id.my_RoundImageView);
        return rootView;
    }

    @Override
    protected void initData() {

        my_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                gotoActivity(LoginActivity.class);
            }
        });

        my_Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                gotoActivity(RegisteActivity.class);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

//        if (UserManager.getInstance().isLogin()) {
//
//            ImageUtil.showImage(UserManager.getInstance().getUserEntry().getAvatar(), roundImageView);
//        }
    }
}
