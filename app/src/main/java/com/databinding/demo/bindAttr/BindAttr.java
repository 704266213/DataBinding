package com.databinding.demo.bindAttr;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.databinding.demo.R;

/**
 * 自定义属性
 *
 * @author Administrator
 */
public class BindAttr {


    @BindingAdapter({"loadImageByUrl"})
    public static void loadImage(ImageView imageView, String url) {
        Log.e("XLog", "loadImage url : " + url);
        Glide.with(imageView.getContext())
                .load(url)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
    }
}
