package com.basiccommonlib.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.basiccommonlib.CommonApplication;

/**
 * Created by yuw on 16-8-7.
 */
public class ScreenUtil {

    public static int getWidth() {
        return getDisplay().getWidth();
    }

    public static int getHeight() {
        return getDisplay().getHeight();
    }

    private static Display getDisplay() {
        WindowManager wm = (WindowManager) CommonApplication.getInstance().getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        return display;
    }

}
