package com.databinding.demo.util;

import android.content.res.Resources;

public class ScreenUtil {

    public static int dp2px(float dpValue) {
        return (int) (0.5F + dpValue * Resources.getSystem().getDisplayMetrics().density);
    }
}
