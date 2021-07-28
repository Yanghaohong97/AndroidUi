package com.cvte.androidui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ButtonActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        button1 = findViewById(R.id.bt_1);
        button2 = findViewById(R.id.bt_2);
        button3 = findViewById(R.id.bt_3);

        button4 = findViewById(R.id.bt_4);
        setOnTouchListener();
        setListener();
    }

    private void setListener() {
        OnClick onClick = new OnClick();
        button1.setOnClickListener(onClick);
        button2.setOnClickListener(onClick);
        button3.setOnClickListener(onClick);

    }

    @SuppressLint("ClickableViewAccessibility")
    private void setOnTouchListener() {
        OnTouch onTouch = new OnTouch();
        button4.setOnTouchListener(onTouch);
    }

    public void showToast(View view) {
        Toast.makeText(ButtonActivity.this, "Button4 被点击了", Toast.LENGTH_SHORT).show();
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt_1:
                    Toast.makeText(ButtonActivity.this, "Button1 被点击了", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bt_2:
                    Toast.makeText(ButtonActivity.this, "Button2 被点击了", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bt_3:
                    Toast.makeText(ButtonActivity.this, "Button3 被点击了", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    }

    private class OnTouch implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {

            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                v.setBackgroundResource(R.drawable.button_press);

            } else if (event.getAction() == MotionEvent.ACTION_UP) {
                v.setBackgroundResource(R.drawable.button_nomal);
            }
            return false;
        }
    }
}
