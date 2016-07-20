package com.basiccommonlib;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.basiccommonlib.activity.BaseCommonActivity;
import com.orhanobut.logger.Logger;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;

public class MainActivity extends BaseCommonActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void oncreate(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void getFromIntent() {

    }

    @Override
    public void initViews() {

        Intent intent = getIntent();
        if (intent.hasExtra("flag")) {
            intent.putExtra("flag", (Integer) 2);
        };
    }

    @Override
    public void initData() {

        // http://user.ljy.gzshopex.com/app/ver2.0.0/login.php?login_name=15875914803&login_pass=123456
        String url = "http://user.ljy.gzshopex.com/app/ver2.0.0/login.php";
        OkHttpUtils.post().url(url).addParams("login_name", "5875914803").addParams("login_pass", "123456").build()
                .execute(new StringCallback()
        {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        TextView textView = (TextView) findViewById(R.id.test);
                        textView.setText(e.getMessage());
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        TextView textView = (TextView) findViewById(R.id.test);
                        textView.setText(response);
                        Logger.json(response);
                    }
                });
    }

    Handler handler = new Handler();

}
