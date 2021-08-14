package com.cvte.androidui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cvte.androidui.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnRecyclerView;
    private Button mBtnCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnButton = findViewById(R.id.btn_button);
        mBtnEditText = findViewById(R.id.btn_editview);
        mBtnRadioButton = findViewById(R.id.btn_radiobutton);
        mBtnRecyclerView = findViewById(R.id.btn_recyclerview);
        mBtnCheckBox = findViewById(R.id.btn_checkbox);
        setListeners();

    }

    private void setListeners() {
        OnClick onClick = new OnClick();
        mBtnTextView.setOnClickListener(onClick);
        mBtnButton.setOnClickListener(onClick);
        mBtnEditText.setOnClickListener(onClick);
        mBtnRadioButton.setOnClickListener(onClick);
        mBtnRecyclerView.setOnClickListener(onClick);
        mBtnCheckBox.setOnClickListener(onClick);
    }

    private class OnClick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.btn_textview :
                    //跳转到TextView演示页面
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.btn_button :
                    //跳转到Button演示页面
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.btn_editview :
                    //跳转到EditText演示页面
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.btn_radiobutton :
                    //跳转到RadioButton演示页面
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.btn_checkbox :
                    //跳转到CheckBox演示页面
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.btn_recyclerview :
                    //跳转到RecyclerView演示页面
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    }
}