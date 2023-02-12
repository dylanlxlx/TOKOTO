package com.dylanlxlx.tokoto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


@SuppressLint("CustomSplashScreen")
public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private Button c_btn;
    private ViewFlipper viewFlipper;
    private GestureDetector detector;
    private MyGestureListener mMyGestureListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        c_btn = findViewById(R.id.splash_continue);
        c_btn.setOnClickListener(this);
        viewFlipper = findViewById(R.id.splash_view_flipper);
        mMyGestureListener = new MyGestureListener();
        detector = new GestureDetector(this, mMyGestureListener);
//        viewFlipper.startFlipping();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return detector.onTouchEvent(event);
    }

    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

        private final static int MIN_MOVE = 200;

        @Override
        public boolean onFling(@NonNull MotionEvent e1, @NonNull MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > MIN_MOVE) {
                viewFlipper.setInAnimation(getApplicationContext(), R.anim.right_in);
                viewFlipper.setOutAnimation(getApplicationContext(), R.anim.right_out);
                viewFlipper.showNext();
            } else if (e2.getX() - e1.getX() > MIN_MOVE) {
                viewFlipper.setInAnimation(getApplicationContext(), R.anim.left_in);
                viewFlipper.setOutAnimation(getApplicationContext(), R.anim.left_out);
                viewFlipper.showPrevious();
            }
            return true;
        }
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(SplashActivity.this, SigninActivity.class);
        startActivity(intent);
    }

}