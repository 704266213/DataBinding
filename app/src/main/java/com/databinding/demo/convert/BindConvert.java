package com.databinding.demo.convert;

import androidx.databinding.BindingConversion;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BindConvert {

    @BindingConversion
    public static String convertDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
}
