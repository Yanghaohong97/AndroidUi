package com.cvte.androidui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cvte.androidui.gridview.GridViewActivity;
import com.cvte.androidui.listview.ListViewActivity;
import com.cvte.androidui.recyclerview.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnRecyclerView;
    private Button mBtnCheckBox;
    private Button mBtnImageView;
    private Button mBtnListView;
    private Button mBtnGridView;
    private Button mBtnLifeCycle;
    private Button mBtnJump;
    private Button mBtnFragment;
    private Button mBtnWebView;
    private Button mBtnToast;
    private Button mBtnDialog;
    private Button mBtnProgress;

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
        mBtnImageView = findViewById(R.id.btn_imageview);
        mBtnListView = findViewById(R.id.btn_listview);
        mBtnGridView = findViewById(R.id.btn_gridview);
        mBtnLifeCycle = findViewById(R.id.btn_lifecycle);
        mBtnJump = findViewById(R.id.btn_jump);
        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnWebView = findViewById(R.id.btn_webview);
        mBtnToast = findViewById(R.id.btn_toast);
        mBtnDialog = findViewById(R.id.btn_dialog);
        mBtnProgress = findViewById(R.id.btn_progress);
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
        mBtnImageView.setOnClickListener(onClick);
        mBtnListView.setOnClickListener(onClick);
        mBtnGridView.setOnClickListener(onClick);
        mBtnLifeCycle.setOnClickListener(onClick);
        mBtnJump.setOnClickListener(onClick);
        mBtnFragment.setOnClickListener(onClick);
        mBtnWebView.setOnClickListener(onClick);
        mBtnToast.setOnClickListener(onClick);
        mBtnDialog.setOnClickListener(onClick);
        mBtnProgress.setOnClickListener(onClick);
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
                case R.id.btn_imageview:
                    //跳转到ImageView演示界面
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.btn_listview:
                    //跳转到ListView演示界面
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.btn_gridview:
                    //跳转到GridView演示界面
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.btn_lifecycle:
                    //跳转到LifeCycle演示界面
//                    intent = new Intent(MainActivity.this, LifeCycleActivity.class);
                    break;
                case R.id.btn_jump:
                    //跳转到AActivity演示界面
//                    intent = new Intent(MainActivity.this, AActivity.class);
                    break;
                case R.id.btn_fragment:
                    //跳转到Fragment演示界面
//                    intent = new Intent(MainActivity.this, ContainerActivity.class);
                    break;
                case R.id.btn_recyclerview :
                    //跳转到RecyclerView演示页面
                    intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    break;
                case R.id.btn_webview :
                    //跳转到WebView演示页面
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case R.id.btn_toast:
                    //跳转到Toast演示页面
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.btn_dialog:
                    //跳转到Dialog演示界面
                    intent = new Intent(MainActivity.this, DialogActivity.class);
                    break;
                case R.id.btn_progress:
                    //跳转到Progress演示页面
                    intent = new Intent(MainActivity.this, ProgressActivity.class);
                    break;
                default:
                    break;
            }
            startActivity(intent);
        }
    }
}