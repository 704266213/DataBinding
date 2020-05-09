package com.databinding.demo.view

import android.content.Context
import android.os.Build
import android.util.AttributeSet

import androidx.appcompat.widget.AppCompatImageView


class CornerImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : AppCompatImageView(context, attrs, defStyleAttr) {

    /**
     * 为View设置圆角效果
     *
     * @param radius 圆角半径
     */
    fun setRoundCorner(radius: Float) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // 用outline裁剪内容区域
            clipToOutline = true
            outlineProvider = RoundViewOutlineProvider(radius)
        }
    }
}
