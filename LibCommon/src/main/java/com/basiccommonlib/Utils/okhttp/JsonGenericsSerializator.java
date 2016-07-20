/**
 * Copyright (C) © 2016
 * LuckyNest
 * JsonGenericsSerializator.java
 */
package com.basiccommonlib.Utils.okhttp;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;

/**
 * Created by JimGong on 2016/6/23.
 */
public class JsonGenericsSerializator implements IGenericsSerializator {
    private Gson mGson = new Gson();

    @Override
    public <T> T transform(String response, Class<T> classOfT) {
        Logger.json(response);
        return mGson.fromJson(response, classOfT);
    }

    public <T> ArrayList<T> fromJsonList(String json, Class<T> cls) {
        ArrayList<T> mList = new ArrayList<T>();
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        for (final JsonElement elem : array) {
            mList.add(mGson.fromJson(elem, cls));
        }
        return mList;
    }
}
