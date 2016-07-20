/**
 * Copyright (C) © 2016
 * LuckyNest
 * NormalLayout.java
 */
package com.basiccommonlib.weight;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.basiccommonlib.R;

/**
 * @author
 * @version 1.0
 *          <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 16/7/19 下午3:54
 */
public class KeyValueLayout extends RelativeLayout {


    private Context context;


    private TextView kv_Key_Name;
    private TextView kv_Key_Name_Symbol;
    private TextView kv_Value_Symbol;
    private TextView kv_Value_Name;


    public KeyValueLayout(Context context) {
        super(context);
        initView(context);
    }

    public KeyValueLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public KeyValueLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public KeyValueLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;

        LayoutInflater.from(getContext()).inflate(R.layout.common_key_value_layout, this);


        kv_Key_Name = (TextView) findViewById(R.id.kv_Key_Name);
        kv_Key_Name_Symbol = (TextView) findViewById(R.id.kv_Key_Name_Symbol);
        kv_Value_Symbol = (TextView) findViewById(R.id.kv_Value_Symbol);
        kv_Value_Name = (TextView) findViewById(R.id.kv_Value_Name);


    }
}
