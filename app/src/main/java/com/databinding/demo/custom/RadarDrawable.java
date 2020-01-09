package com.databinding.demo.custom;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.databinding.demo.R;

public class RadarDrawable extends Drawable implements Animator.AnimatorListener, Runnable {

    private Paint paint;

    private Bitmap bitmap;

    private int width;
    private int height;

    private Rect bitmapRect;
    private RectF drawRect;

    public RadarDrawable(Context context, int width, int height) {
        paint = new Paint();

        this.width = width;
        this.height = height;
        Log.e("XLog", "========== width:" + width);
        Log.e("XLog", "========== height:" + height);

        Bitmap bitmapRadar = BitmapFactory.decodeResource(context.getResources(), R.drawable.radar);
        bitmap = Bitmap.createScaledBitmap(bitmapRadar, width, width, false);

        Log.e("XLog", "========== bitmapWidth:" + bitmapRadar.getWidth());
        Log.e("XLog", "========== bitmapHeight:" + bitmapRadar.getHeight());

        //想要绘制图片的那一部分
        bitmapRect = new Rect(0, 0, bitmapRadar.getWidth(), bitmapRadar.getHeight());

        //图片要绘制在View中的坐标
        drawRect = new RectF(0, 0, width, width);
    }

    @Override
    public void draw(Canvas canvas) {

        /**
         * bitmapRect就是想要绘制图片的那一部分
         *
         * drawRect是这个图片要绘制在View中的坐标
         */
        canvas.drawBitmap(bitmap, bitmapRect, drawRect, null);

//        canvas.save();
//        canvas.rotate(degree,rect.left+(rect.right-rect.left)/2,rect.top+(rect.bottom-rect.top)/2); //以矩形中心点旋转图形
//        canvas.drawRect(rect, paint);
//        if(isEdit){
//            canvas.drawBitmap(deleteIcon, deleteRect.left, deleteRect.top, paint);
//            canvas.drawBitmap(resizeIcon, resizeRect.left, resizeRect.top, paint);
//            canvas.drawBitmap(rotateIcon, rotateRect.left, rotateRect.top, paint);
//        }
//        canvas.restore();

    }

    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSPARENT;
    }


    @Override
    public void run() {

    }


    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {

    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
