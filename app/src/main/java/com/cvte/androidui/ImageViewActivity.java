package com.cvte.androidui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageViewActivity extends AppCompatActivity {
    private static final String TAG = "ImageViewActivity";

    private ImageView mIv4;
    private ImageView mIvIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        mIv4 = (ImageView) findViewById(R.id.iv_4);
        mIvIcon = findViewById(R.id.iv_icon);

        Glide.with(this).load("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png").into(mIv4);

        mIvIcon.setOnClickListener(onClickListener);
        mIvIcon.setOnTouchListener(onTouchListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Log.d(TAG, "onClick: ");
            // 加载动画资源
            Animation clickAnimation = AnimationUtils.loadAnimation(v.getContext(), R.anim.scale_anim);
            // 应用动画到ImageView
            v.startAnimation(clickAnimation);
            // 在这里处理按钮的点击事件
            // 可以弹出或隐藏其他视图、执行其他操作等
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
            } catch (Exception e) {
            }

        }
    };

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Log.d(TAG, "onTouch:event.getAction():" + event.getAction());
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    break;

                case MotionEvent.ACTION_MOVE:
                    break;

                case MotionEvent.ACTION_UP:
                    Runtime runtime = Runtime.getRuntime();
                    try {
                        runtime.exec("input keyevent " + KeyEvent.KEYCODE_BACK);
                    } catch (Exception e) {
                    }
                    break;
                default:
                    break;

            }
            return false;
        }
    };
}