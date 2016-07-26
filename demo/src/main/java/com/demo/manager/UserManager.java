/**
 * Copyright (C) © 2016
 * LuckyNest
 * UserManager.java
 */
package com.demo.manager;

import android.content.Context;

import com.basiccommonlib.Utils.okhttp.GenericsCallback;
import com.basiccommonlib.Utils.okhttp.JsonGenericsSerializator;
import com.demo.Entry.UserEntry;
import com.demo.constant.RequestConstant;
import com.demo.constant.ServerConstant;
import com.demo.helper.OkHttpHelper;

import okhttp3.Call;
import okhttp3.Request;

/**
 * @author
 * @version 1.0
 *          <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 16/7/18 下午3:28
 */
public class UserManager {

    private UserEntry userEntry;
    private boolean isLogin = false;

    private static UserManager userManager = null;
    private static final Object mLock = new Object();

    public static UserManager getInstance() {
        synchronized (mLock) {
            if (userManager == null) {
                userManager = new UserManager();
            }
        }
        return userManager;
    }

    public UserEntry getUserEntry() {
        return userEntry;
    }

    public void setUserEntry(UserEntry userEntry) {
        this.userEntry = userEntry;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public void login(Context context, final LoginListener LoginListener, String userName, String passWord) {

        new OkHttpHelper(context, ServerConstant.UserRequest.LOGIN)
                .addParams(RequestConstant.LOGIN_NAME, userName)
                .addParams(RequestConstant.LOGIN_PASS, passWord)
                .execute(new GenericsCallback() {
                    @Override
                    public void onDataError(int errorCode, String msg) {

                        if (null != LoginListener) {
                            LoginListener.LoginFailed(msg);
                        }
                    }

                    @Override
                    public void onSuccess(String responseString) {

                        UserEntry userEntry =
                                new JsonGenericsSerializator().transform(responseString, UserEntry.class);
                        if (null != userEntry) {
                            if (null != LoginListener) {
                                LoginListener.loginSuccess(0, "登录成功");
                            }
                            setUserEntry(userEntry);
                            isLogin = true;

                        } else {
                            if (null != LoginListener) {
                                LoginListener.LoginFailed("登录失败");
                            }
                        }


                    }

                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);

                        if (null != LoginListener) {
                            LoginListener.loginBefore();
                        }
                    }

                    @Override
                    public void onAfter(int id) {
                        super.onAfter(id);
                        if (null != LoginListener) {
                            LoginListener.loginFinish();
                        }
                    }
                });
    }

    private void doLogin(final Context context, final UserManager.LoginListener LoginListener) {
    }

    public interface LoginListener {
        void loginSuccess(int status, String message);

        void LoginFailed(String string);

        void loginFinish();

        void loginBefore();
    }
}