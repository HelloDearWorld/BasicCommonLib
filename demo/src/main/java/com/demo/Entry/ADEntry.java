/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * ADEntry.java
 */
package com.demo.Entry;

import org.greenrobot.greendao.annotation.Entity;

/**
 * @author
 * @version 1.0
 *          <p><strong>Features draft description.主要功能介绍</strong></p>
 * @since 16/7/26 下午2:26
 */

@Entity
public class ADEntry {


    /**
     * title : 广告1
     * img : http://s3.ljy.gzshopex.com/files/preview/appfiles/201607/14/480_5787005c055e0.jpg
     * url : http://wap.ljy.gzshopex.com
     * type : 1
     * extra : null
     */
    private String title;
    private String img;
    private String url;
    private int type;
    private String extra;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

}