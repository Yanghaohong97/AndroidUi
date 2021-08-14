package com.cvte.androidui.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cvte.androidui.R;

public class MixLineatRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvMixLinear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mix_lineat_recycler_view);
        mRvMixLinear = findViewById(R.id.rv_mix_linear);
        mRvMixLinear.addItemDecoration(new MyDecoration());
        mRvMixLinear.setLayoutManager(new LinearLayoutManager(MixLineatRecyclerViewActivity.this));
        mRvMixLinear.setAdapter(new MixLinearAdapter(MixLineatRecyclerViewActivity.this, new MixLinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(MixLineatRecyclerViewActivity.this, "pos:"+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelOffset(R.dimen.dividerHeight);
            outRect.set(0, 0, 0, gap);
        }
    }
}