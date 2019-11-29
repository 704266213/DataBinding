package com.databinding.demo.bindTool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BindTool {

    private static SimpleDateFormat sdf;

    static {
        sdf = new SimpleDateFormat("yyyy-MM-dd");
    }

    public static String formatPrice(float price) {
        return String.format("%s元", String.valueOf(price));
    }

    public static String formatDate(Date date) {
        return sdf.format(date);
    }
}
