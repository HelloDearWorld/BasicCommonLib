/**
 * Copyright (C) © 2016
 * BasicCommonLib
 * EmptyUtil.java
 */
package com.basiccommonlib.utils;

import java.util.List;
import java.util.Map;

/**
 * @author
 * @since 16/7/7 下午3:38
 * @version 1.0
 * <p><strong>Features draft description.主要功能介绍</strong></p>
 */
public class EmptyUtil {


    public static boolean isEmpty(String[] strings) {

        if (null == strings) {
            return true;
        } else {

            if (strings.length > 0) {
                return false;
            } else {
                return true;
            }
        }
    }

    public static boolean isEmpty(Map map) {

        if (null == map) {
            return true;
        } else {
            return map.isEmpty();
        }
    }

    public static boolean isEmpty(List list) {

        if (null == list) {
            return true;
        } else {
            return list.isEmpty();
        }
    }

    public static boolean isEmpty(String value) {

        if (null == value) {
            return true;
        } else if ("".equals(value)) {
            return true;
        } else if (" ".equals(value)) {
            return true;
        }
        return false;
    }
}