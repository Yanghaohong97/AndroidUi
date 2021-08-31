package com.cvte.androidui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressActivity extends AppCompatActivity {
    private Button mBtnStart, mBtnProgressDialog1, mBtnProgressDialog2;
    private ProgressBar mProgressBar2;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (mProgressBar2.getProgress() < 100) {
                mHandler.postDelayed(runnable,500);
//                mProgressBar2.setProgress(mProgressBar2.getProgress()+5);
//                mHandler.sendEmptyMessageDelayed(0, 500);
            } else {
                Toast.makeText(ProgressActivity.this, "加载完成", Toast.LENGTH_SHORT).show();
            }
        }
    };

    Runnable runnable = new Runnable() {

        @Override
        public void run() {
            mProgressBar2.setProgress(mProgressBar2.getProgress()+5);
            mHandler.sendEmptyMessage(0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        mBtnStart = findViewById(R.id.btn_start);
        mProgressBar2 = findViewById(R.id.ProgressBar2);
        mBtnProgressDialog1 = findViewById(R.id.btn_progressDialog1);
        mBtnProgressDialog2 = findViewById(R.id.btn_progressDialog2);


        mBtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.sendEmptyMessageDelayed(0, 500);
            }
        });

        mBtnProgressDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在加载");
                progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        Toast.makeText(ProgressActivity.this,"cancel...", Toast.LENGTH_SHORT).show();
                    }
                });
//                progressDialog.setCancelable(false);
                progressDialog.show();
            }
        });
        mBtnProgressDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProgressDialog progressDialog = new ProgressDialog(ProgressActivity.this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progressDialog.setTitle("提示");
                progressDialog.setMessage("正在下载...");
                progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "棒", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //
                    }
                });
                progressDialog.show();
            }
        });
    }


}