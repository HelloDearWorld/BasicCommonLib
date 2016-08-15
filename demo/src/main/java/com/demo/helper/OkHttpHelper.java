/**
 * Copyright (C) © 2016
 * LuckyNest
 * OkHttpHelper.java
 */
package com.demo.helper;

import android.content.Context;
import android.widget.Toast;

import com.basiccommonlib.Utils.okhttp.GenericsCallback;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.demo.constant.RequestConstant;
import com.demo.constant.ResponseCode;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Request;

/**
 * @author
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 * @since 16/7/14 下午12:00
 */
public class OkHttpHelper {


    private Context context;
    private String url = "";

    private boolean ifToastError = true;
    private boolean ifShowLoading = true;

    private PostFormBuilder postFormBuilder;

    public OkHttpHelper(Context context, String url) {
        this.url = url;
        this.context = context;

        postFormBuilder = OkHttpUtils.post()//
                .url(url);

    }

    public OkHttpHelper(Context context, String url, boolean ifToastError, boolean ifShowLoading) {
        this.url = url;
        this.context = context;
        this.ifToastError = ifToastError;
        this.ifShowLoading = ifShowLoading;

        this.url = url;

        postFormBuilder = OkHttpUtils.post()//
                .url(url);
    }

    public OkHttpHelper addParams(String key, String val) {
        postFormBuilder.addParams(key, val);
        return this;
    }

    public void execute(final GenericsCallback genericsCallback) {

        postFormBuilder.build().execute(new StringCallback() {

            @Override
            public void onAfter(int id) {
                super.onAfter(id);
                if (null != genericsCallback) {

                    genericsCallback.onAfter(id);

                }
            }

            @Override
            public void onBefore(Request request, int id) {
                super.onBefore(request, id);

                if (null != genericsCallback) {

                    genericsCallback.onBefore(request, id);

                }
            }

            @Override
            public void inProgress(float progress, long total, int id) {
                super.inProgress(progress, total, id);

                if (null != genericsCallback) {

                    genericsCallback.inProgress(progress, total, id);

                }
            }

            @Override
            public void onError(Call call, Exception e, int id) {

                Logger.d(e.getMessage() + id);
                if (null != genericsCallback) {

                    genericsCallback.onError(call, e, id);

                }
            }

            @Override
            public void onResponse(String response, int id) {
                Logger.json(response);
                Logger.d(response);

                JsonObject jsonObject = new JsonParser().parse(response).getAsJsonObject();

                if (jsonObject.has(RequestConstant.CODE)) {// 有状态码返回

                    if (jsonObject.get(RequestConstant.CODE).getAsInt() == ResponseCode.CODE_SUCCESS
                            && jsonObject.has(RequestConstant.DATA)) {// 请求状态成功

                        if (null != genericsCallback) {

                            String dataString = jsonObject.get(RequestConstant.DATA).toString();

                            genericsCallback.onSuccess(dataString);
                        }
                    } else {// 请求状态失败

                        if (jsonObject.has(RequestConstant.MSG)) {// 有提示信息返回

                            if (null != genericsCallback) {
                                genericsCallback.onDataError(jsonObject.get(RequestConstant.CODE).getAsInt(),
                                        jsonObject.get(RequestConstant.MSG).getAsString());

                            }
                            toastErrorMsg(jsonObject.get(RequestConstant.MSG).getAsString());

                        } else {// 无提示信息返回

                            if (null != genericsCallback) {
                                genericsCallback.onDataError(jsonObject.get(RequestConstant.CODE).getAsInt(),
                                        "对不起,程序出现了未知错误,请稍后重试");

                            }
                            toastErrorMsg("对不起,程序出现了未知错误,请稍后重试");
                        }

                    }
                } else {// 无状态码返回

                    if (null != genericsCallback) {
                        genericsCallback.onDataError(ResponseCode.CODE_UNKNOWN_ERROR, "对不起,程序出现了未知错误,请稍后重试");

                    }
                    toastErrorMsg("对不起,程序出现了未知错误,请稍后重试");
                }
            }
        });
    }

    private void toastErrorMsg(String msg) {
        if (ifToastError) {

            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        }
    }

}
