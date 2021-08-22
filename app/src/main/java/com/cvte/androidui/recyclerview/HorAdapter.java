package com.cvte.androidui.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.cvte.androidui.R;

//import android.support.v7.widget.RecyclerView;

/**
 * Created by Hanson on 2021/8/12.
 */

public class HorAdapter extends RecyclerView.Adapter<HorAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;

    public HorAdapter(Context context, OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    @Override
    public HorAdapter.LinearViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_linear_item_2,parent,false));
    }

    @Override
    public void onBindViewHolder(HorAdapter.LinearViewHolder holder, final int position) {
        holder.textView.setText("Hello!");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return 0;

    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class LinearViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public LinearViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_title2);
        }
    }


    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
