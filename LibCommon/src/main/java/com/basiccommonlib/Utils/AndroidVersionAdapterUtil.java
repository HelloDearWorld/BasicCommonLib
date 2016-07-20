/**
 * Copyright (C) © 2016
 * LuckyNest
 * AndroidVersionAdapterUtil.java
 */
package com.basiccommonlib.Utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;

/**
 * @author
 * @since 16/7/13 下午4:37
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 */
public class AndroidVersionAdapterUtil {

    public static Drawable getDrawable(Context ctx, int drawbaleID) {

        Drawable drawable = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            drawable = ctx.getResources().getDrawable(drawbaleID, null);
        } else {
            drawable = ctx.getResources().getDrawable(drawbaleID);
        }

        return drawable;
    }


}
