package com.shinhoandroid.eventdistribution;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

//手势识别
public class GestureDetectorCompatActivity extends AppCompatActivity {

    GestureDetectorCompat gdc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_detector_compat);

        gdc = new GestureDetectorCompat(this, new HenGestureListener());


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gdc.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    public class HenGestureListener extends GestureDetector.SimpleOnGestureListener {

        @Override
        public boolean onDown(MotionEvent e) {

            L.e("onDown-刚刚手指接触到触摸屏的那一刹那，就是触的那一下"+e.getActionIndex());
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            L.e("onShowPress-手指按在触摸屏上，它的时间范围在按下起效，在长按之前");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            L.e("onSingleTapUp-手指离开触摸屏的那一刹那");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent down, MotionEvent event, float distanceX, float distanceY) {
            L.e("onScroll-手指在触摸屏上滑动");
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            L.e("onLongPress-手指按在持续一段时间，并且没有松开");
        }

        @Override
        public boolean onFling(MotionEvent down, MotionEvent event, float velocityX, float velocityY) {
            L.e("onFling-手指在触摸屏上迅速移动，并松开的动作"+velocityX+"---"+velocityY);
            return false;
        }

        //处理单击事件（短时间内只响应一次）
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            L.e("onSingleTapConfirmed:短时间只响应一次点击");
            return false;
        }

        //处理双击事件
        @Override
        public boolean onDoubleTap(MotionEvent e) {
            L.e("onDoubleTap:短时间只响应第二次点击");
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            L.e("onDoubleTapEvent:双击所有事件");
            return false;
        }

    }

}