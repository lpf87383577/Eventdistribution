package com.shinhoandroid.eventdistribution;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;


/*
* 多根手指共同作用*/
public class MultiTouchView2 extends View {
    private static final float IMAGE_WIDTH = Utils.dpToPixel(200);

    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;

    //手指按下去的初始值
    float downX;
    float downY;
    //头像位置的坐标值
    float offsetX;
    float offsetY;
    //头像位置的初始值
    float originalOffsetX;
    float originalOffsetY;

    public MultiTouchView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        bitmap = Utils.getAvatar(getResources(), (int) IMAGE_WIDTH);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float sumX = 0;
        float sumY = 0;
        //获取手指的个数
        int pointerCount = event.getPointerCount();
        //判断是否是手指抬起
        boolean isPointerUp = event.getActionMasked() == MotionEvent.ACTION_POINTER_UP;

        for (int i = 0; i < pointerCount; i++) {
            //如果当前手指是抬起的转态就纳入计算
            if (!(isPointerUp && i == event.getActionIndex())) {
                sumX += event.getX(i);
                sumY += event.getY(i);
            }
        }
        if (isPointerUp) {
            pointerCount -= 1;
        }
        float focusX = sumX / pointerCount;
        float focusY = sumY / pointerCount;
        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
            case MotionEvent.ACTION_POINTER_UP:
                //如果有手指按下去或者抬起来，就将几个点的坐标均值重新定义为初始值
                downX = focusX;
                downY = focusY;
                //将位置值重新定义为头像的初始值
                originalOffsetX = offsetX;
                originalOffsetY = offsetY;
                break;
            case MotionEvent.ACTION_MOVE:
                offsetX = originalOffsetX + focusX - downX;
                offsetY = originalOffsetY + focusY - downY;
                invalidate();
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(bitmap, offsetX, offsetY, paint);
    }
}
