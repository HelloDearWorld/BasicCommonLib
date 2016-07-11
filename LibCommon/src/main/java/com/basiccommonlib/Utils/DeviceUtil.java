/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * DeviceUtil.java
 */
package com.basiccommonlib.Utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * @author
 * @since 16/7/11 下午2:32
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 */
public class DeviceUtil {

    public static String getVersion(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "1.0";
    }
}