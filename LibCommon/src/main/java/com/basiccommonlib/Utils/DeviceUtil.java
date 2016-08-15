/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * DeviceUtil.java
 */
package com.basiccommonlib.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * @author
 * @version 1.0
 *          <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 16/7/11 下午2:32
 */
public class DeviceUtil {

    public static String getVersion(Context context) {
        try {
            return getPackageInfo(context).versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1.0";
    }

    public static String getVersionName(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        if (packageInfo != null) {
            return packageInfo.versionName;
        }
        return "";
    }

    public static String getAppName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String appName = (String) context.getPackageManager().getApplicationLabel(applicationInfo);
        return appName;
    }

    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo packageInfo = null;
        String packageName = context.getPackageName();
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            return packageInfo;
        }
        return packageInfo;
    }
}