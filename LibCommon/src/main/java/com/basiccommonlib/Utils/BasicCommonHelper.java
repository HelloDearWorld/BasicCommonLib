/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * BasicCommonHelper.java
 */
package com.basiccommonlib.utils;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.log.LoggerInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * @author
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 * @since 16/7/7 下午2:38
 */
public class BasicCommonHelper {

    private Application application;

    public BasicCommonHelper(Application application) {
        this.application = application;
    }

    /**
     * imageLoader设置
     *
     * @return
     */
    public void initImageLoaderConfiguration() {
        File cacheDir = StorageUtils.getOwnCacheDirectory(application, DeviceUtil.getAppName(application) + File.separator + FileUtils.CACH_DIR_NAME);

        ImageLoaderConfiguration config =
                new ImageLoaderConfiguration.Builder(application).memoryCacheExtraOptions(480, 800).threadPoolSize(2)
                        .threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
                        // You can pass your own memory cache implementation/
                        .memoryCache(new WeakMemoryCache()).memoryCacheSize(1024 * 1024 * 5).diskCacheSize(50 * 1024 * 1024)
                        // .discCacheFileNameGenerator(new Md5FileNameGenerator())//
                        .tasksProcessingOrder(QueueProcessingType.LIFO).diskCacheFileCount(100)
                        .diskCache(new UnlimitedDiskCache(cacheDir))
                        .defaultDisplayImageOptions(DisplayImageOptions.createSimple())
                        .build();
        ImageLoader.getInstance().init(config);
    }

    /**
     * imageload加载配置
     *
     * @return
     */
    public DisplayImageOptions initImageLoaderOptions() {

        DisplayImageOptions mOptions = new DisplayImageOptions.Builder()
//                .showImageOnLoading(R.drawable.placeholder_six) // 设置图片在下载期间显示的图片
//                .showImageForEmptyUri(R.drawable.placeholder_six)// 设置图片Uri为空或是错误的时候显示的图片
//                .showImageOnFail(R.drawable.placeholder_six) // 设置图片加载/解码过程中错误时候显示的图片
                .bitmapConfig(Bitmap.Config.ARGB_8888)// 设置图片的解码类型
                .cacheInMemory(true)// 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)// 设置下载的图片是否缓存在SD卡中
                        // .displayer(new FadeInBitmapDisplayer(100))//
                        // 是否图片加载好后渐入的动画时间
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT).build();// 构建完成

        return mOptions;
    }

    public void initOkHttpUtils() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                // .addInterceptor(new LoggerInterceptor("TAG"))
                .connectTimeout(10000L, TimeUnit.MILLISECONDS).readTimeout(10000L, TimeUnit.MILLISECONDS)
                .addInterceptor(new LoggerInterceptor("OkHttpUtils"))
                        // 其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
