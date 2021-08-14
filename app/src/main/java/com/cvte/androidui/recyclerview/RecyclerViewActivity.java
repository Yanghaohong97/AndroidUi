package com.cvte.androidui.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cvte.androidui.R;

public class RecyclerViewActivity extends AppCompatActivity {
    private Button mBtnLinear;
    private Button mBtnHor;
    private Button mBtnGrid;
    private Button mBtnFall;
    private Button mBtnMixLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mBtnLinear = findViewById(R.id.btn_linear_recyclerview);
        mBtnMixLinear = findViewById(R.id.btn_mix_linear_recyclerview);
        mBtnHor = findViewById(R.id.btn_hor_recyclerview);
        mBtnGrid = findViewById(R.id.btn_grid_recyclerview);
        mBtnFall = findViewById(R.id.btn_fall_recyclerview);


        mBtnLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this,LinearRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnHor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, HorRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, GridRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnFall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, FallRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        mBtnMixLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewActivity.this, MixLineatRecyclerViewActivity.class);
                startActivity(intent);
            }
        });

    }
}