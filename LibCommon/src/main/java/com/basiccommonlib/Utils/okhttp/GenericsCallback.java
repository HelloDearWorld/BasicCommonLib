package com.basiccommonlib.utils.okhttp;

import okhttp3.Call;
import okhttp3.Request;

public abstract class GenericsCallback {

    public void onBefore(Request request, int id) {

    }

    public void onAfter(int id) {
    }

    public void inProgress(float progress, long total, int id) {

    }

    public void onError(Call call, Exception e, int id) {

    }

    public abstract void onDataError(int errorCode, String msg);

    public abstract void onSuccess(String responseString);


}
