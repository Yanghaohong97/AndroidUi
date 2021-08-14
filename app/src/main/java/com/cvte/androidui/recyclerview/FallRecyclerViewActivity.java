package com.cvte.androidui.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cvte.androidui.R;

public class FallRecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvFall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fall_recycler_view);
        mRvFall = findViewById(R.id.rv_fall);
        mRvFall.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRvFall.addItemDecoration(new MyItemDecoration());
        mRvFall.setAdapter(new StaggeredGridAdapter(FallRecyclerViewActivity.this, new StaggeredGridAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(FallRecyclerViewActivity.this, "pos=" + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyItemDecoration extends RecyclerView.ItemDecoration {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            int gap = getResources().getDimensionPixelOffset(R.dimen.dividerHeight2);
            outRect.set(gap, gap, gap, gap);
        }
    }
}