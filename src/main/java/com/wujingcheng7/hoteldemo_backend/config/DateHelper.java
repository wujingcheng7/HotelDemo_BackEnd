package com.wujingcheng7.hoteldemo_backend.config;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    /**
     * 将java.util.Date 格式转换为字符数组格式'YYYY-MM-DD'<br>

     */
    public static String DateToString(Date time) {
        if (null == time) {
            return "";
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");
            String ymd = format.format(time);
            return ymd;
        } catch (Exception e) {
        }
        return "";
    }
}
