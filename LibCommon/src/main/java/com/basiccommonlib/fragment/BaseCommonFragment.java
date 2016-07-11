/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * BaseCommonFragment.java
 */
package com.basiccommonlib.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * @author
 * @since 16/6/30 下午5:28
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 */
public class BaseCommonFragment extends Fragment {
    private Handler handler_jump;

    public void gotoActivity(Class<? extends Activity> clazz) {
        gotoActivity(clazz, false);
    }

    public void gotoActivity(Class<? extends Activity> clazz, boolean finish) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
        if (finish) {
            getActivity().finish();
        }

    }

    public void CountJump(long mills, final Class<? extends Activity> clazz, final boolean finish) {
        this.handler_jump = new Handler();
        this.handler_jump.postDelayed(new Runnable() {
            public void run() {
                BaseCommonFragment.this.gotoActivity(clazz, finish);
            }
        }, mills);
    }

    public void gotoActivity(Class<? extends Activity> clazz, boolean finish, Bundle pBundle) {
        Intent intent = new Intent(getActivity(), clazz);
        if (pBundle != null) {
            intent.putExtras(pBundle);
        }
        startActivity(intent);
        if (finish) {
            getActivity().finish();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        ImageLoader.getInstance().clearMemoryCache();
        ImageLoader.getInstance().clearDiskCache();
    }
}
