/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * SharePreferenceUtil.java
 */
package com.basiccommonlib.Utils;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;

import com.orhanobut.logger.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author
 * @since 16/7/11 下午2:39
 * @version 1.0
 *          <p>
 *          <strong>Features draft description.主要功能介绍</strong>
 *          </p>
 */
public class SharePreferenceUtil {

    private static final int UID_APP = 0;

    public SharePreferenceUtil() {
    }

    public static SharedPreferences.Editor getSharedPreferencesEditor(Context pContext) {
        SharedPreferences var1 = getSharedPreferences(pContext);
        return var1.edit();
    }

    public static SharedPreferences.Editor getSharedPreferencesEditor(Context pContext, int pUid) {
        SharedPreferences var2 = getSharedPreferences(pContext, pUid);
        return var2.edit();
    }

    public static SharedPreferences.Editor getSharedPreferencesEditor(Context pContext, String pPrefsName) {
        SharedPreferences var2 = getSharedPreferences(pContext, pPrefsName);
        return var2.edit();
    }

    public static SharedPreferences getdefaultSharedPreferences(Context pContext) {
        return PreferenceManager.getDefaultSharedPreferences(pContext);
    }

    public static SharedPreferences getSharedPreferences(Context pContext) {
        return getSharedPreferences(pContext, 0);
    }

    public static SharedPreferences getSharedPreferences(Context pContext, int pUid) {
        return getSharedPreferences(pContext, String.valueOf(0));
    }

    @TargetApi(11)
    public static SharedPreferences getSharedPreferences(Context pContext, int pUid, int pMode) {
        String var3 = "kobox." + String.valueOf(0) + ".sp";
        SharedPreferences var4 = pContext.getSharedPreferences(var3, pMode);
        return var4;
    }

    public static SharedPreferences getSharedPreferences(Context pContext, String pPrefsName) {
        return getSharedPreferences(pContext, pPrefsName, 0);
    }

    public static SharedPreferences getSharedPreferences(Context pContext, String pPrefsName, int pSPMode) {
        String var3 = "kobox." + pPrefsName + ".sp";
        SharedPreferences var4 = pContext.getSharedPreferences(var3, pSPMode);
        return var4;
    }

    public static SharedPreferences.Editor getSharedPreferencesEditor(Context pContext, String pPrefsName,
                                                                      int pSPMode) {
        SharedPreferences var3 = getSharedPreferences(pContext, pPrefsName, pSPMode);
        return var3.edit();
    }

    public static void clear(Context pContext, int pUid) {
        SharedPreferences.Editor var2 = getSharedPreferencesEditor(pContext, pUid);
        clear(var2, pUid);
    }

    public static void clear(SharedPreferences.Editor pEditor, int pUid) {
        if (pEditor != null) {
            pEditor.clear().commit();
        }

    }

    public static void setObject(Context pContext, String pKey, Object o) {
        SharedPreferences.Editor var3 = getSharedPreferencesEditor(pContext);
        setObject(var3, pKey, o);
    }

    public static void setObject(SharedPreferences.Editor pEditor, String pKey, Object o) {
        String var3 = null;

        try {
            var3 = writeObject(o);
        } catch (Exception var5) {
            Logger.e("setObject fail:" + pKey + var5);
        }

        pEditor.putString(pKey, var3);
        pEditor.commit();
    }

    public static Object getObject(Context pContext, String pKey) {
        SharedPreferences var2 = getSharedPreferences(pContext);
        return getObject(var2, pKey);
    }

    public static Object getObject(SharedPreferences pPreferences, String pKey) {
        Object var2 = null;
        if (pPreferences != null) {
            String var3 = pPreferences.getString(pKey, null);
            if (!TextUtils.isEmpty(var3)) {
                try {
                    var2 = readObject(var3);
                } catch (Exception var5) {
                    Logger.e("getObject error :" + pKey + var5);
                }
            }
        }

        return var2;
    }

    public static void delete(Context pContext, String pKey) {
        SharedPreferences.Editor var2 = getSharedPreferencesEditor(pContext);
        delete(var2, pKey);
    }

    public static void delete(SharedPreferences.Editor pEditor, String pKey) {
        if (pEditor != null) {
            pEditor.remove(pKey);
            pEditor.commit();
        }

    }

    public static void setBoolean(Context pContext, String pKey, boolean pValue) {
        SharedPreferences.Editor var3 = getSharedPreferencesEditor(pContext);
        setBoolean(var3, pKey, pValue);
    }

    @SuppressLint({ "CommitPrefEdits" })
    public static void setBoolean(Context pContext, String pKey, boolean pValue, int pMode) {
        SharedPreferences var4 = getSharedPreferences(pContext, 0, pMode);
        SharedPreferences.Editor var5 = var4.edit();
        setBoolean(var5, pKey, pValue);
    }

    public static void setBoolean(SharedPreferences.Editor pEditor, String pKey, boolean pValue) {
        if (pEditor != null) {
            pEditor.putBoolean(pKey, pValue);
            pEditor.commit();
        }

    }

    public static boolean getBoolean(Context pContext, String pKey, boolean pDefaultValue) {
        SharedPreferences var3 = getSharedPreferences(pContext);
        return getBoolean(var3, pKey, pDefaultValue);
    }

    public static boolean getBoolean(Context pContext, String pKey, boolean pDefaultValue, int pMode) {
        SharedPreferences var4 = getSharedPreferences(pContext, 0, pMode);
        return getBoolean(var4, pKey, pDefaultValue);
    }

    public static boolean getBoolean(SharedPreferences pPreferences, String pKey, boolean pDefaultValue) {
        return pPreferences != null ? pPreferences.getBoolean(pKey, pDefaultValue) : pDefaultValue;
    }

    public static void setString(Context pContext, String pKey, String pValue) {
        SharedPreferences.Editor var3 = getSharedPreferencesEditor(pContext);
        setString(var3, pKey, pValue);
    }

    public static void setString(SharedPreferences.Editor pEditor, String pKey, String pValue) {
        if (pEditor != null) {
            pEditor.putString(pKey, pValue);
            pEditor.commit();
        }

    }

    public static String getString(Context pContext, String pKey, String pDefaultValue) {
        SharedPreferences var3 = getSharedPreferences(pContext);
        return getString(var3, pKey, pDefaultValue);
    }

    public static String getString(SharedPreferences pPreferences, String pKey, String pDefaultValue) {
        return pPreferences != null ? pPreferences.getString(pKey, pDefaultValue) : pDefaultValue;
    }

    public static void setInt(Context pContext, String pKey, int pValue) {
        SharedPreferences.Editor var3 = getSharedPreferencesEditor(pContext);
        setInt(var3, pKey, pValue);
    }

    public static void setInt(SharedPreferences.Editor pEditor, String pKey, int pValue) {
        if (pEditor != null) {
            pEditor.putInt(pKey, pValue);
            pEditor.commit();
        }

    }

    public static int getInt(Context pContext, String pKey, int pDefaultValue) {
        SharedPreferences var3 = getSharedPreferences(pContext);
        return getInt(var3, pKey, pDefaultValue);
    }

    public static int getInt(SharedPreferences pPreferences, String pKey, int pDefaultValue) {
        return pPreferences != null ? pPreferences.getInt(pKey, pDefaultValue) : pDefaultValue;
    }

    public static void setLong(Context pContext, String pKey, long pValue) {
        SharedPreferences.Editor var4 = getSharedPreferencesEditor(pContext);
        setLong(var4, pKey, pValue);
    }

    public static void setLong(SharedPreferences.Editor pEditor, String pKey, long pValue) {
        if (pEditor != null) {
            pEditor.putLong(pKey, pValue);
            pEditor.commit();
        }

    }

    public static long getLong(Context pContext, String pKey, long pDefaultValue) {
        SharedPreferences var4 = getSharedPreferences(pContext);
        return getLong(var4, pKey, pDefaultValue);
    }

    public static long getLong(SharedPreferences pPreferences, String pKey, long pDefaultValue) {
        return pPreferences != null ? pPreferences.getLong(pKey, pDefaultValue) : pDefaultValue;
    }

    public static String writeObject(Object o) throws Exception {
        ByteArrayOutputStream var1 = new ByteArrayOutputStream();
        ObjectOutputStream var2 = new ObjectOutputStream(var1);
        var2.writeObject(o);
        var2.flush();
        var2.close();
        var1.close();
        return Base64.encodeToString(var1.toByteArray(), 0);
    }

    public static Object readObject(String object) throws Exception {
        ByteArrayInputStream var1 = new ByteArrayInputStream(Base64.decode(object, 0));
        ObjectInputStream var2 = new ObjectInputStream(var1);
        Object var3 = var2.readObject();
        var1.close();
        var2.close();
        return var3;
    }
}
