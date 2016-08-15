/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * ImageUtil.java
 */
package com.basiccommonlib.utils;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;

import com.basiccommonlib.CommonApplication;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.UUID;

/**
 * @author
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 * @since 16/7/11 下午3:16
 */
public class ImageUtil {


    public static void showImage(String imagreUrl, ImageView imageView) {

        ImageLoader.getInstance().displayImage(imagreUrl, imageView, CommonApplication.mOptions, null);
    }

    public static void showImage(String imagreUrl, ImageView imageView, ImageLoadingListener imageLoadingListener) {

        ImageLoader.getInstance().displayImage(imagreUrl, imageView, CommonApplication.mOptions, imageLoadingListener);
    }

    public static void showImage(String imagreUrl, ImageView imageView, DisplayImageOptions mOptions) {

        ImageLoader.getInstance().displayImage(imagreUrl, imageView, mOptions, null);

    }

    public static void showImage(String imagreUrl, ImageView imageView, DisplayImageOptions mOptions, ImageLoadingListener imageLoadingListener) {

        ImageLoader.getInstance().displayImage(imagreUrl, imageView, mOptions, imageLoadingListener);

    }


    public static DisplayImageOptions getDisplayImageOptions(int radius) {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .bitmapConfig(Bitmap.Config.ARGB_8888)// 设置图片的解码类型
                .cacheInMemory(true)// 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)// 设置下载的图片是否缓存在SD卡中
                .displayer(new RoundedBitmapDisplayer(radius))
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();// 构建完成
        return options;
    }

    public static void showImage(Context ctx, int drawableID, ImageView imageView) {
        if (drawableID > 0) {
            imageView.setImageDrawable(AndroidVersionAdapterUtil.getDrawable(ctx, drawableID));
        }
    }

    /**
     * 转换URI地址为绝对路径
     */
    public static String uriToFilePath(Context context, Uri uri) {
        if (null == uri) {
            return null;
        }
        File file = null;
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = ((Activity) context).managedQuery(uri, projection, null, null, null);
        int indexOrThrow = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        String imgPath = "";
        if (cursor.moveToFirst()) {
            imgPath = cursor.getString(indexOrThrow);
        }
        return imgPath;
    }


    public static File getScaledImageFile(String filePath, int width, int heigh, int expectSize) {
        File localFile1 = new File(filePath);
        if (localFile1.exists()) {
            Bitmap localBitmap = getScaleImageBitmap(filePath, width, heigh);
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                localBitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                File localFile2 = new File(FileUtils.TEMP_DIR + File.separator + System.currentTimeMillis() + ".png");
                BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(localFile2));
                int options = 100;
                while (baos.toByteArray().length / 1024 > expectSize) {
                    baos.reset();//重置baos即清空baos
                    options -= 5;//每次都减少5
                    localBitmap.compress(Bitmap.CompressFormat.JPEG, options, baos);
                }
                os.write(baos.toByteArray());
                os.flush();
                os.close();
                return localFile2;
            } catch (Exception localException) {
                localException.printStackTrace();
            }
        }
        return null;
    }


    public static Bitmap getScaleImageBitmap(String filePath, int width, int heigh) {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, localOptions);
        int i = calculateInSampleSize(localOptions, width, heigh);
        localOptions.inSampleSize = i;
        localOptions.inJustDecodeBounds = false;
        Bitmap localBitmap = BitmapFactory.decodeFile(filePath, localOptions);
        return localBitmap;
    }


    private static int calculateInSampleSize(BitmapFactory.Options paramOptions, int width, int heigh) {
        int i = paramOptions.outHeight;
        int j = paramOptions.outWidth;
        int k = 1;
        if ((i > heigh) || (j > width)) {
            int m = Math.round(i / heigh);
            int n = Math.round(j / width);
            k = m > n ? m : n;
        }
        return k;
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
