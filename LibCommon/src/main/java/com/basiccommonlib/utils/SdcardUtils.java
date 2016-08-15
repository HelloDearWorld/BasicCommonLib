package com.basiccommonlib.utils;

import android.os.Environment;

public class SdcardUtils {

    private SdcardUtils() {
    }


    public static boolean isExitsSdcard() {
        if (android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }

    public static String getSdcardPath() {
        if (isExitsSdcard()) {
            return Environment.getExternalStorageDirectory().toString();
        } else {
            return "";
        }

    }

}
