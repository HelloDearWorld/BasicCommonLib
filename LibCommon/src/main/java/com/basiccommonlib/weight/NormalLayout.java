/**
 * Copyright (C) © 2016
 * LuckyNest
 * NormalLayout.java
 */
package com.basiccommonlib.weight;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.basiccommonlib.R;
import com.basiccommonlib.Utils.EmptyUtil;
import com.basiccommonlib.Utils.ImageUtil;
import com.zhy.autolayout.AutoRelativeLayout;

/**
 * @author
 * @version 1.0
 *          <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 16/7/19 下午3:54
 */
public class NormalLayout extends RelativeLayout {


    private Context context;

    private ImageView normalLayout_LeftImage;
    private ImageView normalLayout_RightImage;
    private ImageView normalLayout_TopImage;
    private ImageView normalLayout_RottomImage;
    private AutoRelativeLayout normalLayout_MidText_Layout;
    private TextView normalLayout_MidText;

    public NormalLayout(Context context) {
        super(context);
    }

    public NormalLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public NormalLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NormalLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        this.context = context;

        LayoutInflater.from(getContext()).inflate(R.layout.common_normallayout, this);

        normalLayout_LeftImage = (ImageView) findViewById(R.id.normalLayout_LeftImage);
        normalLayout_RightImage = (ImageView) findViewById(R.id.normalLayout_RightImage);
        normalLayout_TopImage = (ImageView) findViewById(R.id.normalLayout_TopImage);
        normalLayout_RottomImage = (ImageView) findViewById(R.id.normalLayout_RottomImage);
        normalLayout_MidText_Layout = (AutoRelativeLayout) findViewById(R.id.normalLayout_MidText_Layout);
        normalLayout_MidText = (TextView) findViewById(R.id.normalLayout_MidText);

        initAttr(attrs);
    }


    private void initAttr(AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.commonattr_normallayout);


        int leftIcon = typedArray.getResourceId(R.styleable.commonattr_normallayout_leftIcon, R.mipmap.ic_launcher);
        int topIcon = typedArray.getResourceId(R.styleable.commonattr_normallayout_topIcon, R.mipmap.ic_launcher);
        int rightIcon = typedArray.getResourceId(R.styleable.commonattr_normallayout_rightIcon, R.mipmap.ic_launcher);
        int bottomIcon = typedArray.getResourceId(R.styleable.commonattr_normallayout_bottomIcon, R.mipmap.ic_launcher);

        float leftIconGap = typedArray.getDimension(R.styleable.commonattr_normallayout_leftIconGap, 0);
        float topIconGap = typedArray.getDimension(R.styleable.commonattr_normallayout_topIconGap, 0);
        float rightIconGap = typedArray.getDimension(R.styleable.commonattr_normallayout_rightIconGap, 0);
        float buttomIconGap = typedArray.getDimension(R.styleable.commonattr_normallayout_buttomIconGap, 0);

        String textName = typedArray.getString(R.styleable.commonattr_normallayout_textName);
        float textSize = typedArray.getDimension(R.styleable.commonattr_normallayout_textSize, 20);
        float imageSize = typedArray.getDimension(R.styleable.commonattr_normallayout_imageSize, 20);
        int textColor = typedArray.getResourceId(R.styleable.commonattr_normallayout_textColor, Color.BLACK);

        typedArray.recycle();

        ImageUtil.showImage(context, leftIcon, normalLayout_LeftImage);
        ImageUtil.showImage(context, topIcon, normalLayout_TopImage);
        ImageUtil.showImage(context, rightIcon, normalLayout_RightImage);
        ImageUtil.showImage(context, bottomIcon, normalLayout_RottomImage);

        normalLayout_LeftImage.setVisibility(View.VISIBLE);
        normalLayout_TopImage.setVisibility(View.VISIBLE);
        normalLayout_RightImage.setVisibility(View.VISIBLE);
        normalLayout_RottomImage.setVisibility(View.VISIBLE);


        if (imageSize > 0) {

            LayoutParams leftLayoutParams = (LayoutParams) normalLayout_LeftImage.getLayoutParams();
            leftLayoutParams.width = (int) imageSize;
            leftLayoutParams.height = (int) imageSize;
            normalLayout_LeftImage.setLayoutParams(leftLayoutParams);


            LayoutParams topLayoutParams = (LayoutParams) normalLayout_TopImage.getLayoutParams();
            topLayoutParams.width = (int) imageSize;
            topLayoutParams.height = (int) imageSize;
            normalLayout_TopImage.setLayoutParams(topLayoutParams);


            LayoutParams rightLayoutParams = (LayoutParams) normalLayout_RightImage.getLayoutParams();
            rightLayoutParams.width = (int) imageSize;
            rightLayoutParams.height = (int) imageSize;
            normalLayout_RightImage.setLayoutParams(rightLayoutParams);

            LayoutParams bottomLayoutParams = (LayoutParams) normalLayout_RottomImage.getLayoutParams();
            bottomLayoutParams.width = (int) imageSize;
            bottomLayoutParams.height = (int) imageSize;
            normalLayout_RottomImage.setLayoutParams(bottomLayoutParams);

        }


        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins((int) leftIconGap, (int) topIconGap, (int) rightIconGap, (int) buttomIconGap);
        normalLayout_MidText.setLayoutParams(layoutParams);

        if (!EmptyUtil.isEmpty(textName)) {
            normalLayout_MidText.setText(textName);
        }

        if (textSize > 0) {
            normalLayout_MidText.setTextSize(textSize);
        }

        if (textColor > 0) {
            normalLayout_MidText.setTextColor(getResources().getColor(textColor));
        }

        invalidate();
    }
}
