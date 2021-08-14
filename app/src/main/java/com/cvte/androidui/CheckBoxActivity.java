package com.cvte.androidui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity {
    private CheckBox mCheckBoxAndroid, mCheckBoxIos, mCheckBoxH5, mCheckBoxOther, mCheckBoxJava, mCheckBoxCpp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        mCheckBoxAndroid = findViewById(R.id.checkbox_andorid);
        mCheckBoxIos = findViewById(R.id.checkbox_ios);
        mCheckBoxH5 = findViewById(R.id.checkbox_h5);
        mCheckBoxOther = findViewById(R.id.checkbox_other);
        mCheckBoxJava = findViewById(R.id.checkbox_java);
        mCheckBoxCpp = findViewById(R.id.checkbox_cpp);

        mCheckBoxAndroid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"Android选中":"Android未选中",Toast.LENGTH_SHORT).show();
            }
        });

        mCheckBoxIos.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"IOS选中":"IOS未选中",Toast.LENGTH_SHORT).show();
            }
        });

        mCheckBoxH5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"H5选中":"H5未选中",Toast.LENGTH_SHORT).show();
            }
        });

        mCheckBoxOther.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"其他 选中":"其他 未选中",Toast.LENGTH_SHORT).show();
            }
        });

        mCheckBoxJava.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"Java 选中":"Java 未选中",Toast.LENGTH_SHORT).show();
            }
        });

        mCheckBoxCpp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(CheckBoxActivity.this,isChecked?"C++ 选中":"C++ 未选中",Toast.LENGTH_SHORT).show();
            }
        });

    }
}