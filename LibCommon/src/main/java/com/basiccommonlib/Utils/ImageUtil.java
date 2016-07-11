/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * ImageUtil.java
 */
package com.basiccommonlib.Utils;

import android.widget.ImageView;

import com.basiccommonlib.CommonApplication;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * @author
 * @since 16/7/11 下午3:16
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 */
public class ImageUtil {

    public static void showImage(String imagreUrl, ImageView imageView) {

        ImageLoader.getInstance().displayImage(imagreUrl, imageView, CommonApplication.mOptions, null);
    }

    public static void showImage(String imagreUrl, ImageView imageView, DisplayImageOptions mOptions) {

        ImageLoader.getInstance().displayImage(imagreUrl, imageView, mOptions, null);

    }

    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter &amp; Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
