package com.cvte.androidui;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextViewActivity extends AppCompatActivity {
    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private TextView mTextView4;
    private TextView mTextView5;
    private TextView mTextView6;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mTextView1 = findViewById(R.id.textView1);
        mTextView2 = findViewById(R.id.textView2);

        mTextView3 = findViewById(R.id.textView3);
        mTextView3.setSelected(true);

        mTextView5 = findViewById(R.id.textView5);
        mTextView5.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);//下划线

        mTextView6 = findViewById(R.id.textView6);
        mTextView6.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);//中划线
    }
}
