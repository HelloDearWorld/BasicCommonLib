/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * CommonApplication.java
 */
package com.basiccommonlib;

import android.app.Application;

import com.basiccommonlib.Utils.BasicCommonHelper;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * @author
 * @since 16/6/30 下午4:45
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 */
public class CommonApplication extends Application {

    public static DisplayImageOptions mOptions = null;

    private static CommonApplication  instance;

    public CommonApplication() {

    }

    public static CommonApplication getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        BasicCommonHelper libCommonHelper = new BasicCommonHelper(this);
        libCommonHelper.initImageLoaderConfiguration();
        mOptions = libCommonHelper.initImageLoaderOptions();
    }

}
