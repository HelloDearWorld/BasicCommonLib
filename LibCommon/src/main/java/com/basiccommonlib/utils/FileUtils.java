package com.basiccommonlib.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.webkit.MimeTypeMap;


import java.io.File;
import java.text.DecimalFormat;

public final class FileUtils {

    //临时文件存放目录
    public static final String TEMP_DIR_NAME = "temp";
    //缓存文件存放目录
    public static final String CACH_DIR_NAME = "cach";
    //日志文件存放目录
    public static final String LOG_DIR_NAME = "log";
    //错误日志存放目录
    public static final String CRASH_DIR_NAME = "crash";
    //临时文件目录
    public static File TEMP_DIR = null;
    //本地缓存存放目录
    public static File CACHE_DIR = null;
    //日志存放目录
    public static File LOG_DIR = null;
    //错误目录文件
    public static File CRASH_DIR = null;

    private FileUtils() {
    }

    /**
     * 初始化文件目录
     */
    public static void initFileDir(Context context) {
        String root;
        if (SdcardUtils.isExitsSdcard()) {
            root = Environment.getExternalStorageDirectory().toString();
        } else {
            root = context.getCacheDir().toString();
        }

        root = root + File.separator + DeviceUtil.getAppName(context);


        TEMP_DIR = new File(root + File.separator + TEMP_DIR_NAME + File.separator);
        TEMP_DIR.mkdirs();

        CACHE_DIR = new File(root + File.separator + CACH_DIR_NAME + File.separator);
        CACHE_DIR.mkdirs();

        LOG_DIR = new File(root + File.separator + LOG_DIR_NAME + File.separator);
        LOG_DIR.mkdirs();

        CRASH_DIR = new File(root + File.separator + CRASH_DIR_NAME + File.separator);
        CRASH_DIR.mkdirs();
    }

    //删除文件夹
    private static void delFolder(String folderPath) {
        try {
            delAllFile(folderPath); //删除完里面所有内容
            File myFilePath = new File(folderPath);
            myFilePath.delete(); //删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除指定文件夹下所有文件
    public static boolean delAllFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return false;
        }
        if (!file.isDirectory()) {
            return false;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                delFolder(path + "/" + tempList[i]);//再删除空文件夹
            }
        }
        return true;
    }

}
